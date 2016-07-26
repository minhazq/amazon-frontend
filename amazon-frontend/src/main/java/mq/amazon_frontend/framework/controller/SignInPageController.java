package mq.amazon_frontend.framework.controller;
import org.openqa.selenium.WebDriver;

import mq.amazon_frontend.framework.model.SignInPageModel;

public class SignInPageController extends ControllerBase{


	private SignInPageModel signInPageModel;
	
	public SignInPageController(WebDriver driver) {
		super(driver);
		signInPageModel = new SignInPageModel(driver);
	}

	public void enterEmail(String email){
		System.out.println("enter email");
		signInPageModel.emailTxtBox.sendKeys(email);
		
	}
}
