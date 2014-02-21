package com.cisco.ciscotogo.model;

import java.util.List;

public class MenuCategory {
	private String name;
	private List<MenuItem> menuItems;
	
	public MenuCategory(String name, List<MenuItem> menuItems) {
		super();
		this.name = name;
		this.menuItems = menuItems;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	
	

}
