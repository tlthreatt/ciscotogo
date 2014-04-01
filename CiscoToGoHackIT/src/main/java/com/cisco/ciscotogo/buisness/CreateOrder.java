package com.cisco.ciscotogo.buisness;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;

import com.cisco.ciscotogo.dao.ItemDao;
import com.cisco.ciscotogo.dao.OrderDao;
import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Item;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.Order;
import com.cisco.ciscotogo.model.OrderItem;

public class CreateOrder {
	public static void CreateOrder(String json) throws JSONException {
		JSONObject jsonObject = (JSONObject)new JSONTokener(json).nextValue();
		Order order = new Order();
		order.setCustomer(new Customer((String)jsonObject.get("customer_cec")));
		Calendar calendar = Calendar.getInstance();
		order.setDate(calendar.getTime());
		order.setStatus("Pending");
		order.setLocation(new Location((Integer)jsonObject.get("location_id")));
		
		
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		double totalAmount = 0;
		JSONArray jsonArray = jsonObject.getJSONArray("item_ids");
		ItemDao itemDao = new ItemDao();
		for (int i = 0; i < jsonArray.length(); i++) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			// The UI should send back the price so I dont have to query the database for it, especially like this:
			Item item = itemDao.get(jsonArray.getInt(i));
			//Item item = new Item(jsonArray.getInd(i));
			orderItem.setItem(item);
			totalAmount += item.getListPrice();
			orderItem.setCost(item.getListPrice());
			orderItems.add(orderItem);
		}
		order.setAmount(totalAmount);
		order.setOrderItems(orderItems);
		OrderDao orderDao = new OrderDao();
		orderDao.save(order);
		
	}
}
