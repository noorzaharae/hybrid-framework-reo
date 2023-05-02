package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

@FindBy(xpath="//span[@class='caret']")
WebElement myccountDropdownOption;

@FindBy(linkText="Login\"")
WebElement loginOption;


{
	this.driver=driver;
PageFactory.initElements(driver, this);
}
	public void myccountDropdownOption()
	{
		myccountDropdownOption.click();
	}
	public void loginOption()
	{
		loginOption.click();
	}
}
