package com.auto.tests.api;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auto.utils.AutoConfigs;
import com.auto.utils.RestApiUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class SingleUserApiGetTestV1 {
	
	
	@Test
	public void singleUserApiGetTest() throws JsonMappingException, JsonProcessingException {
		RestApiUtils restApiUtils = new RestApiUtils();
		Response res= restApiUtils.getAPI(AutoConfigs.api_end_point+AutoConfigs.user_api_compent+"2");
		Assert.assertEquals(res.getStatusCode(), 200,"connection not established");
		
		ObjectMapper obj = new ObjectMapper(); 
		
		JsonNode jsonNodeRoot =  obj.readTree(res.asString());
		List<JsonNode> id_Node = jsonNodeRoot.get("data").findValues("id");
		String id = id_Node.get(0).asText();
		System.out.println(id_Node.get(0).asText());
		Assert.assertEquals(id, "2","id is not matching");
		
		
		List<JsonNode> first_name_Node = jsonNodeRoot.get("data").findValues("first_name");
		String first_name = first_name_Node.get(0).asText();
		System.out.println(first_name);
		Assert.assertEquals(first_name, "Janet","first name is not matching");
		
		JsonNode testNode= jsonNodeRoot.get("data").findValue("last_name");
		String last_name = testNode.asText();
		System.out.println(last_name);
		Assert.assertEquals(last_name, "Weaver","last name is not matching");

	}

}


