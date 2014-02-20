package com.cisco.ciscotogo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController{

	@RequestMapping(value = "/orderToGo", method = RequestMethod.GET)
	public String dashboard(HttpServletRequest request, HttpServletResponse response) {				
		return "orderToGo";
	}
	
	@RequestMapping(value="/getFoodDetails", method = RequestMethod.GET)
	public @ResponseBody String getUnbilledEvents(HttpServletRequest request, HttpServletResponse response){
		return "success";
	}
	
	
}