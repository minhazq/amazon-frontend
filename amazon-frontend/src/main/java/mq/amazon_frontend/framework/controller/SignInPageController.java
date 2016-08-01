package mq.amazon_frontend.framework.controller;
import org.openqa.selenium.WebDriver;

import mq.amazon_frontend.framework.model.SignInPageModel;

public class SignInPageController extends ControllerBase{


	private SignInPageModel signInPageModel;
	
	public SignInPageController(WebDriver driver) {
		super(driver);
		signInPageModel = new SignInPageModel(driver);
		
	}

	public SignInPageController enterEmail(String email){
		signInPageModel.emailTxtBox.sendKeys(email);
		logger.info("entering email " + email);
		return this;
	}
	
	public SignInPageController enterPassword(String password){
		signInPageModel.passwordTxtBox.sendKeys(password);
		logger.info("entering password " + password);
		return this;
	}
	
	public void clickSignIn(){
		signInPageModel.signInBtn.click();
		logger.info("Signin Button clicked ");
	}
}
