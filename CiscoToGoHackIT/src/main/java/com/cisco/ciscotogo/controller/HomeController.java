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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cisco.ciscotogo.model.DailyMenu;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.MenuCategory;
import com.cisco.ciscotogo.model.MenuItem;

@Controller
public class HomeController{
	
	private final String XML_FILE_LOCATION = "C:\\Users\\eyaklin\\Desktop\\orderrequest.xml";

	@RequestMapping(value = "/orderToGo", method = RequestMethod.GET)
	public String dashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<NameValuePair> list = new ArrayList<NameValuePair>(1);
		
		//String request_xml = readTextFile(XML_FILE_LOCATION);
		
		//System.out.println(request_xml);
		
		//list.add(new BasicNameValuePair("xml", ""));
		//System.out.println(list.get(0).getValue());
		
		//System.out.println("The order request : \n" + httpPostResponse("http://txpfdbappdev002:7001/WebexPFProxyWS/CatalogTransactionService", list));
		return "orderToGo";
	}
	
	@RequestMapping(value="/getFoodDetails", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody ArrayList<Location> getFoodDetails(HttpServletRequest request, HttpServletResponse response){
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<DailyMenu> dailyMenusJ = new ArrayList<DailyMenu>();
		ArrayList<MenuItem> menuItemsJ = new ArrayList<MenuItem>();
		ArrayList<MenuCategory> menuCategoriesJ = new ArrayList<MenuCategory>();
		ArrayList<DailyMenu> dailyMenusFLSC2 = new ArrayList<DailyMenu>();
		ArrayList<MenuItem> menuItemsFLSC2 = new ArrayList<MenuItem>();
		ArrayList<MenuCategory> menuCategoriesFLSC2 = new ArrayList<MenuCategory>();
		
		//start bldg J things
		MenuItem chickenSandwich = new MenuItem("Chicken Sandwich", "$4.95", "Grilled chicken breast sandwich with lettuce, tomato, and american cheese");
		MenuItem pepsi = new MenuItem("Pepsi", "$1.50", "Regular 16oz Pepsi");
		MenuItem regularLays = new MenuItem("Original Lays Chips", "$1.00", "Original Lays Potato Chips");
		menuItemsJ.add(chickenSandwich); menuItemsJ.add(regularLays); menuItemsJ.add(pepsi);
		
		MenuCategory americanGrill = new MenuCategory("American Grill", menuItemsJ);
		menuCategoriesJ.add(americanGrill);
		
		DailyMenu mondayMenu = new DailyMenu("Monday", menuCategoriesJ);
		dailyMenusJ.add(mondayMenu);
		
		Location bldgJ = new Location("Building J", "100 Tasman Dr. San Jose CA", dailyMenusJ);
		//end bldg J things
		
		//start bldg FLSC2 things
		MenuItem hamburger = new MenuItem("Hamburger", "$5.95", "Lean hamburger meat, grilled with lettuce, tomato, american cheese, ketchup, and mustard");
		MenuItem sprite = new MenuItem("Sprite", "$1.50", "Regular 16oz Sprite");
		MenuItem bbqLays = new MenuItem("BBQ Lays Chips", "$1.00", "BBQ Lays Potato Chips");
		menuItemsFLSC2.add(hamburger); menuItemsFLSC2.add(bbqLays); menuItemsFLSC2.add(sprite);
		
		MenuCategory americanGrillFLSC2 = new MenuCategory("American Grill", menuItemsFLSC2);
		menuCategoriesFLSC2.add(americanGrillFLSC2);
		
		DailyMenu mondayMenuFLSC2 = new DailyMenu("Monday", menuCategoriesFLSC2);
		dailyMenusFLSC2.add(mondayMenuFLSC2);
		
		Location bldgFLSC2 = new Location("Building Freedom Circle Tower 2", "3979 Freedom Circle Santa Clara CA", dailyMenusFLSC2);
		//end FLSC2 things
		
		locations.add(bldgJ);
		locations.add(bldgFLSC2);
		return locations;
	}
	
	@RequestMapping(value="/processOrder", method = RequestMethod.GET, produces = "application/json")
	public String processOrder(HttpServletRequest request, HttpServletResponse response){
		return "processOrder";
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
	

	private static String readTextFile(String filename) throws IOException{
		FileInputStream fis = new FileInputStream(filename);
		int x = fis.available();
		byte b[] = new byte[x];
		fis.read(b);
		String content = new String(b);
		return content;
	}
}