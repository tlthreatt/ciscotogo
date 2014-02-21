package com.cisco.ciscotogo.model;

import java.util.List;

public class DailyMenu {
	private String day;
	private List<MenuCategory> menuCategories;
	
	public DailyMenu(String day, List<MenuCategory> menuCategories) {
		super();
		this.day = day;
		this.menuCategories = menuCategories;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public List<MenuCategory> getMenuCategories() {
		return menuCategories;
	}
	public void setMenuCategories(List<MenuCategory> menuCategories) {
		this.menuCategories = menuCategories;
	}
	
	

}
