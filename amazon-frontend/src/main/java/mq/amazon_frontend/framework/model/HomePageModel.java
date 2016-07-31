package mq.amazon_frontend.framework.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageModel extends PageModelBase{

	
	public HomePageModel(WebDriver wd) {
		super(wd);
	}
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']/a[@data-nav-role='signin']")
	public WebElement loginButton;
	
	@FindBy(id="nav-link-yourAccount")
	public WebElement accountLink;

}
