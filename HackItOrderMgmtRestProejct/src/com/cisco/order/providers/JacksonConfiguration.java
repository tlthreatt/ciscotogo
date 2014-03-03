package com.cisco.order.providers;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

@Provider
public class JacksonConfiguration implements ContextResolver<ObjectMapper> {

	@Override
	public ObjectMapper getContext(Class<?> type) {
		// only serialize non-null fields in JSON representations
		return new ObjectMapper().setSerializationInclusion(NON_NULL);
	}

}
