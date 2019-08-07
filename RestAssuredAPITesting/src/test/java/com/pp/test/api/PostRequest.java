package com.pp.test.api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostRequest {
	
	@Test
	void postRequest(){
	
		//Specify base URI
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		
			
		// Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Request payload sending along with post request
		
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("FirstName","ppfname");
		requestParams.put("LastName","pplname");
		requestParams.put("UserName","Uname");
		requestParams.put("Password","password123");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		// Response Object
		Response response = httpRequest.request(Method.POST,"/register"); 
		
		String responseBody=response.getBody().asString();
		System.out.println("getBody Response is"+responseBody);
		
		
		// Status code validation
		
		int statusCode=response.getStatusCode();
		System.out.println("statusCode is " +statusCode);
		
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(statusCode, 201);
		
		
	}

}
