package com.cisco.ciscotogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity(name="rating")
public class Rating {

	@Id @GeneratedValue(strategy=GenerationType.TABLE) @Column(name="rating_id")
	private int id;
	
	@Column(name="rating_review")
	private String review;
	
	@Column(name="rating_stars")
	private int stars; // one through 10
	
	@ManyToOne @JoinColumn(name="customer_cec", nullable=false)
	@JsonBackReference
	private Customer customer;
	
	@ManyToOne @JoinColumn(name="location_id", nullable=false)
	@JsonBackReference
	private Location location;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}
	
	
	
}
