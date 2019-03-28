package com.academy.mdq.tests.hotel;


import com.academy.mdq.driver.Drivers;
import com.academy.mdq.pages.hotel.HomePage;
import com.academy.mdq.pages.hotel.HotelPayment;
import com.academy.mdq.pages.hotel.HotelRoomsReservation;
import com.academy.mdq.pages.hotel.HotelSearchResults;
import com.academy.mdq.testsuite.BaseTestSuite;


import org.junit.Test;

import java.time.LocalDate;

import static java.time.LocalDate.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class HotelSearchTest extends BaseTestSuite {

    String property = "Faena Hotel Miami Beach";
    LocalDate checkIn = now().plusMonths(2);

    private static final String CITY = "Miami Beach";

    @Test
    public void exercise1() {
        HotelSearchResults resultsPage = new HomePage()
                .clickHotelsButton()
                .typeDestination(CITY)
                //.selectCheckInDate(checkIn)
                //.selectCheckOutDate(checkIn.plusDays(10), checkIn.getMonthValue())
                .selectCheckIn(checkIn)
                .selectCheckOut(checkIn.plusDays(10), checkIn.getMonthValue())
                .selectAdults("4")
                .selectChildren("1")
                .selectChildrenAge("7")
                .clickOnSearchButton();

        //Assertions

        assertTrue(resultsPage.getHotelResultsTitle().contains(CITY));
        assertNotEquals("0", resultsPage.getTotalResults());
        //assertTrue(resultsPage.areCardsFromNeighborhood());
        resultsPage.enterHotelName(property);
        HotelSearchResults propertyResults = resultsPage.clickGoButton();
        assertTrue(propertyResults.selectCard(0).isVisibleImage());
        assertTrue(propertyResults.selectCard(0).isNameEnabled());
        assertEquals(property, propertyResults.selectCard(0).getHotelName());
        assertTrue(propertyResults.selectCard(0).isVisibleCity());
        assertTrue(propertyResults.selectCard(0).isVisiblePhone());
        assertTrue(propertyResults.selectCard(0).isVisibleStars());
        assertTrue(propertyResults.selectCard(0).isVisibleRate());
        assertTrue(propertyResults.selectCard(0).isVisibleNightlyPrice());
    }

    @Test
    public void exercise2() {
        HotelSearchResults resultsPage = new HomePage()
                .clickHotelsButton()
                .typeDestination(CITY)
                .selectCheckIn(checkIn)
                .selectCheckOut(checkIn.plusDays(10), checkIn.getMonthValue())
                .selectAdults("1")
                .clickOnSearchButton();

        HotelRoomsReservation hotelRoomsReservation = resultsPage.selectFirstResult()
                .clickReserveRoom();

        HotelPayment hotelPayment = hotelRoomsReservation.clickPayTotal();

        //Assertions

        assertTrue("CardHolder Name Input not displayed", hotelPayment.getCreditCardInfo().isDisplayedCardholderName());
        assertTrue("CardHolder Name Input not enabled", hotelPayment.getCreditCardInfo().isEnabledCardholderName());
        assertTrue("Card Number Input not displayed", hotelPayment.getCreditCardInfo().isDisplayedcardNumberInput());
        assertTrue("Card Number Input not enabled", hotelPayment.getCreditCardInfo().isEnabledcardNumberInput());
        assertTrue("Card Expiration Month Select not displayed", hotelPayment.getCreditCardInfo().isDisplayedexpirationMonthSelect());
        assertTrue("CardExpiration Month Select not enabled", hotelPayment.getCreditCardInfo().isEnabledexpirationMonthSelect());
        assertTrue("Card Expiration Year Select not displayed", hotelPayment.getCreditCardInfo().isDisplayedexpirationYearSelect());
        assertTrue("Card Expiration Year Select not enabled", hotelPayment.getCreditCardInfo().isEnabledexpirationYearSelect());
        assertTrue("Card Security Code Input not displayed", hotelPayment.getCreditCardInfo().isDisplayedsecurityCodeInput());
        assertTrue("Card Security Code Input not enabled", hotelPayment.getCreditCardInfo().isEnabledsecurityCodeInput());
        assertTrue("Card Zip Code Input not displayed", hotelPayment.getCreditCardInfo().isDisplayedzipCodeInput());
        assertTrue("Card Zip Code Input not enabled", hotelPayment.getCreditCardInfo().isEnabledZipCodeInput());


    }
}
