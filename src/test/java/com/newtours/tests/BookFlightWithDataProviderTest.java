package com.newtours.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.newtours.utilities.CsvDataProvider;
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

public class BookFlightWithDataProviderTest extends BaseTest {

	@BeforeClass
	public void setUp() {
		BrowserUtilities.openWebsite(getWebDriver(), Constants.mercuryToursWebsite);
		BrowserUtilities.refreshWebpage(getWebDriver());
	}

	@Test(description = "This is the first test method", dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void bookFlight1(Map<String, String> testData) {
		MainWebsitePage.signOn.click();
		MercurySignOnPage.userName.sendKeys(Constants.userName);
		MercurySignOnPage.password.sendKeys(Constants.password);
		MercurySignOnPage.submit.click();
		MercuryReservationPage.roundTrip.click();
		MercuryReservationPage.passengers.select(testData.get("No of Passengers"));
		MercuryReservationPage.departingFrom.select(testData.get("Departure Airport"));
		MercuryReservationPage.fromMonth.select(testData.get("Departure Month"));
		MercuryReservationPage.fromDay.select(testData.get("Departure Date"));
		MercuryReservationPage.arrivingIn.select(testData.get("Arrival Airport"));
		MercuryReservationPage.toMonth.select(testData.get("Arrival Month"));
		MercuryReservationPage.toDay.select(testData.get("Arrival Date"));
		MercuryReservationPage.businessClass.click();
		MercuryReservationPage.airline.select(testData.get("Airline"));
		MercuryReservationPage.continueNext.click();
		MercuryReservation2Page.unifiedAirlines363.click();
		MercuryReservation2Page.pangeaAirlines632.click();
		MercuryReservation2Page.continueNext.click();
		System.out.println("The Total Price (including taxes) is " + MercuryPurchasePage.totalPrice.getText());
		MercuryPurchasePage.passengersFirstName1.sendKeys(testData.get("Passenger1 First Name"));
		MercuryPurchasePage.passengersLastName1.sendKeys(testData.get("Passenger1 Last Name"));
		MercuryPurchasePage.passengersMeal1.select(testData.get("Passenger1 Meal Type"));
		MercuryPurchasePage.creditCardType.select(testData.get("Credit Card Type"));
		MercuryPurchasePage.creditCardNumber.sendKeys(testData.get("Credit Card Number"));
		MercuryPurchasePage.creditCardExpirationMonth.select(testData.get("Credit Card Expiration Month"));
		MercuryPurchasePage.creditCardExpirationYear.select(testData.get("Credit Card Expiration Year"));
		MercuryPurchasePage.creditCardFirstName.sendKeys(testData.get("Credit Card First Name"));
		MercuryPurchasePage.creditCardMiddleName.sendKeys(testData.get("Credit Card Middle Name"));
		MercuryPurchasePage.creditCardLastName.sendKeys(testData.get("Credit Card Last Name"));
		MercuryPurchasePage.ticketlessTravel.check(false);
		MercuryPurchasePage.billingAddress1.sendKeys(testData.get("Billing Address Line1"));
		MercuryPurchasePage.billingAddress2.sendKeys(testData.get("Billing Address Line2"));
		MercuryPurchasePage.billingCity.sendKeys(testData.get("Billing City"));
		MercuryPurchasePage.billingState.sendKeys(testData.get("Billing State"));
		MercuryPurchasePage.billingPostalCode.sendKeys(testData.get("Billing Postal Code"));
		MercuryPurchasePage.billingCountry.select(testData.get("Billing Country"));
		MercuryPurchasePage.sameAsBillingAddress.check(true);
		MercuryPurchasePage.deliveryAddress1.sendKeys(testData.get("Delivery Address Line1"));
		MercuryPurchasePage.deliveryAddress2.sendKeys(testData.get("Delivery Address Line2"));
		MercuryPurchasePage.deliveryCity.sendKeys(testData.get("Delivery City"));
		MercuryPurchasePage.deliveryState.sendKeys(testData.get("Delivery State"));
		MercuryPurchasePage.deliveryPostalCode.sendKeys(testData.get("Delivery Postal Code"));
		MercuryPurchasePage.deliveryCountry.select(testData.get("Delivery Country"));
		MercuryPurchasePage.alert.accept("Delivery Address Alert", true);
		MercuryPurchasePage.securePurchase.click();
		System.out.println("The Total Price (including taxes) is [" + MercuryPurchase2Page.totalPrice.getText() + "]");
		ScreenShot.takeScreenShot("Flight Confirmation");
		MercuryPurchase2Page.logOut.click();
		Assert.assertTrue(MercurySignOnPage.signOnBanner.isPresent(), "Unable to Log Off.");
	}

	@Test(description = "This is the first test method", dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void bookFlight2(Map<String, String> testData) {
		MainWebsitePage.signOn.click();
		MercurySignOnPage.userName.sendKeys(Constants.userName);
		MercurySignOnPage.password.sendKeys(Constants.password);
		MercurySignOnPage.submit.click();
		MercuryReservationPage.roundTrip.click();
		MercuryReservationPage.passengers.select(testData.get("No of Passengers"));
		MercuryReservationPage.departingFrom.select(testData.get("Departure Airport"));
		MercuryReservationPage.fromMonth.select(testData.get("Departure Month"));
		MercuryReservationPage.fromDay.select(testData.get("Departure Date"));
		MercuryReservationPage.arrivingIn.select(testData.get("Arrival Airport"));
		MercuryReservationPage.toMonth.select(testData.get("Arrival Month"));
		MercuryReservationPage.toDay.select(testData.get("Arrival Date"));
		MercuryReservationPage.businessClass.click();
		MercuryReservationPage.airline.select(testData.get("Airline"));
		MercuryReservationPage.continueNext.click();
		MercuryReservation2Page.unifiedAirlines363.click();
		MercuryReservation2Page.pangeaAirlines632.click();
		MercuryReservation2Page.continueNext.click();
		System.out.println("The Total Price (including taxes) is " + MercuryPurchasePage.totalPrice.getText());
		MercuryPurchasePage.passengersFirstName1.sendKeys(testData.get("Passenger1 First Name"));
		MercuryPurchasePage.passengersLastName1.sendKeys(testData.get("Passenger1 Last Name"));
		MercuryPurchasePage.passengersMeal1.select(testData.get("Passenger1 Meal Type"));
		MercuryPurchasePage.passengersFirstName2.sendKeys("Tyrion");
		MercuryPurchasePage.passengersLastName2.sendKeys("Lannister");
		MercuryPurchasePage.passengersMeal2.select(Constants.meal_lowCholesterol);
		MercuryPurchasePage.passengersFirstName3.sendKeys("Cersei");
		MercuryPurchasePage.passengersLastName3.sendKeys("Lannister");
		MercuryPurchasePage.passengersMeal3.select(Constants.meal_bland);
		MercuryPurchasePage.passengersFirstName4.sendKeys("Jaime");
		MercuryPurchasePage.passengersLastName4.sendKeys("Lannister");
		MercuryPurchasePage.passengersMeal4.select(Constants.meal_diabetic);
		MercuryPurchasePage.creditCardType.select(testData.get("Credit Card Type"));
		MercuryPurchasePage.creditCardNumber.sendKeys(testData.get("Credit Card Number"));
		MercuryPurchasePage.creditCardExpirationMonth.select(testData.get("Credit Card Expiration Month"));
		MercuryPurchasePage.creditCardExpirationYear.select(testData.get("Credit Card Expiration Year"));
		MercuryPurchasePage.creditCardFirstName.sendKeys(testData.get("Credit Card First Name"));
		MercuryPurchasePage.creditCardMiddleName.sendKeys(testData.get("Credit Card Middle Name"));
		MercuryPurchasePage.creditCardLastName.sendKeys(testData.get("Credit Card Last Name"));
		MercuryPurchasePage.ticketlessTravel.check(false);
		MercuryPurchasePage.billingAddress1.sendKeys(testData.get("Billing Address Line1"));
		MercuryPurchasePage.billingAddress2.sendKeys(testData.get("Billing Address Line2"));
		MercuryPurchasePage.billingCity.sendKeys(testData.get("Billing City"));
		MercuryPurchasePage.billingState.sendKeys(testData.get("Billing State"));
		MercuryPurchasePage.billingPostalCode.sendKeys(testData.get("Billing Postal Code"));
		MercuryPurchasePage.billingCountry.select(testData.get("Billing Country"));
		MercuryPurchasePage.sameAsBillingAddress.check(true);
		MercuryPurchasePage.deliveryAddress1.sendKeys(testData.get("Delivery Address Line1"));
		MercuryPurchasePage.deliveryAddress2.sendKeys(testData.get("Delivery Address Line2"));
		MercuryPurchasePage.deliveryCity.sendKeys(testData.get("Delivery City"));
		MercuryPurchasePage.deliveryState.sendKeys(testData.get("Delivery State"));
		MercuryPurchasePage.deliveryPostalCode.sendKeys(testData.get("Delivery Postal Code"));
		MercuryPurchasePage.deliveryCountry.select(testData.get("Delivery Country"));
		MercuryPurchasePage.alert.accept("Delivery Address Alert", true);
		MercuryPurchasePage.securePurchase.click();
		System.out.println("The Total Price (including taxes) is [" + MercuryPurchase2Page.totalPrice.getText() + "]");
		ScreenShot.takeScreenShot("Flight Confirmation");
		MercuryPurchase2Page.logOut.click();
		Assert.assertTrue(MercurySignOnPage.signOnBanner.isPresent(), "Unable to Log Off.");
	}

}
