package mq.amazon_frontend.framework.controller;
import org.openqa.selenium.WebDriver;


public class ApplicationController extends ControllerBase{

	private HomePageController homePageController;
	
	public ApplicationController(WebDriver driver) {
		super(driver);
	}

	public HomePageController homePage(){
		if(homePageController==null){
			homePageController = new HomePageController(driver);
		} 
		return homePageController;
	}
	

}
