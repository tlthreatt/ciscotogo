package com.cisco.ciscotogo.dao;

import org.hibernate.Session;

import com.cisco.ciscotogo.model.Item;

public class ItemDao extends Dao  {

	
	public static Item get(int id) {
		session = getSession();
		Item item = (Item) session.get(Item.class, id);
		return item;
	}


	public static void save(Item item) {
		session = getSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		session.close();
		
	}

	
	public static void delete(Item item) {
		session = getSession();
		session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
		session.close();
	}

}
