package mq.amazon_frontend.framework.model;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageModel extends PageModelBase{

	@FindBy(xpath="//a[@id='nav-link-yourAccount']/span[@class='nav-line-1']")
	public WebElement greetingTxt;
}
