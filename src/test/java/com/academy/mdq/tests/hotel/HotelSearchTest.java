package com.academy.mdq.tests.hotel;


import com.academy.mdq.pages.hotel.HomePage;
import com.academy.mdq.pages.hotel.HotelSearchResults;
import com.academy.mdq.testsuite.BaseTestSuite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class HotelSearchTest extends BaseTestSuite {

    private static final String CITY = "Miami Beach";

    @Test
    public void exercise1() {
        HotelSearchResults resultsPage = new HomePage()
            .clickHotelsButton()
            .typeDestination(CITY)
            //.selectCheckInDate("3/26/2019")
            .pickDateCheckIn("3/27/2019")
            .selectCheckOutDate("4/12/2019")
            .selectAdults("4")
            .selectChildren("1")
            .selectChildrenAge("7")
            .clickOnSearchButton();

        assertTrue(resultsPage.getHotelResultsTitle().contains(CITY));

        assertNotEquals("0", resultsPage.getTotalResults());

        assertTrue(resultsPage.areCardsFromNeighborhood());

        resultsPage.enterHotelName("Faena Hotel Miami Beach");

        HotelSearchResults propertyResults = resultsPage.clickGoButton();

        assertTrue(propertyResults.selectCard(0).isVisibleImage());

        assertTrue(propertyResults.selectCard(0).isNameEnabled());

        assertEquals("Faena Hotel Miami Beach", propertyResults.selectCard(0).getHotelName());

        assertTrue(propertyResults.selectCard(0).isVisibleCity());

        assertTrue(propertyResults.selectCard(0).isVisiblePhone());

        assertTrue(propertyResults.selectCard(0).isVisibleStars());

        assertTrue(propertyResults.selectCard(0).isVisibleRate());

        assertTrue(propertyResults.selectCard(0).isVisibleNightlyPrice());
    }
}
