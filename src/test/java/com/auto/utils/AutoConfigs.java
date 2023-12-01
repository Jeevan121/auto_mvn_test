package com.auto.utils;

public class AutoConfigs {
	
	public static String application_url = PropertiesUtils.initEnvironmentProperties().getProperty("environmentUrl");
	public static String userName = PropertiesUtils.initEnvironmentProperties().getProperty("user_name");
	public static String password = PropertiesUtils.initEnvironmentProperties().getProperty("password");

}
