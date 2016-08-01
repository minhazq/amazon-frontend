package mq.amazon_frontend.login;

import org.testng.annotations.Test;

import mq.amazon_frontend.framework.Scriptbase;
import mq.amazon_frontend.framework.persistance.AccountProfile;

public class FR001_ValidLogin extends Scriptbase{

	@Test
	public void validLoginTest(){
		String userName = session.get(AccountProfile.class,1).getUser_name();
		String password = session.get(AccountProfile.class,1).getUser_password();
		
		amazon().landingPage().clickLogin().enterEmail(userName).enterPassword(password).clickSignIn();
		
		
		logger.info("Entering User Name = "+userName + " and password = "+password + " is complete");
		
	}
	
	@Test
	public void validLoginTest2(){
		String userName = session.get(AccountProfile.class,1).getUser_name();
		String password = session.get(AccountProfile.class,1).getUser_password();
		
		amazon().landingPage().clickLogin().enterEmail(userName)
		.enterPassword(password);
		
		logger.info("Entering User Name = "+userName + " and password = "+password + " is complete");
		
	}
	
	
}
