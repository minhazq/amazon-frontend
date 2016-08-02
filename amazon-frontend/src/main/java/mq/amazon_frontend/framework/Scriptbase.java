package mq.amazon_frontend.framework;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import mq.amazon_frontend.framework.controller.ApplicationController;
import mq.amazon_frontend.framework.util.Utils;



public abstract class Scriptbase {

	public static WebDriver driver;
	protected Properties appDataProperties;
	private ApplicationController appController;
	protected static Logger logger ;
	protected Session session ;
	protected SessionFactory sessionFactory ;
	private AmazonWebService amazonWebService;
	public static  boolean assertAll = false;
	
	
	public Scriptbase(){
		setAppDataProperties();
		logger = LogManager.getLogger(this);
	}

	private void setAppDataProperties() {
		appDataProperties = Utils.loadAppDataPropertiesFile();
	}


	private void setAppController() {
		appController = new ApplicationController();
		amazonWebService = new AmazonWebService();
	}

	private void setDriver() {
		String browser = Utils.getBrowser();
		if(browser==null){
			setDefaultBrowser();

			//Doing singleton
		}else if(driver==null){
			if(browser.equals("firefox")){
				setDefaultBrowser(); // since firefox is my default browser
			}else if(browser.equalsIgnoreCase("chrome")){
					setChromeBrowser();
			}
		}


	}

	//getApplicationController
	protected ApplicationController amazon(){
		return appController;
	}
	
	
	protected AmazonWebService amazonWebService(){
		return amazonWebService;
	}
	
	
	@BeforeTest
	public void setup(){
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
		setDriver();
		setAppController(); // access point 
		loadHibernateSession();
		driver.manage().deleteAllCookies();
		driver.get(appDataProperties.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void afterMethod(){
		closeDriver();
		dropHibernateSession();
	}
	
	@AfterTest
	public void tearDown(){
		
	}
	
	protected WebDriver getDriver(){
		return driver;	
	}
	
	private void setDefaultBrowser(){
		driver = new FirefoxDriver();
	}
	
	private void setChromeBrowser() {
		if(Utils.getOSName().contains("mac")){
			System.setProperty("webdriver.chrome.driver", Utils.getProjectDirectory()+"//libs//browsers//chromedriver-mac");
		}else if(Utils.getOSName().contains("windows")){
			System.setProperty("webdriver.chrome.driver", Utils.getProjectDirectory()+"//libs//browsers//chromedriver-win.exe");
		}else{
			System.out.println("OS is not supported from Chrome Driver");
		}
		
		driver = new ChromeDriver();
	}
	
	private void loadHibernateSession(){
		
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	private void dropHibernateSession(){
		if(session!=null){
			session.close();
		}
		if(sessionFactory!=null){
			sessionFactory.close();
		}
	}
	
	private void closeDriver(){
		if(driver!=null){
			driver.close();
			driver = null;
		}
	}
	
	public void assertALL(String methodName){
		if(assertAll){
			Assert.fail(methodName + " : Test FAILED");
		}
	}
}
