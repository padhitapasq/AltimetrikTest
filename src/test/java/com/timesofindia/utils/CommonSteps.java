package com.timesofindia.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/*
 * utility methods (static methods): Can be used where ever required at any page
 */
public class CommonSteps {

	public static void navigateBack() {
		new WebDriverTestBase().getDriver().navigate().back();
	}

	public static void clickUsingJS(QAFWebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) new WebDriverTestBase().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public static void mouseHoverToElement(QAFWebElement element) {

		Actions action = new Actions(new WebDriverTestBase().getDriver());
		action.moveToElement(element).perform();
		QAFTestBase.pause(5000);
		

	}
}
