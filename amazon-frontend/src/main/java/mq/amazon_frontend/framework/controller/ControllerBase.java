package mq.amazon_frontend.framework.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import mq.amazon_frontend.framework.Scriptbase;
import mq.amazon_frontend.framework.model.FooterModel;
import mq.amazon_frontend.framework.model.HeaderModel;
import mq.amazon_frontend.framework.model.PageModelBase;

//Each Controller should consist of Header and Footer no matter what kind of Page it is. 
//The best place to put header and footer 
public abstract class ControllerBase extends PageModelBase  implements HeaderController , FooterController{

	protected WebDriver driver ;
	protected static Logger logger ;
	
	public ControllerBase(){
		this.driver = Scriptbase.driver;
		logger = LogManager.getLogger(this);
	}
	
	//======HEADER CONTROLLER=========
	public void search(String searchText) {
		searchInputBox().sendKeys(searchText);
		searchButton().click();
	}
	public void clickDepartments() {
		//TODO:
	}
	public void clickLists() {
		//TODO:
	}
	public void clickCartIcon() {
		//TODO:
	}
	
	
	//=========FOOTER CONTROLLER===========
	
	public void clickCareersLink() {
		//TODO:
	}
	public void clickSellOnAmazonLink() {
		//TODO:
	}
	public void clickYourAccountLink() {
		//TODO:
	}
	public void clickYourOrdersLink() {
		//TODO:
	}
}
