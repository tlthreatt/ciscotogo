package com.cisco.ciscotogo.buisness;

import java.util.Set;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;

import com.cisco.ciscotogo.dao.LocationDao;
import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.Rating;

public class LocationBiz {
	public static Set<Location> FetchLocationsAndCategoriesAndItems() {
		/* This is simply fetching ALL locations, and corresponding categories, and corresponding items. */
		Set<Location> locations = LocationDao.getAllLocationsAndCategoriesAndItems();
		return locations;
	}
	

}
