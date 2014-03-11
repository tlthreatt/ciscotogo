package com.delete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import com.cisco.order.services.representation.OrderLineItemRepresentation;
import com.cisco.order.services.representation.OrderRepresentation;


public class TestClass {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<ClassChild> children = new ArrayList<ClassChild>();
		children.add(new ClassChild("Tim", "Cats"));
		ClassParent parent = new ClassParent("parent1", children);
		ObjectMapper mapper = new ObjectMapper();
        
		AnnotationIntrospector introspector
		    = new JaxbAnnotationIntrospector();
		mapper.setAnnotationIntrospector(introspector);
		
		String result = mapper.writeValueAsString(parent);
		
		System.out.println(result);
		
		parent = mapper.readValue(result, ClassParent.class);
		
		result = mapper.writeValueAsString(parent);
		
		System.out.println(result);
		
		ArrayList<OrderLineItemRepresentation> orderLines = new ArrayList<OrderLineItemRepresentation>();
		orderLines.add(new OrderLineItemRepresentation(new Long(1),new Long(1), 10.0));
		OrderRepresentation parentTest = new OrderRepresentation(new Long(1), "COMPLETED", new Date(), new Long(1), "clachan", new Long(2), orderLines);
		
		 result = mapper.writeValueAsString(parentTest);
		 System.out.println(result);
		 
		 parentTest = mapper.readValue(result, OrderRepresentation.class);
	}

}
