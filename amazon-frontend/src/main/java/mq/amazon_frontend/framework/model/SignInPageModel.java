package mq.amazon_frontend.framework.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageModel extends PageModelBase{

	public SignInPageModel(WebDriver wd) {
		super(wd);
	}
	
	@FindBy(id="ap_email")
	public WebElement emailTxtBox;
}
