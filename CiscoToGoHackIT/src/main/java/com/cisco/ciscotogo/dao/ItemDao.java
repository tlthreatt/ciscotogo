package com.cisco.ciscotogo.dao;

import org.hibernate.Session;

import com.cisco.ciscotogo.model.Item;

public class ItemDao extends Dao implements DaoInterface<Item> {

	@Override
	public Item get(int id) {
		Session session = getSession();
		Item item = (Item) session.get(Item.class, id);
		return item;
	}

	@Override
	public void save(Item item) {
		Session session = getSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		
	}

}
