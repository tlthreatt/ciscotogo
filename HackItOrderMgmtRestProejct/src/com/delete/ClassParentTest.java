package com.delete;

import java.util.ArrayList;

import com.cisco.order.services.representation.OrderLineItemRepresentation;

public class ClassParentTest {
	
	private String name;
	
	private ArrayList<OrderLineItemRepresentation> children;
	
	public ClassParentTest(){
		
	}
	public ClassParentTest(String name, ArrayList<OrderLineItemRepresentation> children) {
		this.name = name;
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public ArrayList<OrderLineItemRepresentation> getChildren() {
		return children;
	}
}
