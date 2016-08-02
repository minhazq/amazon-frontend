package mq.amazon_frontend.framework.controller;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import mq.amazon_frontend.framework.model.HomePageModel;
import mq.amazon_frontend.framework.util.Utils;

public class HomePageController extends ControllerBase{

	private HomePageModel homePageModel;
	
	public HomePageController(WebDriver driver) {
		super(driver);
		homePageModel = new HomePageModel(driver);
		logger.debug("HomePageController is created");
	}
	
	public void verifyGreetingTxt(){
		String actual = homePageModel.greetingTxt.getText();
		String expected = Utils.loadAppDataPropertiesFile().getProperty("greeting1");
		Assert.assertEquals(actual, expected);
		
	}

}
