package mq.amazon_frontend.login;

import org.testng.annotations.Test;

import mq.amazon_frontend.framework.Scriptbase;

public class FR002_InvalidLogin extends Scriptbase{

	/*
	 * Scenario: Assume Amazon customer search based on the weather data.if it cloudy then they will search cloudy 
	 * Verify dynamically that every time you execute the test based on local weather your script search with data.
	 *  Basically i want to show that using totally two separate component how to test dynamically.
	 */
	
	@Test
	public void searchTest(){
		String description = amazonWebService().setScheme().setHost().setPath().addAppId().addLocation("new york").
			executeGetAndParse().getResponseForDescription();
		
		amazon().landingPage().search(description);
		amazon().searchPage().verifySearchText("\"\""+description+"\"");// With the quotations
		
	}
}
