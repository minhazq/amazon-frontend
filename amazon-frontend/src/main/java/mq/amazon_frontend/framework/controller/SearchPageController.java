package mq.amazon_frontend.framework.controller;
import org.testng.Assert;

import mq.amazon_frontend.framework.Scriptbase;
import mq.amazon_frontend.framework.model.SearchPageModel;
import mq.amazon_frontend.framework.util.Utils;

public class SearchPageController extends ControllerBase{


	private SearchPageModel searchPageModel;
	
	public SearchPageController() {
		searchPageModel = new SearchPageModel();
		logger.debug("SearchPageController is created");
		
	}
	
	public void verifySearchText(){
		String actual = searchPageModel.searchResultTxt.getText();
		String expected = Utils.loadAppDataPropertiesFile().getProperty("searchText1");
		try{
			Assert.assertEquals(actual, expected);
		}catch(AssertionError ae){
			Scriptbase.assertAll = true;
			logger.error("Search Text FAILED , Actual = "+ actual+ " Expected= "+ expected);
		}
		
	}

}
