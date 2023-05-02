package com.ninjatutorials.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Login extends Base {
	
	public Login()
	{
		super();
	}
	WebDriver driver;

	@BeforeMethod()
	public void setUp()
	{
		//loadPropertiesFile();
		driver=initializeBrowserandOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homepage=new HomePage();
		homepage.myccountDropdownOption();
		homepage.loginOption();
				
	
	}
	@AfterMethod()
	public void tearDown()

	{
		driver.quit();
	}
	
	@Test(priority=1, dataProvider="supplyData")
	public void verifyLoginWithValidCredentials(String email, String password)
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.emailField(email);
		loginpage.passwordField(password);
		loginpage.loginbutton();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
		}
	
	@DataProvider
	public void supplyData()
	{
		Object[][] data= {{"amotoori@gmail.com, 12345"}};
		return data;
	}
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials()
	
	{
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("InvalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();	
		
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage =  dataProp.getProperty("emailPasswordNoMatchingWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
	   
	}
	
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword()
	
	{
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();	
		
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage =  dataProp.getProperty("emailPasswordNoMatchingWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
	   
	}
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword()
	
	{

		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys("56445");
		driver.findElement(By.xpath("//input[@value='Login']")).click();	
		
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage =  dataProp.getProperty("emailPasswordNoMatchingWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
	    
	}
	@Test(priority=5)
public void verifyLoginWithoutCredentiials()
	
	{
	
		driver.findElement(By.xpath("//input[@value='Login']")).click();	
		
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessage =  dataProp.getProperty("emailPasswordNoMatchingWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
	    
	}
	
	public String generateTimeStamp()
	{
		Date date =new Date();
		return date.toString().replace(" ","_").replace(":", "_");
				}
}
