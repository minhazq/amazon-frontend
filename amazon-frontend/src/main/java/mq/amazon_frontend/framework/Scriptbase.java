package mq.amazon_frontend.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import mq.amazon_frontend.framework.controller.ApplicationController;

public abstract class Scriptbase {

	protected WebDriver driver;
	private ApplicationController appController;
	
	
	protected ApplicationController amazon(){
		return appController;
	}
	
	@BeforeTest
	public void setup(){
		
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://www.amazon.com");
		appController = new ApplicationController(driver);
	}
	
	@AfterMethod
	public void afterMethod(){
		if(driver!=null){
			driver.close();
			driver = null;
		}
	}
	
	@AfterTest
	public void tearDown(){
		
	}
}
