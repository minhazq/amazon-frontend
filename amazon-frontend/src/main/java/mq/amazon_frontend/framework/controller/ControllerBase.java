package mq.amazon_frontend.framework.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public abstract class ControllerBase {

	protected WebDriver driver ;
	protected static Logger logger ;
	
	
	public ControllerBase( WebDriver driver){
		this.driver = driver;
		logger = LogManager.getLogger(this);
	}
}
