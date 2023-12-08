package com.auto.utils;

public class AutoConfigs {
	
	public static String application_url = PropertiesUtils.initEnvironmentProperties().getProperty("environmentUrl");
	public static String userName = PropertiesUtils.initEnvironmentProperties().getProperty("user_name");
	public static String password = PropertiesUtils.initEnvironmentProperties().getProperty("password");
	public static String api_end_point = PropertiesUtils.initEnvironmentProperties().getProperty("api_end_point");
	
	public static String user_api_compent="/users/";
	
	public static String login_api_compent="/login";
	
}
