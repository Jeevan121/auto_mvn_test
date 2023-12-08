package com.auto.tests.api;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.auto.utils.AutoConfigs;
import com.auto.utils.RestApiUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import io.restassured.response.Response;

public class CreateApiTest {
	
	
	@Test
	public void createApiTest() throws JsonMappingException, JsonProcessingException {
		RestApiUtils restApiUtils = new RestApiUtils();
		
		JSONObject obj = new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job", "leader");
		
		System.out.println("framed json request ::"+obj.toJSONString());
		
		Response res= restApiUtils.postApi1(AutoConfigs.api_end_point,obj.toJSONString(),AutoConfigs.user_api_compent);
		
		System.out.println(res.getStatusCode());
		
		System.out.println(res.asString());
	

	}

}


