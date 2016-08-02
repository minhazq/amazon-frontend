package mq.amazon_frontend.framework.controller;
import org.testng.Assert;
import mq.amazon_frontend.framework.Scriptbase;
import mq.amazon_frontend.framework.model.HomePageModel;
import mq.amazon_frontend.framework.util.Utils;

public class HomePageController extends ControllerBase{

	private HomePageModel homePageModel;
	
	public HomePageController() {
		homePageModel = new HomePageModel();
		logger.debug("HomePageController is created");
	}
	
	public void verifyGreetingTxt(){
		String actual = homePageModel.greetingTxt.getText();
		String expected = Utils.loadAppDataPropertiesFile().getProperty("greeting1");
		try{
			Assert.assertEquals(actual, expected);
		}catch(AssertionError ae){
			Scriptbase.assertAll = true;
			logger.error("Greeting Text FAILED , Actual = "+ actual+ " Expected= "+ expected);
		}
		
		
	}

}
