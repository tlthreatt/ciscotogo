package com.cisco.ciscotogo.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cisco.ciscotogo.buisness.CreateOrder;
import com.cisco.ciscotogo.buisness.Debug;
import com.cisco.ciscotogo.model.Item;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.Order;
import com.cisco.ciscotogo.model.OrderItem;
import com.cisco.ciscotogo.model.OrderList;
import com.cisco.ciscotogo.model.SendMailTLS;

@Controller
public class HomeController{
	
	private final String CLAYTONS_REST_THINGY_URL = "http://10.155.252.176:10080/HackItOrderMgmtRestProejct/rest/order/";

	@RequestMapping(value = "/orderToGo", method = RequestMethod.GET)
	public String dashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<NameValuePair> list = new ArrayList<NameValuePair>(1);
		
		list.add(new BasicNameValuePair("xml", ""));
		System.out.println(list.get(0).getValue());
		//System.out.println("The order request : \n" + httpPostResponse(CLAYTONS_REST_THINGY_URL+"1/tathreat/Chicken%20Sandwich/Building%20J/6/Pending", list));
		//System.out.println("The order request : \n" + httpGetResponse(CLAYTONS_REST_THINGY_URL+"1"));
		return "orderToGo";
	}
	
	@RequestMapping(value="/getOrderDetails", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Order> getOrderDetails(HttpServletRequest request, HttpServletResponse response){
		OrderList allOrders = new OrderList();
		ArrayList<Order> orders = new ArrayList<Order>();
		Order order = new Order();order.setId(1);
		Item item = new Item(0, "test","test", 10);
		OrderItem orderItem = new OrderItem(order, item);
		order.setOrderItems(new ArrayList<OrderItem>());
		order.getOrderItems().add(orderItem);
		orders.add(order);
		//Item item = new Item(1, "ChickenSandwich", "$4.95", "A chicken sandwich");
		//Item item2 = new Item(2, "Sprite", "$1.50", "Sprite");
		//items.add(item); items.add(item2);
		//Customer customer = new Customer("Taylor", "Threatt", "tathreat", 883213, "Freedom Circle Tower 2", 0.00, "Freedom Circle Tower 2", item.getItemID());
		//start order 1 - a completed order
		//Order order1 = new Order("Completed", customer, items, "Freedom Circle Tower 2", 06.45, 132435);
		//Order order2 = new Order("Cancelled", customer, items, "Freedom Circle Tower 2", 06.45, 354657);
		//Order order3 = new Order("Pending", customer, items, "Freedom Circle Tower 2", 06.45, 687980);
		
		//orders.add(order1); orders.add(order2); orders.add(order3);
		//allOrders.setOrdrers(orders);
		
		
		//return allOrders;
		return orders;
	}
	
	@RequestMapping(value="/getFoodDetails", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<Location> getFoodDetails(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("Calling Initialize Database:");
		return Debug.InitializeDatabase();
	}
	
	@RequestMapping(value="/processOrder", method = RequestMethod.GET, produces = "application/json")
	public String processOrder(HttpServletRequest request, HttpServletResponse response){
		return "processOrder";
	}
	
	@RequestMapping(value="/updateMenu", method = RequestMethod.GET, produces = "application/json")
	public String updateMenu(HttpServletRequest request, HttpServletResponse response){
		return "updateMenu";
	}
	
	@RequestMapping(value="/getOrderTable", method = RequestMethod.POST)
	public @ResponseBody String getOrderTable(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return httpGetResponse(CLAYTONS_REST_THINGY_URL+"1");
	}
	
	@RequestMapping(value="/orderReady", method = RequestMethod.POST)
	public @ResponseBody String orderReady(String req) throws Exception{
		System.out.println(req);
		req=req.replaceAll(" ", "%20");
		httpPostResponse(CLAYTONS_REST_THINGY_URL+req, new ArrayList<NameValuePair>());
		SendMailTLS mailer = new SendMailTLS();
		mailer.sendEmail("Taylor", "tathreat@cisco.com", 1);
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
		CreateOrder.CreateOrder(json);
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
}