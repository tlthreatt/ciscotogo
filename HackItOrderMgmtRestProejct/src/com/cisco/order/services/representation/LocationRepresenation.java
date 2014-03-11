package com.cisco.order.services.representation;

import java.net.URI;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Location")
public class LocationRepresenation {
	@XmlElement
	private URI self;
	
	private Long locationId;
	
	private String street;
	
	private String state;
	
	private String zip;
	
	private String countryCode;

	public LocationRepresenation(Long locationId, String street, String state,
			String zip, String countryCode) {
		super();
		this.locationId = locationId;
		this.street = street;
		this.state = state;
		this.zip = zip;
		this.countryCode = countryCode;
	}

	public URI getSelf() {
		return self;
	}

	public Long getLocationId() {
		return locationId;
	}

	public String getStreet() {
		return street;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getCountryCode() {
		return countryCode;
	}
	
	
}
