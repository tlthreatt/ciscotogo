package com.cisco.ciscotogo.model;

public class MenuItem {
	private String itemID;
	private String price;
	private String description;
	public MenuItem(String itemID, String price, String description) {
		super();
		this.itemID = itemID;
		this.price = price;
		this.description = description;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
