package com.cisco.ciscotogo.model;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity(name="location_hours")
public class LocationHours implements Serializable {
	public static void main(String[] args)throws ParseException {
		String breakfastStartStr = "08:00:00";
		String breakfastEndStr = "10:30:00";
		String lunchStartStr = "11:30:00";
		String lunchEndStr = "13:00:00";
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Location location = new Location();
		LocationHours locationHours = new LocationHours(location, new Time(sdf.parse(breakfastStartStr).getTime()), new Time(sdf.parse(breakfastEndStr).getTime()),
				new Time(sdf.parse(lunchStartStr).getTime()), new Time(sdf.parse(lunchEndStr).getTime()));
		
		Time desiredCompletionTime = new Time(sdf.parse("10:31:00").getTime());
		
		System.out.println(locationHours.isDesiredCompletionTimeWithinHoursOfOperation(desiredCompletionTime));
	}
	
	@OneToOne @Id @JoinColumn(name="location_id", nullable=false)
	private Location location;
	
	@Column(name="location_hours_breakfast_start", nullable=false)
	private Time breakfastStart;
	
	@Column(name="location_hours_breakfast_end", nullable=false)
	private Time breakfastEnd;
	
	@Column(name="location_hours_lunch_start", nullable=false)
	private Time lunchStart;
	
	@Column(name="location_hours_lunch_end", nullable=false)
	private Time lunchEnd;
	
	@Transient
	static DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	public LocationHours() {
		
	}
	public LocationHours(Location location) {
		setLocation(location);
	}
	public LocationHours(Location location, Time breakfastStart, Time breakfastEnd, Time lunchStart, Time lunchEnd) {
		this(location);
		setBreakfastStart(breakfastStart);
		setBreakfastEnd(breakfastEnd);
		setLunchStart(lunchStart);
		setLunchEnd(lunchEnd);
	}
	public LocationHours(Location location, String breakfastStart, String breakfastEnd, String lunchStart, String lunchEnd) throws ParseException {
		// Expects String in 24 hour format
		this(location, new Time(sdf.parse(breakfastStart).getTime()), new Time(sdf.parse(breakfastEnd).getTime()),
				new Time(sdf.parse(lunchStart).getTime()), new Time(sdf.parse(lunchEnd).getTime()));
	}
	
	
	public boolean isDesiredCompletionTimeWithinHoursOfOperation(Time desiredCompletionTime) {
		if (desiredCompletionTime.compareTo(breakfastStart) >= 0 && desiredCompletionTime.compareTo(breakfastEnd) <= 0) {
			return true;
		}
		if (desiredCompletionTime.compareTo(lunchStart) >= 0 && desiredCompletionTime.compareTo(lunchEnd) <= 0) {
			return true;
		}
		return false;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Time getBreakfastStart() {
		return breakfastStart;
	}
	public void setBreakfastStart(Time breakfastStart) {
		this.breakfastStart = breakfastStart;
	}
	public Time getBreakfastEnd() {
		return breakfastEnd;
	}
	public void setBreakfastEnd(Time breakfastEnd) {
		this.breakfastEnd = breakfastEnd;
	}
	public Time getLunchStart() {
		return lunchStart;
	}
	public void setLunchStart(Time lunchStart) {
		this.lunchStart = lunchStart;
	}
	public Time getLunchEnd() {
		return lunchEnd;
	}
	public void setLunchEnd(Time lunchEnd) {
		this.lunchEnd = lunchEnd;
	}
	
	
}
