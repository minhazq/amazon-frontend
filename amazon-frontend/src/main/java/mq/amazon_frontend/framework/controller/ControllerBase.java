package mq.amazon_frontend.framework.controller;

import org.openqa.selenium.WebDriver;

public abstract class ControllerBase {

	protected WebDriver driver ;
	
	public ControllerBase( WebDriver driver){
		this.driver = driver;
	}
}
