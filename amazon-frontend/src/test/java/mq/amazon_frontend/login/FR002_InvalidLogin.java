package mq.amazon_frontend.login;

import org.testng.annotations.Test;

import mq.amazon_frontend.framework.Scriptbase;

public class FR002_InvalidLogin extends Scriptbase{

	
	@Test
	public void invalidLoginTest(){
		amazon().landingPage().clickLogin().enterEmail("test");
	}
}
