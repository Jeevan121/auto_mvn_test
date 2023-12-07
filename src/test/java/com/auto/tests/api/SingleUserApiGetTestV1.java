package com.auto.tests.api;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auto.utils.RestApiUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.classfile.Node;

import io.restassured.response.Response;

public class SingleUserApiGetTestV1 {
	
	
	@Test
	public void singleUserApiGetTest() throws JsonMappingException, JsonProcessingException {
		RestApiUtils restApiUtils = new RestApiUtils();
		Response res= restApiUtils.getAPI();
		Assert.assertEquals(res.getStatusCode(), 200,"connection not established");
		
		ObjectMapper obj = new ObjectMapper();
		
		JsonNode jsonNodeRoot =  obj.readTree(res.asString());
		List<JsonNode> id_Node = jsonNodeRoot.get("data").findValues("id");
		String id = id_Node.get(0).asText();
		System.out.println(id_Node.get(0).asText());
		Assert.assertEquals(id, "2","id is not matching");

		
		/*
		 * JsonNode id_Node1 = jsonNodeRoot.get("data").findValue("id"); String year =
		 * id_Node1.asText(); System.out.println(year);
		 */
		
		
		
		
	}

}


