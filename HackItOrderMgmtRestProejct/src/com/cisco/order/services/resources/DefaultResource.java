package com.cisco.order.services.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.cisco.order.services.representation.BaseRepresentation;

public abstract class DefaultResource <E extends BaseRepresentation>{
	
	@GET
	@Path("/{entityId}")
	public Response getEntityById(@PathParam(value="entityId") Long Id){
		return Response.ok().build();
	}
}
