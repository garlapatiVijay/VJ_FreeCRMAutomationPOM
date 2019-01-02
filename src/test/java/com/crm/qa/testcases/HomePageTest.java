package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	//First create constructor of home page test to assign the properties
	public HomePageTest()
	{
		super();
	}
	
	//This setup method helps to open the brower, launch the url, enter username and password and proceed to homepage
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil = new TestUtil();
		loginPage=new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title is not matched"); //this message is only displayed if the test case fails
	}
	
	@Test (priority=2)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame(); 
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test (priority=3)
	public void contactsPageLinkClickTest()
	{
		testUtil.switchToFrame();
		contactsPage = homePage.contactsPageLinkClick();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
