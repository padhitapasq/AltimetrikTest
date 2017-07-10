package com.timesofindia.pages;

import java.util.List;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.timesofindia.utils.CommonSteps;
/*
 * POM(design pattern) :Page level locators and corresponding methods
 */
public class HindiNewsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "hindi.news.trending.now")
	public QAFWebElement tendingnow;

	@FindBy(locator = "hindi.news.trending.now.list")
	public List<QAFWebElement> trendingnowlist;

	@FindBy(locator = "hindi.news.image.list")
	public List<QAFWebElement> imagelist;

	@FindBy(locator = "hindi.news.news.list")
	public List<QAFWebElement> newslist;

	public QAFWebElement getTendingNow() {
		return tendingnow;
	}

	public List<QAFWebElement> getTrendingNowList() {
		return trendingnowlist;
	}

	public List<QAFWebElement> getImageList() {
		return imagelist;
	}

	public List<QAFWebElement> getNewsList() {
		return newslist;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	public void getListOfTendingNow() {

		for (int i = 0; i < getTrendingNowList().size(); i++) {
			Reporter.log(getTrendingNowList().get(i).getText());
		}

	}

	public void verifyImageForNews() {

		for (int i = 0; i < getImageList().size(); i++) {
			CommonSteps.mouseHoverToElement(getNewsList().get(i));
			Validator.verifyThat("Image for news ", getImageList().get(i).getAttribute("id"),
					Matchers.containsString(getNewsList().get(i).getAttribute("id")));
		}

	}

}
