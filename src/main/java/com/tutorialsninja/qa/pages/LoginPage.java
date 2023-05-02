package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id="input-email")
	WebElement emailAddressField;
	

	@FindBy(id="input-password")
	WebElement passwordAddressField;
	

	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
		
		public void emailField(String email)
		{
			emailAddressField.sendKeys();
		}
			public void passwordField(String password)
			{
				passwordAddressField.sendKeys();
			}
				public void loginbutton()
				{
					loginButton.click();
		}
	}

