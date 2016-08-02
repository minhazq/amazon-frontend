package mq.amazon_frontend.framework.controller;

import mq.amazon_frontend.framework.AmazonWebService;

public class ApplicationController extends ControllerBase{

	private LandingPageController landingPageController;
	private SearchPageController searchPageController;
	private AmazonWebService amazonWebService;
	
	public LandingPageController landingPage(){
		if(landingPageController==null){
			landingPageController = new LandingPageController();
		} 
		return landingPageController;
	}
	
	public SearchPageController searchPage(){
		if(searchPageController==null){
			searchPageController = new SearchPageController();
		} 
		return searchPageController;
	}
	
	public AmazonWebService amazonWebService(){
		if(amazonWebService==null){
			amazonWebService = new AmazonWebService();
		}
		
		return amazonWebService;
	}
	

}
