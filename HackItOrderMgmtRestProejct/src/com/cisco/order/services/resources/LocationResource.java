package com.cisco.order.services.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/location")
public class LocationResource {
	
	public LocationResource(){
		
	}
	
	@PUT
	public Response createLocation(){
		return Response.ok().build();
	}
	
	@DELETE
	@PathParam("/{locationId}")
	public Response deleteLocation(){
		return Response.ok().build();
	}
		
	@GET
	public Response getAllLocations(){
		return Response.ok().build();
	}
	
	@GET
	@Path("query")
	public Response getLocationByCriteria( @Context UriInfo info){
		/**
	}
			@QueryParam(value = "country") String country,
			@QueryParam(value = "state") String state,
			@QueryParam(value = "zip") String zip,
			@QueryParam(value = "province") String province){**/
		String country = info.getQueryParameters().getFirst("country");
		String state = info.getQueryParameters().getFirst("state");
		String zip = info.getQueryParameters().getFirst("zip");
		String province = info.getQueryParameters().getFirst("province");
		
		return Response.ok().build();
	}
	
	
}
