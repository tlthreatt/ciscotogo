package com.cisco.ciscotogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="category_availability")
public class CategoryAvailability {
	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="category_availability_id")
	private int id;
	
	@ManyToOne @JoinColumn(name="category_id", nullable=false)
	private Category category;
	
	@Column(name="category_availability_timing", nullable=false)
	private String timing; // in ('BREAKFAST','LUNCH')

	public CategoryAvailability() {
		
	}
	public CategoryAvailability(int id) {
		setId(id);
	}
	public CategoryAvailability(int id, Category category) {
		this(id);
		setCategory(category);
	}
	public CategoryAvailability(int id, Category category, String timing) {
		this(id, category);
		setTiming(timing);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}
	
	
}
