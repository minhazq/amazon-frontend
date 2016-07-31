package mq.amazon_frontend.framework.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mq.amazon_frontend.framework.model.HomePageModel;

public class HomePageController extends ControllerBase{

	private HomePageModel homePageModel;
	
	public HomePageController(WebDriver driver) {
		super(driver);
		homePageModel = new HomePageModel(driver);
		logger.debug("HomePageController is created");
	}
	
	public SignInPageController clickLogin(){
		Actions actions = new Actions(driver);
		actions.moveToElement(homePageModel.accountLink).perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(homePageModel.loginButton)).click();
		logger.debug("clickLogin is performed");
		return new SignInPageController(driver);	
	}
	
	
}
