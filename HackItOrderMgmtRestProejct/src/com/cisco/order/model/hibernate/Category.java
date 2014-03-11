package com.cisco.order.model.hibernate;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cisco.order.domain.IdentifiableEntity;

@Entity(name="category")
@AttributeOverrides({
    @AttributeOverride(name="id", column=@Column(name="category_id")),
})
public class Category extends IdentifiableEntity{

	private static final long serialVersionUID = -4741376021387794071L;

	@Column(name="category_name", nullable=false)
	private String name;
	
	@Column(name="category_availaility", nullable=false)
	private String availability; // in ('ALWAYS','MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY')
	
	@ManyToOne
	@JoinColumn(name="location_id", nullable=false, unique=true)
	private Location location;
	
	
	
	@OneToMany(mappedBy="category")
	private List<Item> items;
	
	
	public Category() {} 
	
	public Category(Long id, String name) {
		super.setId(id);
		setName(name);
	}
	public Category(Long id, String name, String availability) {
		this(id, name);
		setAvailability(availability);
	}
	public Category(Long id, String name, String availability, List<Item> items) {
		this(id, name, availability);
		setItems(items);
	}
	
	public Category(Long id, String name, String availability, List<Item> items, Location location) {
		this(id, name, availability, items);
		setLocation(location);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
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

	
	
	

}
