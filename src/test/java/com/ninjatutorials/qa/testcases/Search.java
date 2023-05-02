package com.ninjatutorials.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Search extends Base {

	public Search()
	{
		super();
	}
	
	WebDriver driver;
	@BeforeMethod()
	
	
	public void setUp()
	{
		driver=initializeBrowserandOpenApplicationURL(prop.getProperty("browserURL"));
		ChromeOptions options = new ChromeOptions();
	      options.addArguments("--remote-allow-origins=*");
	      options.addArguments("--no-sandbox");
	      options.addArguments("--disable-dev-shm-usage");
	      DesiredCapabilities cp=new DesiredCapabilities();
	      cp.setCapability(ChromeOptions.CAPABILITY, options);
	      options.merge(cp);
	      
driver=new ChromeDriver(options);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@Test(priority=1)
	public void VerifySearchWithValidProduct()
	{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(dataProp.getProperty("validProduct"));
		driver.findElement(By.xpath("//div[@id='search']/descendent::button")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Valid product of hp is not displayed");
		
	}
	@Test(priority=2)
	public void VerifySearchWithInValidProduct()
	{
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
        driver.findElement(By.xpath("//div[@id='search']/descendent::button")).click();
		
        String actualMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(actualMessage,dataProp.getProperty("noProductTextInSearchResults"),"no matching in search results");
		
		
}
	@Test(priority=3)
	public void VerifySearchWithoutAnyProduct()
	{

        driver.findElement(By.xpath("//div[@id='search']/descendent::button")).click();
        String actualMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(actualMessage,dataProp.getProperty("noProductTextInSearchResults"),"no matching in search results");
}
}