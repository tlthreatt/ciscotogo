package com.cisco.ciscotogo.buisness;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;

import com.cisco.ciscotogo.dao.RatingDao;
import com.cisco.ciscotogo.model.Customer;
import com.cisco.ciscotogo.model.Location;
import com.cisco.ciscotogo.model.Rating;

public class RatingBiz {
	public static void CreateRating(String json) throws JSONException {
		JSONObject jsonObject = (JSONObject)new JSONTokener(json).nextValue();
		Rating rating = new Rating(jsonObject.getString("review"), jsonObject.getInt("stars"));
		rating.setCustomer(new Customer(jsonObject.getString("customer_cec")));
		rating.setLocation(new Location(jsonObject.getInt("location_id")));
		RatingDao.save(rating);
	}
	
	public static List<Rating> FetchReviews(String json) throws JSONException {
		JSONObject jsonObject = (JSONObject)new JSONTokener(json).nextValue();
		Location location = new Location(jsonObject.getInt("location_id"));
		return FetchReviews(location);
	}
	public static List<Rating> FetchReviews(Location location) {
		return RatingDao.getAll(location);
	}
}
