package com.cisco.ciscotogo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name="category")
public class Category {
	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="category_id")
	private int id;
	
	@Column(name="category_name", nullable=false)
	private String name;
	
	@Column(name="category_is_special", nullable=false)
	private boolean isSpecial; // in ('ALWAYS','MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY')
	
	@ManyToOne
	@JoinColumn(name="location_id", nullable=false)
	@JsonBackReference
	private Location location;
	
	@OneToMany(mappedBy="category") @Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<CategoryAvailability> categoryAvailabilities;
	
	@OneToMany(mappedBy="category") @Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Item> items;
	
	
	public Category() {} 
	
	
	public Category(String name) {
		setName(name);
	}
	public Category(String name, boolean isSpecial) {
		this(name);
		setSpecial(isSpecial);
	}
	public Category(String name, boolean isSpecial, List<Item> items) {
		this(name, isSpecial);
		setItems(items);
	}
	public Category(String name, boolean isSpecial, List<Item> items, Location location) {
		this(name, isSpecial, items);
		setLocation(location);
	}
	
	
	public Category(int id, String name) {
		setId(id);
		setName(name);
	}
	public Category(int id, String name, boolean isSpecial) {
		this(id, name);
		setSpecial(isSpecial);
	}
	public Category(int id, String name, boolean isSpecial, List<Item> items) {
		this(id, name, isSpecial);
		setItems(items);
	}
	
	public Category(int id, String name, boolean isSpecial, List<Item> items, Location location) {
		this(id, name, isSpecial, items);
		setLocation(location);
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


	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public boolean isSpecial() {
		return isSpecial;
	}

	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	
	
	

}
