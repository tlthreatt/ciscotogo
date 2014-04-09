package com.cisco.ciscotogo.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jettison.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cisco.ciscotogo.buisness.CustomerBiz;
import com.cisco.ciscotogo.buisness.EmployeeBiz;
import com.cisco.ciscotogo.buisness.LocationBiz;
import com.cisco.ciscotogo.buisness.OrderBiz;
import com.cisco.ciscotogo.misc.SendMailTLS;
import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Employee;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.Order;

@Controller
public class HomeController{
	
	private Customer currentCustomer;
	private Employee currentEmployee;
	
	private final String CLAYTONS_REST_THINGY_URL = "http://10.155.252.176:10080/HackItOrderMgmtRestProejct/rest/order/";
	@RequestMapping(value= "/customerLogin", method = RequestMethod.GET)
	public String customerLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("in /customerLogin");
		return "customerLogin";
	}
	@RequestMapping(value = "/orderToGo", method = RequestMethod.POST)
	public String dashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("in /orderToGo");
		
		/** This is loading fake test data while I code this. Before the demo it needs to have a permanent fake test data in db */
		//Debug.InitializeDatabase();
		String customerCec = (String)request.getParameter("customer_cec");
		String customerPassword = (String)request.getParameter("customer_password");
		System.out.println("customerCec = '" + customerCec + "' and pass = '" + customerPassword + "'");
		// This should also fetch the balance for the customer, which I'm hard coding in CustomerBiz.validatePassword for now.
		Customer customer = CustomerBiz.validatePassword(customerCec, customerPassword);
		if (customer != null) {
			System.out.println("BALANCE == " + customer.getBalance());
			setCurrentCustomer(customer);
			System.out.println("returning order to go");
			return "orderToGo";
		} else {
			// Something needs to show up saying they messed up username/password on page
			System.out.println("returning customer login");
			return "customerLogin";
		}
		
	}
	@RequestMapping(value="/getCustomerDetails", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody Customer getCustomerDetails(HttpServletRequest request, HttpServletResponse response) throws JSONException {
		System.out.println("BALANCE FO SHO = " + getCurrentCustomer().getBalance());
		return getCurrentCustomer();
	}
	
	@RequestMapping(value="/getOrderDetails", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Customer getOrderDetails(HttpServletRequest request, HttpServletResponse response) throws JSONException{
	//public @ResponseBody Customer getOrderDetails(@RequestParam("json") String json, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//If we assume CEC is coming in through JQuery (probably wrong), then balance would be as well
		System.out.println("in /getOrderDetails");
		String json = (String)request.getParameter("json");
		System.out.println(json);
		return OrderBiz.FetchCustomerAndRecentOrders(json);
		
	
	}
	
	@RequestMapping(value="/getFoodDetails", method = RequestMethod.POST,produces = "application/json")
	public @ResponseBody Set<Location> getFoodDetails(HttpServletRequest request, HttpServletResponse response){
	//public @ResponseBody List<Location> getFoodDetails(@RequestParam("customer_cec") String customerCec, HttpServletRequest request, HttpServletResponse response) throws Exception{
		// Ideally the customer would have a "recent_location" table to pull these from
		System.out.println("in /getFoodDetails");
		return LocationBiz.FetchLocationsAndCategoriesAndItems();
	}
	
	
	
	
	
	@RequestMapping(value= "/employeeLogin", method = RequestMethod.GET)
	public String employeeLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("in /employeeLogin");
		return "employeeLogin";
	}
	
	@RequestMapping(value="/processOrder", method = RequestMethod.GET)
	public String processOrderNoLogin(HttpServletRequest request, HttpServletResponse response) {
		if (currentEmployee == null) {
			return "employeeLogin";
		} else {
			return processOrder(request, response);
		}
	}
	@RequestMapping(value="/processOrder", method = RequestMethod.POST, produces = "application/json")
	public String processOrder(HttpServletRequest request, HttpServletResponse response){
		
		String employeeEmail = (String)request.getParameter("employee_email");
		String employeePassword = (String)request.getParameter("employee_password");

		Employee employee = EmployeeBiz.validatePassword(employeeEmail, employeePassword);
		if (employee != null) {
			setCurrentEmployee(employee);
			System.out.println("returning order to go");
			return "processOrder";
		} else {
			// Something needs to show up saying they messed up username/password on page
			System.out.println("returning customer login");
			return "employeeLogin";
		}
	}
	@RequestMapping(value="/getEmployeeDetails", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody Employee getEmployeeDetails(HttpServletRequest request, HttpServletResponse response) throws JSONException {
		System.out.println("in employee details");
		return getCurrentEmployee();
	}
	
	@RequestMapping(value="/updateMenu", method = RequestMethod.GET, produces = "application/json")
	public String updateMenu(HttpServletRequest request, HttpServletResponse response){
		return "updateMenu";
	}
	//custom2.js
	@RequestMapping(value="/getOrderTable", method = RequestMethod.POST)
	public @ResponseBody Set<Order> getOrderTable(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("in /getOrderTable");
		String json = (String)request.getParameter("json");
		System.out.println(json);
		Set<Order> orders = OrderBiz.FetchRecentOrders(json);
		return orders;
	}
	
	@RequestMapping(value="/orderReady", method = RequestMethod.POST)
	public @ResponseBody String orderReady(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String json = (String)request.getParameter("json");
		System.out.println("in /orderReady");
		System.out.println("json == " + json);
		//SendMailTLS mailer = new SendMailTLS();
		//mailer.sendEmail("Taylor", "tathreat@cisco.com", 1);
		OrderBiz.SetOrderToReady(json);
		return "success";
	}
	
	@RequestMapping(value="/orderComplete", method = RequestMethod.POST)
	public @ResponseBody String orderComplete(String req) throws Exception{
		System.out.println(req);
		req=req.replaceAll(" ", "%20");
		httpPostResponse(CLAYTONS_REST_THINGY_URL+req, new ArrayList<NameValuePair>());
		return "success";
	}
		
	@RequestMapping(value="/createOrder", method = RequestMethod.POST)
	public @ResponseBody String createOrder(@RequestParam("json") String json) throws Exception{
		System.out.println("JSON IS == " + json);
		OrderBiz.CreateOrder(json);
		//req=req.replaceAll(" ", "%20");
		//httpPostResponse(CLAYTONS_REST_THINGY_URL+req, new ArrayList<NameValuePair>());
		//SendMailTLS mailer = new SendMailTLS();
		//mailer.sendEmail("Taylor", "tathreat@cisco.com", 2);
		return "success";
	}
	
	private String httpPostResponse(String url, List<NameValuePair> list) throws Exception{
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost(url);
		
		request.setEntity(new UrlEncodedFormEntity(list));
		
		HttpResponse response = client.execute(request);
		
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());
		
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent())
			);
			
			StringBuffer result = new StringBuffer();
			String line = "";
			while((line = rd.readLine()) != null) {
				result.append(line);
			}
		
		return result.toString();
	}
	
	private String httpGetResponse(String url) throws Exception{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		
		//request.addHeader("User-Agent", USER_AGENT);
		
		HttpResponse response = client.execute(request);
		
		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent())
		);
		
		StringBuffer result = new StringBuffer();
		String line = "";
		while((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		return result.toString();
	}
	
	private static String readTextFile(String filename) throws IOException{
		FileInputStream fis = new FileInputStream(filename);
		int x = fis.available();
		byte b[] = new byte[x];
		fis.read(b);
		String content = new String(b);
		return content;
	}
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	public Employee getCurrentEmployee() {
		return currentEmployee;
	}
	public void setCurrentEmployee(Employee currentEmployee) {
		this.currentEmployee = currentEmployee;
	}
}