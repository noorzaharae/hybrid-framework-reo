package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base()
	{
		 prop = new Properties();
		 File propFile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
	     dataProp=new Properties();
	    
	     
	     File datapropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\testdata.properties");
	    try { FileInputStream dataFis=new FileInputStream(datapropFile);
		 dataProp.load(dataFis);
	    }catch(Throwable e) {
		    e. printStackTrace();
		}
		
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
	}catch(Throwable e) {
	    e. printStackTrace();
	}
	}
	public WebDriver initializeBrowserandOpenApplicationURL(String browserName)
	{
		
		if(browserName.equals("chrome")) {
			
			driver=new ChromeDriver();
			
			 // ChromeOptions options = new ChromeOptions();
		      //options.addArguments("--remote-allow-origins=*");
		      //options.addArguments("--no-sandbox");
		     // options.addArguments("--disable-dev-shm-usage");
		     // DesiredCapabilities cp=new DesiredCapabilities();
		     // cp.setCapability(ChromeOptions.CAPABILITY, options);
		      //options.merge(cp);
		      
	 //driver=new ChromeDriver(options);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
	 driver.get(prop.getProperty("url"));
	 return driver;
		}
		
	}
}
