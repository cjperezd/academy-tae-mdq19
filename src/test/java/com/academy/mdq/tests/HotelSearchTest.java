package com.academy.mdq.tests;

import com.academy.mdq.pages.Home;
import com.academy.mdq.pages.hotel.HotelResultCard;
import com.academy.mdq.pages.hotel.HotelResults;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelSearchTest extends BaseTestSuite {

    @Test
    public void searchResults() {
        String destination = "Miami Beach";
        String property = "Faena Hotel Miami Beach";

        HotelResults resultDest = new Home()
            .goToHotels()
            .enterDestination(destination)
            .enterCheckIn("03/30/2019")
            .pickLastDay(10)
            .selectAdults(4)
            .selectChildren(1)
            .selectAge(7)
            .search();

        //enter date by text
        //HotelResults resultDest = hotelPage.enterDestination(destination).enterCheckIn("03/30/2019").enterCheckOut("04/17/2019").selectAdults(4).selectChildren(1).selectAge(7).search();

        HotelResultCard resultProp = resultDest.verifyResults(destination).searchProperty("Faena").selectGo();
        // TODO: 1 Refactor HotelResults to have a list of HotelResultCard
        // TODO: 2 Validate total results at test level
        // TODO: 3 Validate that every result card is from Miami Beach

        //wait for property result page to load, verify results
        resultProp.waiting();
        assertEquals("The image is visible", resultProp.isImgDivVisible(), true);
        assertEquals("The name of hotel is enable and visible", resultProp.isHotelLiEnable() && resultProp.isHotelLiEqual(property), true);
        assertEquals("The area is visible", resultProp.isAreaLiVisible(), true);
        assertEquals("The phone is visible", resultProp.isPhoneLiVisible(), true);
        assertEquals("The stars are visible", resultProp.isStarLiVisible(), true);
        assertEquals("The rate is visible", resultProp.isReviewLiVisible(), true);
        assertEquals("The price is visible", resultProp.isPriceSpanVisible(), true);
    }

}
