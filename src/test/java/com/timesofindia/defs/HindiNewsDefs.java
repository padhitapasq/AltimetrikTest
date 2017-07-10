package com.timesofindia.defs;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.timesofindia.pages.HindiNewsPage;
import com.timesofindia.pages.HomePage;

/*
 * StepDefination : to enhance the project if in case BDD is required.
 */
@QAFTestStepProvider
public class HindiNewsDefs {

	HomePage homePage;
	HindiNewsPage hindiNewsPage;

	@QAFTestStep(description="Verify trending now section")
	public void getListOfTrendingNow() {
		hindiNewsPage = new HindiNewsPage();
		hindiNewsPage.getListOfTendingNow();

	}
	
	@QAFTestStep(description="Verify news Image for each news")
	public void verifyNewsImage() {
		hindiNewsPage = new HindiNewsPage();
		hindiNewsPage.verifyImageForNews();

	}

}
