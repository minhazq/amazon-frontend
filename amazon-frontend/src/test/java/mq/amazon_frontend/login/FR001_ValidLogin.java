package mq.amazon_frontend.login;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import mq.amazon_frontend.framework.Scriptbase;
import mq.amazon_frontend.framework.persistance.AccountProfile;

public class FR001_ValidLogin extends Scriptbase{

	@Test
	public void validLoginTest(Method method){
		String userName = session.get(AccountProfile.class,1).getUser_name();
		String password = session.get(AccountProfile.class,1).getUser_password();
		
		amazon().landingPage().clickLogin().
								enterEmail(userName).
								enterPassword(password).clickSignIn().
								verifyGreetingTxt();
		
						
		assertALL(method.getName());
		
		
	}
	
	@Test
	public void validLoginTest2(Method method){
		amazon().landingPage().search("java books");
		//or 
		//amazon().search("java books"); both will work. Search is in the header. From any page you can search
		amazon().searchPage().verifySearchText();
		assertALL(method.getName());
	}
	
	
}
