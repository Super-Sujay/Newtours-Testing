package com.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newtours.base.BaseTest;
import com.newtours.pages.MercuryReservationPage;
import com.newtours.pages.MercurySignOnPage;
import com.newtours.utilities.BrowserUtilities;
import com.newtours.utilities.Constants;

public class LoginTest extends BaseTest {
	
	@BeforeClass
	public void setUp() {
		BrowserUtilities.openWebsite(getWebDriver(), Constants.mercuryToursWebsite);
		BrowserUtilities.refreshWebpage(getWebDriver());
	}

	@Test
	public void login() {
		MercurySignOnPage.login();
		Assert.assertTrue(MercuryReservationPage.flightFinderBanner.isPresent(), "Unable to Log In");
		MercurySignOnPage.signOff();
		Assert.assertTrue(MercurySignOnPage.signOnBanner.isPresent(), "Unable to Log Off the website");
	}

}