package mq.amazon_frontend.framework.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageModel extends PageModelBase{
	@FindBy(xpath="//div[@id='s-result-info-bar-content']/div[@class='a-column a-span8 a-spacing-none']/div/h2/span")
	public WebElement searchResultTxt;
}
