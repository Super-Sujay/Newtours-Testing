package com.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newtours.base.BaseTest;
import com.newtours.pages.MainWebsitePage;
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
public class BookIntraStateFlightTest extends BaseTest {
	
	@BeforeClass
	public void setUp() {
		BrowserUtilities.openWebsite(getWebDriver(), Constants.mercuryToursWebsite);
		BrowserUtilities.refreshWebpage(getWebDriver());
	}

	/**
	 * This method uses just the <b>Page Objects</b> from all the <b>Page Classes</b>.
	 */
	@Test(description = "This is the first test method")
	public void bookFlight1() {
		MainWebsitePage.signOn.click();
		MercurySignOnPage.userName.sendKeys(Constants.userName);
		MercurySignOnPage.password.sendKeys(Constants.password);
		MercurySignOnPage.submit.click();
		MercuryReservationPage.roundTrip.click();
		MercuryReservationPage.passengers.select("4");
		MercuryReservationPage.departingFrom.select(Constants.airport_sanFrancisco);
		MercuryReservationPage.fromMonth.select(Constants.month_may);
		MercuryReservationPage.fromDay.select("21");
		MercuryReservationPage.arrivingIn.select(Constants.airport_seattle);
		MercuryReservationPage.toMonth.select(Constants.month_october);
		MercuryReservationPage.toDay.select("15");
		MercuryReservationPage.businessClass.click();
		MercuryReservationPage.airline.select(Constants.airline_blueSkiesAirlines);
		MercuryReservationPage.continueNext.click();
		MercuryReservation2Page.unifiedAirlines363.click();
		MercuryReservation2Page.pangeaAirlines632.click();
		MercuryReservation2Page.continueNext.click();
		System.out.println("The Total Price (including taxes) is " + MercuryPurchasePage.totalPrice.getText());
		MercuryPurchasePage.passengersFirstName1.sendKeys("Tywin");
		MercuryPurchasePage.passengersLastName1.sendKeys("Lannister");
		MercuryPurchasePage.passengersMeal1.select(Constants.meal_lowCalorie);
		MercuryPurchasePage.passengersFirstName2.sendKeys("Tyrion");
		MercuryPurchasePage.passengersLastName2.sendKeys("Lannister");
		MercuryPurchasePage.passengersMeal2.select(Constants.meal_lowCholesterol);
		MercuryPurchasePage.passengersFirstName3.sendKeys("Cersei");
		MercuryPurchasePage.passengersLastName3.sendKeys("Lannister");
		MercuryPurchasePage.passengersMeal3.select(Constants.meal_bland);
		MercuryPurchasePage.passengersFirstName4.sendKeys("Jaime");
		MercuryPurchasePage.passengersLastName4.sendKeys("Lannister");
		MercuryPurchasePage.passengersMeal4.select(Constants.meal_diabetic);
		MercuryPurchasePage.creditCardType.select(Constants.card_dinersClub);
		MercuryPurchasePage.creditCardNumber.sendKeys("5010254125699589");
		MercuryPurchasePage.creditCardExpirationMonth.select("12");
		MercuryPurchasePage.creditCardExpirationYear.select("2005");
		MercuryPurchasePage.creditCardFirstName.sendKeys("Tywin");
		MercuryPurchasePage.creditCardMiddleName.sendKeys("Tytos");
		MercuryPurchasePage.creditCardLastName.sendKeys("Lannister");
		MercuryPurchasePage.ticketlessTravel.check(false);
		MercuryPurchasePage.billingAddress1.sendKeys("Hand of the King");
		MercuryPurchasePage.billingAddress2.sendKeys("Tower of the Hand");
		MercuryPurchasePage.billingCity.sendKeys("Kings Landing");
		MercuryPurchasePage.billingState.sendKeys("Westeros");
		MercuryPurchasePage.billingPostalCode.sendKeys("12345");
		MercuryPurchasePage.billingCountry.select(Constants.country_unitedKingdom);
		MercuryPurchasePage.sameAsBillingAddress.check(true);
		MercuryPurchasePage.deliveryAddress1.sendKeys("Hand of the King");
		MercuryPurchasePage.deliveryAddress2.sendKeys("Tower of the Hand");
		MercuryPurchasePage.deliveryCity.sendKeys("Kings Landing");
		MercuryPurchasePage.deliveryState.sendKeys("Westeros");
		MercuryPurchasePage.deliveryPostalCode.sendKeys("12345");
		MercuryPurchasePage.deliveryCountry.select(Constants.country_unitedKingdom);
		MercuryPurchasePage.alert.accept("Delivery Address Alert", true);
		MercuryPurchasePage.securePurchase.click();
		System.out.println("The Total Price (including taxes) is [" + MercuryPurchase2Page.totalPrice.getText()+ "]");
		ScreenShot.takeScreenShot("Flight Confirmation");
		MercuryPurchase2Page.logOut.click();
		Assert.assertTrue(MercurySignOnPage.signOnBanner.isPresent(), "Unable to Log Off.");
	}

	/**
	 * This method uses the <b>Page Objects</b> and the <b>Methods</b> from all the <b>Page Classes</b>.
	 */
	@Test(description = "This is the second test method")
	public void bookFlight2() {
		MercurySignOnPage.login();
		MercuryReservationPage.roundTrip.click();
		MercuryReservationPage.passengers.select("4");
		MercuryReservationPage.departure(Constants.airport_sanFrancisco, Constants.month_may, "21");
		MercuryReservationPage.arrival(Constants.airport_seattle, Constants.month_october, "12");
		MercuryReservationPage.businessClass.click();
		MercuryReservationPage.airline.select(Constants.airline_blueSkiesAirlines);
		MercuryReservationPage.continueNext.click();
		MercuryReservation2Page.selectFlights(MercuryReservation2Page.unifiedAirlines363, MercuryReservation2Page.pangeaAirlines632);
		System.out.println("The Total Price (including taxes) is " + MercuryPurchasePage.totalPrice.getText());
		MercuryPurchasePage.enterPassengerDetails1("Tywin", "Lannister", Constants.meal_lowCalorie);
		MercuryPurchasePage.enterPassengerDetails2("Tyrion", "Lannister", Constants.meal_lowCholesterol);
		MercuryPurchasePage.enterPassengerDetails3("Cersei", "Lannister", Constants.meal_bland);
		MercuryPurchasePage.enterPassengerDetails4("Jaime", "Lannister", Constants.meal_diabetic);
		MercuryPurchasePage.enterCreditCardDetails(Constants.card_dinersClub, "5010254125699589", "12", "2005", "Tywin", "Tytos", "Lannister");
		MercuryPurchasePage.ticketlessTravel.check(true);
		MercuryPurchasePage.enterBillingAddress("Hand of the King", "Tower of the Hand", "Kings Landing", "Westeros", "12345", Constants.country_unitedKingdom);
		MercuryPurchasePage.sameAsBillingAddress.check(false);
		MercuryPurchasePage.enterDeliveryAddress("Hand of the King", "Tower of the Hand", "Kings Landing", "Westeros", "12345", Constants.country_unitedStates);
		MercuryPurchasePage.alert.accept("Delivery Address Alert", true);
		MercuryPurchasePage.securePurchase.click();
		System.out.println("The Total Price (including taxes) is [" + MercuryPurchase2Page.totalPrice.getText() + "]");
		ScreenShot.takeScreenShot("Flight Confirmation");
		MercuryPurchase2Page.signOff();
		Assert.assertTrue(MercurySignOnPage.signOnBanner.isPresent(), "Unable to Log Off.");
	}

}
