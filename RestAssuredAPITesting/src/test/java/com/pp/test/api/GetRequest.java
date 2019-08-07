package com.pp.test.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetRequest {
	
@Test	
void getRequest(){
	
	//Specify baseURI
	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
	
	//Request Object
	RequestSpecification httprequest = RestAssured.given();
	
	
	// Response Object
	Response respns = httprequest.request(Method.GET,"Hyderabad");
	
	// Print response in console window
	
	String strRsponseBody =respns.getBody().asString();
	System.out.println("ResponseBody Is" +strRsponseBody);
	System.out.println("ResponseBody Is" +strRsponseBody);
	System.out.println("ResponseBody Is" +strRsponseBody);
	//Satus code validation
	int statusCode = respns.getStatusCode();
	System.out.println("Statsu Code is : "+ statusCode);
	System.out.println("Statsu Code is : "+ statusCode);
	Assert.assertEquals(statusCode, 201);
	
	// Status line validation
	
	String statusLine= respns.statusLine();
	System.out.println("Status Line is : "+statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	
	
}

}
