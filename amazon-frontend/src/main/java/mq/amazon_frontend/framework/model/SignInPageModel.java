package mq.amazon_frontend.framework.model;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageModel extends PageModelBase{

	@FindBy(id="ap_email")
	public WebElement emailTxtBox;
	
	@FindBy(id="ap_password")
	public WebElement passwordTxtBox;
	
	@FindBy(id="signInSubmit")
	public WebElement signInBtn;
}
