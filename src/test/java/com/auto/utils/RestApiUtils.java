package com.auto.utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiUtils {
	
	public Response getAPI() {
		
		// Specify the base URL to the RESTful web service 
		RestAssured.baseURI = "http://reqres.in/api/users/2"; 
		// Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest = RestAssured.given(); 
		// specify the method type (GET) and the parameters if any. 
		//In this case the request does not take any parameters 
		Response response = httpRequest.request(Method.GET, "");
		// Print the status and message body of the response received from the server 
		//System.out.println("Status received => " + response.getStatusCode()); 
		//System.out.println("Response=>" + response.prettyPrint());
		return response;
	}
	
	public void getAPI1() {
		   final RequestSpecification httpRequest = RestAssured.given();
		    httpRequest.header("Content-Type", "application/json");
		    Response res =httpRequest.get("https://reqres.in/api/users/2");
		    System.out.println(res.getStatusCode());
		    System.out.println(res.asString());
	}

}
