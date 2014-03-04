package com.delete;

import java.util.ArrayList;

public class ClassParent {
	
	private String name;
	
	private ArrayList<ClassChild> children;
	
	public ClassParent(){
		
	}
	public ClassParent(String name, ArrayList<ClassChild> children) {
		this.name = name;
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public ArrayList<ClassChild> getChildren() {
		return children;
	}
}
