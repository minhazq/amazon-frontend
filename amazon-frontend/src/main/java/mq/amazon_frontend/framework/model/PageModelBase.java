package mq.amazon_frontend.framework.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageModelBase {

	protected WebDriver driver;
	protected static Logger logger ;

	public PageModelBase(WebDriver wd) {
		PageFactory.initElements(wd, this);
		driver = wd;
		logger = LogManager.getLogger(this);
	}
	
	
}
