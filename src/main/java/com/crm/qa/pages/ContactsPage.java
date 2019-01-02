package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	WebElement contactsLable;
	
	//initialization of page factory
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);	
	}
	
	public boolean verifyContactsPageLable()
	{
		return contactsLable.isDisplayed();
	}
	
	//follow this when you have to click on multiple check boxes
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();;
		
	}
}
