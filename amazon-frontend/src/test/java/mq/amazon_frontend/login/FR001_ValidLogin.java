package mq.amazon_frontend.login;
import java.lang.reflect.Method;
import org.testng.annotations.Test;
import mq.amazon_frontend.framework.Scriptbase;
import mq.amazon_frontend.framework.persistance.AccountProfile;
import mq.amazon_frontend.framework.util.Utils;

public class FR001_ValidLogin extends Scriptbase{

	
	/*
	 * Scenario: Login to amazon and verify greeting text is present
	 */
	@Test(groups={"smoke","functional"})
	public void validLoginTest(Method method){
		String userName = session.get(AccountProfile.class,1).getUser_name();
		String password = session.get(AccountProfile.class,1).getUser_password();
		
		amazon().landingPage().clickLogin().
								enterEmail(userName).
								enterPassword(password).clickSignIn().
								verifyGreetingTxt();
		
						
		assertALL(method.getName());
		
		
	}
	
	/*
	 * Scenario: Search without login and verify search result returning with the search text at the top
	 */
	
	@Test(groups={"functional"})
	public void validLoginTest2(Method method){
		amazon().landingPage().search("java books");
		//or 
		//amazon().search("java books"); both will work. Search is in the header. From any page you can search
		amazon().searchPage().verifySearchText(Utils.loadAppDataPropertiesFile().getProperty("searchText1"));
		assertALL(method.getName());
	}
	
	
}
