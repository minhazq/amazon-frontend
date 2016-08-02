package mq.amazon_frontend.login;

import org.testng.annotations.Test;

import mq.amazon_frontend.framework.Scriptbase;

public class FR002_InvalidLogin extends Scriptbase{

	
	@Test
	public void searchTest(){
		String description = amazonWebService().setScheme().setHost().setPath().addAppId().addLocation("new york").
			executeGetAndParse().getResponseForDescription();
		
		amazon().landingPage().search(description);
	}
}
