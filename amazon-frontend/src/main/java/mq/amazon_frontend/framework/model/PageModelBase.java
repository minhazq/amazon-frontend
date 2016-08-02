package mq.amazon_frontend.framework.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Predicate;
import mq.amazon_frontend.framework.Scriptbase;

//Each Model Page should consist of Header and Footer no matter what kind of Page it is. 
//The best place to put header and footer 
public abstract class PageModelBase implements HeaderModel , FooterModel{

	protected WebDriver driver;
	protected static Logger logger ;

	//Default Constructor delceared for ControllerBase class
	//Also made sure the driver instance is passed
	public PageModelBase(){
		this.driver = Scriptbase.driver;
		PageFactory.initElements(this.driver, this);
		logger = LogManager.getLogger(this);
		waitForPageLoad(this.driver);
	}
	
	
	//Using GUAVA Library. Used to check of the page is loaded or not
	static void waitForPageLoad(WebDriver wdriver) {
	    WebDriverWait wait = new WebDriverWait(wdriver, 60);
	    Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {
	        public boolean apply(WebDriver input) {
	            logger.info("Waiting for the page to be loaded...");
	        	//Will not work for the AJAX part
	            return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
	        }

	    };
	    wait.until(pageLoaded);
	}
	
	//========HEADER MODEL==================
	public WebElement searchInputBox(){
		return driver.findElement(By.id("twotabsearchtextbox"));
	}
	
	public WebElement DepartmentsDropDown(){
		return driver.findElement(By.id("nav-link-shopall"));
	}
	public WebElement ListsDropDown(){
		return driver.findElement(By.id("nav-link-wishlist"));
	}
	public WebElement cartIcon(){
		return driver.findElement(By.id("nav-cart"));
	}
	
	public WebElement searchButton(){
		return driver.findElement(By.xpath("//input[@class='nav-input']"));
	}
	
	//==============FOOTER MODEL==============
	public WebElement careersTxtLink(){
		return driver.findElement(By.xpath("//a[@href='https://www.amazon.jobs']"));
	}
	public WebElement sellOnAmazonTxtLink(){
		return driver.findElement(By.xpath("//a[contains(text(),'Sell on Amazon')]"));
	}
	public WebElement yourAccountTxtLink(){
		return driver.findElement(By.xpath("//a[contains(text(),'Your Account')]"));
		}
	public WebElement yourOrders(){
		return driver.findElement(By.xpath("//a[contains(text(),'Your Orders')]"));
		}
	
}
