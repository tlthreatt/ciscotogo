package com.cisco.ciscotogo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Item {
	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="item_id")
	private int id;
	
	@Column(name="item_name", nullable=false)
	private String name;
	
	@Column(name="item_description", nullable=true)
	private String description;
	
	@Column(name="item_list_price", nullable=false)
	private double listPrice; // this is the list price of the item
	
	@Column(name="item_date_added", nullable=true)
	private Date dateAdded;
	
	@Column(name="item_in_stock", nullable=true)
	private boolean isInStock;
	
	@Column(name="item_photo_url", nullable=true)
	private String photoUrl;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private Category category;
	
	@OneToMany(mappedBy="item")
	private List<OrderItem> orderItems;

	public Item() {}
	
	public Item(int id, String name, String description, double listPrice) {
		setId(id);
		setName(name);
		setDescription(description);
		setListPrice(listPrice);
	}	
	public Item(int id, String name, String description, double listPrice, Date dateAdded, boolean isInStock) {
		this(id, name, description, listPrice);
		setDateAdded(dateAdded);
		setInStock(isInStock);
	}
	
	public Item(int id, String name, String description, double listPrice, Date dateAdded, boolean isInStock,
			Category category) {
		this(id, name, description, listPrice, dateAdded, isInStock);
		setMenuCategory(category);
	}
	public Item(int id, String name, String description, double listPrice, List<OrderItem> orderItems) {
		this(id, name, description, listPrice);
		setOrderItems(orderItems);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public boolean isInStock() {
		return isInStock;
	}
	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}
	public Category getMenuCategory() {
		return category;
	}
	public void setMenuCategory(Category category) {
		this.category = category;
	}
	public double getListPrice() {
		return listPrice;
	}
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
