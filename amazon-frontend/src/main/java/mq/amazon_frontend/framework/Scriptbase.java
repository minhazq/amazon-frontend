package mq.amazon_frontend.framework;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import mq.amazon_frontend.framework.controller.ApplicationController;
import mq.amazon_frontend.framework.util.Utils;

public abstract class Scriptbase {

	protected WebDriver driver;
	protected Properties appDataProperties;
	private ApplicationController appController;
	
	
	public Scriptbase(){
		setAppDataProperties();
	}

	private void setAppDataProperties() {
		appDataProperties = Utils.loadAppDataPropertiesFile();
	}


	private void setAppController() {
		appController = new ApplicationController(driver);
	}

	private void setDriver() {
		String browser = Utils.getBrowser();
		if(browser==null){
			setDefaultBrowser();

			//Doing singleton
		}else if(driver==null){
			if(browser.equals("firefox")){
				driver = new FirefoxDriver();
			}
		}


	}

	//getApplicationController
	protected ApplicationController amazon(){
		return appController;
	}
	
	@BeforeTest
	public void setup(){
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
		setDriver();
		setAppController(); // access point 
		driver.manage().deleteAllCookies();
		driver.get(appDataProperties.getProperty("url"));
		
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
	
	protected WebDriver getDriver(){
		return driver;	
	}
	
	private void setDefaultBrowser(){
		driver = new FirefoxDriver();
	}
	

}
