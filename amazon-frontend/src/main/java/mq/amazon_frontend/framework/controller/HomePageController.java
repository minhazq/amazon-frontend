package mq.amazon_frontend.framework.controller;

import org.openqa.selenium.WebDriver;

import mq.amazon_frontend.framework.model.HomePageModel;

public class HomePageController extends ControllerBase{

	private HomePageModel homePageModel;
	
	public HomePageController(WebDriver driver) {
		super(driver);
		homePageModel = new HomePageModel(driver);
	}
	
	public SignInPageController clickLogin(){
		System.out.println("click login");
		homePageModel.loginButton.click();
		return new SignInPageController(driver);	
	}
	
	
}
