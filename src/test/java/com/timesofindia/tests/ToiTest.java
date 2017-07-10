package com.timesofindia.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.timesofindia.defs.HindiNewsDefs;
import com.timesofindia.defs.HomePageDefs;
import com.timesofindia.pages.HomePage;
import com.timesofindia.utils.CommonSteps;

public class ToiTest extends WebDriverTestCase {

	HomePageDefs homePage;
	HindiNewsDefs hindiNews;
	HomePage page;
	CommonSteps common;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		page = new HomePage();
		homePage = new HomePageDefs();
		hindiNews = new HindiNewsDefs();
		common = new CommonSteps();
		page.launchPage(null);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		new WebDriverTestBase().tearDown();
	}


	@Test(description = "Times Of India Entertainment", groups = "p1")
	public void toiPageVerificationEntertainment() {
		
		homePage.declineNotifications();
		homePage.verifyEntertainmentSection();
		homePage.getEntertainmentNewsList();
		homePage.verifyTotalNumberOfImage();
		CommonSteps.mouseHoverToElement(page.getEntertainmentHeaderText());
		homePage.readSubNews();
		homePage.clickOnAnyLangAndVerifyPage("Hindi");
		hindiNews.getListOfTrendingNow();
		hindiNews.verifyNewsImage();
		
	}
}
