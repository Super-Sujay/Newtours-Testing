package com.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newtours.base.BaseTest;
import com.newtours.pages.MercuryPurchase2Page;
import com.newtours.pages.MercuryPurchasePage;
import com.newtours.pages.MercuryReservation2Page;
import com.newtours.pages.MercuryReservationPage;
import com.newtours.pages.MercurySignOnPage;
import com.newtours.utilities.BrowserUtilities;
import com.newtours.utilities.Constants;
import com.newtours.utilities.ScreenShot;

/**
 * This class is used to test all the web-pages of the <b>Mercury Tours</b> web-site.
 * 
 * @author Sujay Sawant
 *
 */
public class BookFlightTest extends BaseTest {
	
	@BeforeClass
	public void setUp() {
		BrowserUtilities.openWebsite(getWebDriver(), Constants.mercuryToursWebsite);
		BrowserUtilities.refreshWebpage(getWebDriver());
	}

	/**
	 * This method uses the <b>Page Objects</b> and the <b>Methods</b> from all the <b>Page Classes</b>.
	 */
	@Test(description = "This method is used to test the overall functionality of the web-site")
	public void bookFlights() {
		MercurySignOnPage.login();
		Assert.assertTrue(MercuryReservationPage.flightFinderBanner.isPresent(), "Unable to Log In.");
		MercuryReservationPage.roundTrip.click();
		MercuryReservationPage.passengers.select("2");
		MercuryReservationPage.departure(Constants.airport_sanFrancisco, Constants.month_may, "21");
		MercuryReservationPage.arrival(Constants.airport_seattle, Constants.month_october, "12");
		MercuryReservationPage.businessClass.click();
		MercuryReservationPage.airline.select(Constants.airline_blueSkiesAirlines);
		MercuryReservationPage.continueNext.click();
		Assert.assertTrue(MercuryReservation2Page.selectFlightBanner.isPresent(), "Unable to Navigate to Select Flight page.");
		MercuryReservation2Page.selectFlights(MercuryReservation2Page.unifiedAirlines363, MercuryReservation2Page.pangeaAirlines632);
		Assert.assertTrue(MercuryPurchasePage.bookAFlightBanner.isPresent(), "Unable to Navigate to Book A Flight page.");
		System.out.println("The Total Price (including taxes) is " + MercuryPurchasePage.totalPrice.getText());
		MercuryPurchasePage.enterPassengerDetails1("Tywin", "Lannister", Constants.meal_diabetic);
		MercuryPurchasePage.enterCreditCardDetails(Constants.card_dinersClub, "5010254125699589", "12", "2005", "Tywin", "Tytos", "Lannister");
		MercuryPurchasePage.ticketlessTravel.check(false);
		MercuryPurchasePage.enterBillingAddress("Hand of the King", "Tower of the Hand", "Kings Landing", "Westeros", "12345", Constants.country_unitedKingdom);
		MercuryPurchasePage.sameAsBillingAddress.check(true);
		MercuryPurchasePage.enterDeliveryAddress("Hand of the King", "Tower of the Hand", "Kings Landing", "Westeros", "12345", Constants.country_unitedKingdom);
		MercuryPurchasePage.alert.accept("Delivery Address Alert", true);
		MercuryPurchasePage.securePurchase.click();
		Assert.assertTrue(MercuryPurchase2Page.flightConfirmationBanner.isPresent(), "Unable to Navigate to Flight Confirmation page.");
		System.out.println("The Total Price (including taxes) is " + MercuryPurchase2Page.totalPrice.getText());
		ScreenShot.takeScreenShot("Flight Confirmation");
		MercuryPurchase2Page.signOff();
		Assert.assertTrue(MercurySignOnPage.signOnBanner.isPresent(), "Unable to Log Off.");
	}

}
