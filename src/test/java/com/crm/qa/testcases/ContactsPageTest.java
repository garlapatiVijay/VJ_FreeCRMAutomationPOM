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

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    testUtil.switchToFrame();
		contactsPage = homePage.contactsPageLinkClick();
	}
	
	@Test (priority=1)
	public void verifyContactsPageLableTest()
	{
		Assert.assertTrue(contactsPage.verifyContactsPageLable(), "contacts lable is missing on contacts page");
	}
	
	
	@Test (priority=2)
	public void selectContactsByNameTest()
	{
		contactsPage.selectContactsByName("Tester 2 VJ");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
