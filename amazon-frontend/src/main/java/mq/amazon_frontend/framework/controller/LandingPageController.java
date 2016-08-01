package mq.amazon_frontend.framework.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mq.amazon_frontend.framework.model.LandingPageModel;

public class LandingPageController extends ControllerBase{

	private LandingPageModel landingPageModel;
	
	public LandingPageController(WebDriver driver) {
		super(driver);
		landingPageModel = new LandingPageModel(driver);
		logger.debug("LandingPageController is created");
	}
	
	public SignInPageController clickLogin(){
		Actions actions = new Actions(driver);
		actions.moveToElement(landingPageModel.accountLink).perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(landingPageModel.loginButton)).click();
		logger.debug("clickLogin is performed");
		return new SignInPageController(driver);	
	}
	
	
}
