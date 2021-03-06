package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Knowledge base')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsPageLink;

	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsPageLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksPageLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage contactsPageLinkClick()
	{
		contactsPageLink.click();
		return new ContactsPage();
	}
	
	public DealsPage dealsPageLinkClick()
	{
		dealsPageLink.click();
		return new DealsPage();
	}
	
	public TasksPage tasksPageLinkClick()
	{
		tasksPageLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsPageLink).build().perform();
		newContactLink.click();
		
		
	}
	
}
