package com.auto.tests.api;

import org.testng.annotations.Test;

import com.auto.utils.RestApiUtils;

public class SingleUserApiGetTest {
	
	
	@Test
	public void singleUserApiGetTest() {
		RestApiUtils restApiUtils = new RestApiUtils();
		restApiUtils.getAPI1();
	}

}


