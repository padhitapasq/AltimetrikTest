package com.timesofindia.defs;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.util.Reporter;
import com.timesofindia.pages.HomePage;
import com.timesofindia.utils.CommonSteps;

/*
 * StepDefination : to enhance the project if in case BDD is required.
 */
@QAFTestStepProvider
public class HomePageDefs {

	HomePage homePage;

	@QAFTestStep(description = "Decline notifications")
	public void declineNotifications() {
		homePage = new HomePage();
		homePage.declineNotification();
	}

	@QAFTestStep(description = "Entertainment section verification")
	public void verifyEntertainmentSection() {
		homePage = new HomePage();
		homePage.verifyPageOpen();
		homePage.verifyEntertainmentSectionOnPage();
	}

	@QAFTestStep(description = "Extract entertainment section's news")
	public void getEntertainmentNewsList() {
		homePage = new HomePage();
		homePage.getListOfEntertainmentNews();
	}

	@QAFTestStep(description = "Verify total number of image displayed")
	public void verifyTotalNumberOfImage() {
		homePage = new HomePage();
		homePage.verifyThreeImageInDisplayList();
		Reporter.log("Verifying after clicking on Next button");
		CommonSteps.clickUsingJS(homePage.getEntNextButton());
		// homePage.getEntNextButton().click();
		QAFTestBase.pause(2000);
		homePage.verifyThreeImageInDisplayList();
		Reporter.log("Verifying after clicking on Back button");
		CommonSteps.clickUsingJS(homePage.getEntBackButton());
		// homePage.getEntBackButton().click();
		QAFTestBase.pause(2000);
		homePage.verifyThreeImageInDisplayList();
	}

	@QAFTestStep(description = "Reading sub news")
	public void readSubNews() {
		homePage = new HomePage();
		homePage.readSubNews();
		homePage.readSubNewsForLang("Hindi");
		homePage.readSubNewsForLang("English");
		homePage.readSubNewsForLang("Tamil");
		homePage.readSubNewsForLang("Telugu");
		homePage.readSubNewsForLang("Marathi");
		homePage.readSubNewsForLang("Gujarati");

	}
	
	@QAFTestStep(description = "Click on {0} and verify page")
	public void clickOnAnyLangAndVerifyPage(String lang){
		homePage = new HomePage();
		homePage.clickOnLanguageAndValidatePage(lang);
	}

}
