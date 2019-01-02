package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 40; //this values can also be defined in config.properties file
	public static long IMPLICIT_WAIT = 20; //this value can also be defined in config.properties file
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
}
