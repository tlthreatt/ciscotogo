package com.cisco.ciscotogo.model;

import java.util.ArrayList;

public class LocationList {
	private ArrayList<Location> locations;

	public LocationList(ArrayList<Location> locations) {
		super();
		this.locations = locations;
	}

	public LocationList() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}
	
	
}
