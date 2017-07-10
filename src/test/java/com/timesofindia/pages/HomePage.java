package com.timesofindia.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.core.QAFTestBase;
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
public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "timesofindia.notification.popup")
	public QAFWebElement notificationpopup;

	@FindBy(locator = "timesofindia.notification.popup.enable.button")
	public QAFWebElement notificationpopupenable;

	@FindBy(locator = "timesofindia.notification.popup.notnow.button")
	public QAFWebElement notificationpopupnotnow;

	@FindBy(locator = "timesofindia.logo")
	public QAFWebElement timesofindialog;

	@FindBy(locator = "timesofindia.topnews.text")
	public QAFWebElement topnewstext;

	@FindBy(locator = "timesofindia.entertainment.title")
	public QAFWebElement entertainmentheader;

	@FindBy(locator = "timesofindia.entertainment.news.list")
	public List<QAFWebElement> entertainmentnewslist;

	@FindBy(locator = "timesofindia.entertainment.image.list")
	public List<QAFWebElement> entertainmentimagelist;

	@FindBy(locator = "timesofindia.entertainment.back.arrow")
	public QAFWebElement backbutton;

	@FindBy(locator = "timesofindia.entertainment.next.arrow")
	public QAFWebElement nextbutton;

	@FindBy(locator = "timesofindia.entertainment.text.header")
	public QAFWebElement entertainmenttext;

	@FindBy(locator = "timesofindia.entertainment.language.list")
	public List<QAFWebElement> sublanglist;

	@FindBy(locator = "timesofindia.entertainment.subnews.list")
	public List<QAFWebElement> subnewslist;

	public QAFWebElement getNotificationPopup() {
		return notificationpopup;
	}

	public QAFWebElement getNotificationPopupEnable() {
		return notificationpopupenable;
	}

	public QAFWebElement getNotificationPopupNotnow() {
		return notificationpopupnotnow;
	}

	public QAFWebElement getTOILogo() {
		return timesofindialog;
	}

	public QAFWebElement getTopNewsText() {
		return topnewstext;
	}

	public QAFWebElement getEntertainmentHeader() {
		return entertainmentheader;
	}

	public List<QAFWebElement> getEntertainmentNewsList() {
		return entertainmentnewslist;
	}

	public List<QAFWebElement> getEntertainmentImageList() {
		return entertainmentimagelist;
	}

	public QAFWebElement getEntBackButton() {
		return backbutton;
	}

	public QAFWebElement getEntNextButton() {
		return nextbutton;
	}

	public QAFWebElement getEntertainmentHeaderText() {
		return entertainmenttext;
	}

	public List<QAFWebElement> getSubLangList() {
		return sublanglist;
	}

	public List<QAFWebElement> getSubNewsList() {
		return subnewslist;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.manage().window().maximize();
		driver.get("/");

	}

	public void declineNotification() {

		try {
			getNotificationPopup().waitForPresent(10000);
			getNotificationPopup().verifyPresent("Notification Pop-Up");
			getNotificationPopupEnable().verifyPresent("Not now button on Pop-Up");
			getNotificationPopupNotnow().verifyPresent("Not now button on Pop-Up");
			Reporter.log("Declining popup - Not to receive notofications");
			getNotificationPopupNotnow().click();
		} catch (Exception e) {
			Reporter.log("No notification present");
		}

	}

	public void verifyPageOpen() {
		try {
			getTopNewsText().verifyPresent();
		} catch (Exception e) {
			getTopNewsText().waitForPresent(5000);
		}
	}

	public void verifyEntertainmentSectionOnPage() {
		try {
			getEntertainmentHeader().verifyPresent();
		} catch (Exception e) {
			Reporter.log("Entertainment section not found ", MessageTypes.Fail);
		}
	}

	public List<String> getListOfEntertainmentNews() {
		int size = getEntertainmentNewsList().size();
		List<String> newsList = new ArrayList<String>();
		Reporter.log("Entertainment news size count is " + size);
		for (QAFWebElement element : getEntertainmentNewsList()) {
			newsList.add(element.getText());
			Reporter.log(element.getText());
		}
		return newsList;
	}

	public int verifyThreeImageInDisplayList() {
		int count = 0;
		for (QAFWebElement element : getEntertainmentImageList()) {
			if (element.isDisplayed()) {
				count += 1;
			}
		}
		Validator.verifyThat("Total number of image displayed : ", 3, Matchers.equalTo(count));
		return count;
	}

	public void readSubNews() {
		for (QAFWebElement element : getSubNewsList()) {
			Reporter.log(element.getText());
		}
	}

	public void readSubNewsForLang(String lang) {

		Reporter.log("Reading " + lang + " subnews.");

		Map<String, String> languageMap = new HashMap<String, String>();
		languageMap.put("Hindi", "rnav27135527");
		languageMap.put("English", "rnav27135489");
		languageMap.put("Tamil", "rnav27135454");
		languageMap.put("Telugu", "rnav27135440");
		languageMap.put("Marathi", "rnav27134572");
		languageMap.put("Gujarati", "rnav29982848");

		List<WebElement> subnewsElement = driver
				.findElements(By.xpath("//ul[@id='" + languageMap.get(lang) + "']/li/a"));

		for (QAFWebElement langElement : getSubLangList()) {
			if (langElement.getText().equalsIgnoreCase(lang)) {
				CommonSteps.mouseHoverToElement(langElement);
				QAFTestBase.pause(2000);
				for (int i = 0; i < subnewsElement.size(); i++) {
					Reporter.log(subnewsElement.get(i).getText());
				}
			}
		}
	}

	public void clickOnLanguageAndValidatePage(String lang) {

		for (QAFWebElement langElement : getSubLangList()) {
			if (langElement.getText().equalsIgnoreCase(lang)) {

				CommonSteps.mouseHoverToElement(langElement);
				CommonSteps.clickUsingJS(langElement);
				break;
			}
		}
		Validator.verifyThat("Page title is ", driver.getTitle(), Matchers.containsString(lang));
	}

}
