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
		Response response = httpRequest.request(Method.GET, "");
		return response;
	}
	
	public Response getAPI(String apiEndPoint) {
		
		// Specify the base URL to the RESTful web service 
		RestAssured.baseURI = apiEndPoint; 
		// Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.request(Method.GET, "");
		return response;
	}
	
	public Response postApi(String apiEndPoint,String request,String apiComponet) {
		// Specify the base URL to the RESTful web service 
		RestAssured.baseURI = apiEndPoint; 
		RequestSpecification httpRequest = RestAssured.given(); 
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(request);
		Response res = httpRequest.post(apiComponet);
		return res;
		
		
	}
	
	public Response postApi1(String apiEndPoint,String request,String apiComponet) {
		RestAssured.baseURI = apiEndPoint; 
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest
                .header("Content-type", "application/json")
                .and()
                .body(request)
                .when()
                .post("apiComponet")
                .then()
                .extract().response();
		return response;
	}
	
	
	private RequestSpecification given() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getAPI1() {
		   final RequestSpecification httpRequest = RestAssured.given();
		    httpRequest.header("Content-Type", "application/json");
		    Response res =httpRequest.get("https://reqres.in/api/users/2");
		    System.out.println(res.getStatusCode());
		    System.out.println(res.asString());
	}

}
