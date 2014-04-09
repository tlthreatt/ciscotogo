package com.cisco.ciscotogo.buisness;

import java.util.List;
import java.util.Set;

import com.cisco.ciscotogo.dao.LocationDao;
import com.cisco.ciscotogo.model.Location;

public class LocationBiz {
	public static Set<Location> FetchLocationsAndCategoriesAndItems() {
		/* This is simply fetching ALL locations, and corresponding categories, and corresponding items. */
		Set<Location> locations = LocationDao.getAllLocationsAndCategoriesAndItems();
		return locations;
	}
}
