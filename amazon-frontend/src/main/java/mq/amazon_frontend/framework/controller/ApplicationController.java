package mq.amazon_frontend.framework.controller;


public class ApplicationController extends ControllerBase{

	private LandingPageController landingPageController;
	private SearchPageController searchPageController;
	
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
	

}
