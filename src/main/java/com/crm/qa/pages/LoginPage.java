package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//pagefactory or object repository should be defined for login page at first
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
//initiatlizing the pageobjects 
public LoginPage()
{
	PageFactory.initElements(driver, this); //all the above variables will be initialized with driver, 'this' means pointing to the current class
}

//Actions
public String validateLoginPageTitle(){
	return driver.getTitle();
}

public boolean validateCrmLogo(){
	return crmLogo.isDisplayed();
}

public HomePage login(String un, String pwd){
	username.sendKeys(un);
	password.sendKeys(pwd);
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", loginBtn);
    
	return new HomePage();
}
}