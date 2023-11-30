package com.auto.dataprovider;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.auto.utils.ExcelUtils;


public class DataProviderUtils {

	  @DataProvider(name="loginTestV3")
	  public static Object[][] loginTestV3(){
		  final Object[][] objReturn = ExcelUtils.getTableArray(
			        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "demo", "loginTestV3");
			    return objReturn;

	  }
	
}
