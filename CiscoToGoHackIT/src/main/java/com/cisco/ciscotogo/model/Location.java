package com.cisco.ciscotogo.model;

import java.util.List;

public class Location {

	private String buildingName;
	private String buildingAddress;
	private List<DailyMenu> dailyMenus;
	
	public Location(String buildingName, String buildingAddress,
			List<DailyMenu> dailyMenus) {
		super();
		this.buildingName = buildingName;
		this.buildingAddress = buildingAddress;
		this.dailyMenus = dailyMenus;
	}
	
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getBuildingAddress() {
		return buildingAddress;
	}
	public void setBuildingAddress(String buildingAddress) {
		this.buildingAddress = buildingAddress;
	}
	public List<DailyMenu> getDailyMenus() {
		return dailyMenus;
	}
	public void setDailyMenus(List<DailyMenu> dailyMenus) {
		this.dailyMenus = dailyMenus;
	}
	
	
}
