package mq.amazon_frontend.framework.model;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPageModel extends PageModelBase{
	
	//loginButton should go under Header. I intentionally put it in Landing page. Lets consider Login is a part of landing page.
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']/a[@data-nav-role='signin']")
	public WebElement loginButton;
	
	@FindBy(id="nav-link-yourAccount")
	public WebElement accountLink;
	
	
}
