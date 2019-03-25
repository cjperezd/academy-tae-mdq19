package com.academy.mdq.tests.hotel;


import com.academy.mdq.pages.hotel.HomePage;
import com.academy.mdq.pages.PropertyResultPage;
import com.academy.mdq.pages.hotel.HotelSearchResults;
import com.academy.mdq.testsuite.BaseTestSuite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class HotelSearchTest extends BaseTestSuite {

    private static final String CITY = "Miami Beach";

    @Test
    public void OneTest() {
        HotelSearchResults resultsPage = new HomePage()
            .clickHotelsButton()
            .typeDestination(CITY)
            .selectCheckInDate("05/20/2019")
            .selectCheckOutDate("05/23/2019")
            .selectAdults("4")
            .selectChildren("1")
            .selectChildrenAge("7")
            .clickOnSearchButton();

        assertNotEquals("0", resultsPage.getTotalResults());
        // FIXME: Validate that every result is from an specific area inside Miami Beach
        assertTrue(resultsPage.getPropertyTitle().contains(CITY));

        //selectOptionsHotel.selectCheckInDatePicker("20", "5", "2019");
        //selectOptionsHotel.selectCheckOutDatePicker();

        resultsPage.enterHotelName("Faena Hotel Miami Beach");

        PropertyResultPage propertyResults = resultsPage.clickGoButton();

        assertTrue(propertyResults.isVisibleImage());

        assertTrue(propertyResults.isNameEnabled());

        assertEquals("Faena Hotel Miami Beach", propertyResults.getHotelName());

        assertTrue(propertyResults.isVisibleCity());

        assertTrue(propertyResults.isVisiblePhone());

        assertTrue(propertyResults.isVisibleStars());

        assertTrue(propertyResults.isVisibleRate());

        assertTrue(propertyResults.isVisibleNightlyPrice());
    }
}
