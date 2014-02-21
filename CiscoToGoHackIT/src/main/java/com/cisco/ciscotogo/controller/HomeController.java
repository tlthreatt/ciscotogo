package com.cisco.ciscotogo.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController{
	
	private final String XML_FILE_LOCATION = "C:\\Users\\eyaklin\\Desktop\\orderrequest.xml";

	@RequestMapping(value = "/orderToGo", method = RequestMethod.GET)
	public String dashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<NameValuePair> list = new ArrayList<NameValuePair>(1);
		
		String request_xml = readTextFile(XML_FILE_LOCATION);
		
		//System.out.println(request_xml);
		
		list.add(new BasicNameValuePair("xml", ""));
		//System.out.println(list.get(0).getValue());
		
		System.out.println("The order request : \n" + httpPostResponse("http://txpfdbappdev002:7001/WebexPFProxyWS/CatalogTransactionService", list));
		return "orderToGo";
	}
	
	@RequestMapping(value="/getFoodDetails", method = RequestMethod.GET)
	public @ResponseBody String getUnbilledEvents(HttpServletRequest request, HttpServletResponse response){
		return "success";
	}
	
	private String httpPostResponse(String url, List<NameValuePair> list) throws Exception{
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost(url);
		
		request.setEntity(new UrlEncodedFormEntity(list));
		
		HttpResponse response = client.execute(request);
		
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());
		
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent())
			);
			
			StringBuffer result = new StringBuffer();
			String line = "";
			while((line = rd.readLine()) != null) {
				result.append(line);
			}
		
		return result.toString();
	}
	

	private static String readTextFile(String filename) throws IOException{
		FileInputStream fis = new FileInputStream(filename);
		int x = fis.available();
		byte b[] = new byte[x];
		fis.read(b);
		String content = new String(b);
		return content;
	}
}