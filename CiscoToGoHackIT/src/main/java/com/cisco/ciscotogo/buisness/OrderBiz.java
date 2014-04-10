package com.cisco.ciscotogo.buisness;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;

import com.cisco.ciscotogo.dao.CustomerDao;
import com.cisco.ciscotogo.dao.ItemDao;
import com.cisco.ciscotogo.dao.OrderDao;
import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Item;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.Order;
import com.cisco.ciscotogo.model.OrderItem;

public class OrderBiz {
	public static void main(String[] args) throws JSONException {
		Set<Order> orders = FetchRecentOrders("{'id':1}");
		System.out.println("size = " + orders.size());
	}
	public static void CreateOrder(String json) throws JSONException {
		JSONObject jsonObject = (JSONObject)new JSONTokener(json).nextValue();
		Order order = new Order();
		order.setCustomer(new Customer((String)jsonObject.get("customer_cec")));
		Calendar calendar = Calendar.getInstance();
		order.setDate(calendar.getTime());
		order.setStatus("Pending");
		order.setLocation(new Location((Integer)jsonObject.get("location_id")));
		
		
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		//double totalAmount = 0;
		JSONArray jsonArray = jsonObject.getJSONArray("items");
		ItemDao itemDao = new ItemDao();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject itemJson = jsonArray.getJSONObject(i);
			// {id:1, price:2.00}
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			Item item = new Item(itemJson.getInt("id"));
			orderItem.setItem(item);
			//totalAmount += itemJson.getDouble("list_price");
			orderItem.setCost(itemJson.getDouble("list_price"));
			orderItems.add(orderItem);
		}
		order.setAmount(jsonObject.getDouble("total_amount"));
		order.setOrderItems(orderItems);
		
		OrderDao.save(order);
		
	}
	
	public static List<Order> FetchCurrentOrders(Customer customer) {
		return OrderBiz.FetchCurrentOrders(customer, 5);
	}
	public static List<Order> FetchCurrentOrders(Customer customer, int maxResults) {
		List<Order> orders = OrderDao.getAllRecent(customer, maxResults);
		return orders;
	}
	public static Customer FetchCustomerAndRecentOrders(String json) throws JSONException {
		JSONObject jsonObject = (JSONObject)new JSONTokener(json).nextValue();
		Customer customer = CustomerDao.get(jsonObject.getString("cec"));
		//double balance = jsonObject.getDouble("customer_balance");
		//System.out.println("balance == " + balance);
		//customer.setBalance(balance);
		customer.setOrders(OrderBiz.FetchCurrentOrders(customer));
		return customer;
	}
	public static Set<Order> FetchRecentOrders(String json) throws JSONException {
		JSONObject jsonObject = (JSONObject)new JSONTokener(json).nextValue();
		Location location = new Location(jsonObject.getInt("id"));
		Set<Order> orders = FetchRecentOrders(location);
		System.out.println("OrderBiz orders size == " + orders.size());
		return orders;
	}
	public static Set<Order> FetchRecentOrders(Location location) {
		return OrderDao.getAllRecent(location);
	}
	public static void SetOrderToReady(String json) throws JSONException {
		JSONObject jsonObject = (JSONObject)new JSONTokener(json).nextValue();
		Order order = new Order(jsonObject.getInt("id"));
		OrderDao.setOrderToReady(order);
		
	}
	public static void SetOrderToComplete(String json) throws JSONException {
		JSONObject jsonObject = (JSONObject)new JSONTokener(json).nextValue();
		Order order = new Order(jsonObject.getInt("id"));
		OrderDao.setOrderToComplete(order);
		
	}

}
