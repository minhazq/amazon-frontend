package mq.amazon_frontend.framework.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public abstract class PageModelBase {

	protected WebDriver driver;
	protected static Logger logger ;

	public PageModelBase(WebDriver wd) {
		PageFactory.initElements(wd, this);
		driver = wd;
		logger = LogManager.getLogger(this);
		waitForPageLoad(wd);
	}
	
	static void waitForPageLoad(WebDriver wdriver) {
	    WebDriverWait wait = new WebDriverWait(wdriver, 60);
	    Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {

	        @Override
	        public boolean apply(WebDriver input) {
	            logger.info("Waiting for the page to be loaded...");
	        	return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
	        }

	    };
	    wait.until(pageLoaded);
	}
	
}
