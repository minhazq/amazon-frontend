package mq.amazon_frontend.login;

import org.testng.annotations.Test;

import mq.amazon_frontend.framework.Scriptbase;

public class FR001_ValidLogin extends Scriptbase{

	@Test
	public void validLoginTest(){
		amazon().homePage().clickLogin().enterEmail("test");
		logger.info(" entering Email Address");
	}
	
	@Test
	public void validLoginTest2(){
		
		amazon().homePage().clickLogin().enterEmail("minhaz");
	}
}
