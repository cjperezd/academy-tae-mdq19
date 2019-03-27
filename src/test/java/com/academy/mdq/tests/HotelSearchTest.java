package com.academy.mdq.tests;

import com.academy.mdq.pages.Home;
import com.academy.mdq.pages.hotel.HotelResults;
import com.academy.mdq.pages.hotel.PropertyResults;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import java.time.LocalDate;

import static java.time.LocalDate.now;
import static org.junit.Assert.assertEquals;

public class HotelSearchTest extends BaseTestSuite {

  @Test
  public void searchResults() {
    String destination = "Miami Beach";
    String property = "Faena Hotel Miami Beach";
    LocalDate checkIn = now().plusMonths(14).minusDays(10);

    HotelResults resultDest = new Home()
        .goToHotels()
        .enterDestination(destination)
        .selectCheckIn(checkIn)
        .selectCheckOut(checkIn.plusDays(10), checkIn.getMonthValue())
        .selectAdults(4)
        .selectChildren(1)
        .selectAge(7)
        .search();

    //enter date by text
    //HotelResults resultDest = hotelPage.enterDestination(destination).enterCheckIn(checkIn).enterCheckOut("04/17/2019").selectAdults(4).selectChildren(1).selectAge(7).search();

    assertEquals("All the cards are from " + destination, resultDest.verifyCards(), true);

    PropertyResults resultProp = resultDest
        .searchProperty("Faena")
        .selectGo()
        .waiting();

    //wait for property result page to load, verify results
    assertEquals("The image is visible", resultProp.isFirstImgDivVisible(), true);
    assertEquals("The name of hotel is enable and equal", resultProp.isFirstHotelLiEnable() && resultProp.isFirstHotelLiEqual(property), true);
    assertEquals("The area is visible", resultProp.isFirstAreaLiVisible(), true);
    assertEquals("The phone is visible", resultProp.isFirstPhoneLiVisible(), true);
    assertEquals("The stars are visible", resultProp.isFirstStarLiVisible(), true);
    assertEquals("The rate is visible", resultProp.isFirstReviewLiVisible(), true);
    assertEquals("The price is visible", resultProp.isFirstPriceSpanVisible(), true);
  }

}
