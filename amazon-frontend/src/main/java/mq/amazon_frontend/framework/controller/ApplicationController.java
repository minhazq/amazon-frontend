package mq.amazon_frontend.framework.controller;
import org.openqa.selenium.WebDriver;


public class ApplicationController extends ControllerBase{

	private LandingPageController landingPageController;
	
	public ApplicationController(WebDriver driver) {
		super(driver);
	}

	public LandingPageController landingPage(){
		if(landingPageController==null){
			landingPageController = new LandingPageController(driver);
		} 
		return landingPageController;
	}
	

}
