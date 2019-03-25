package com.academy.mdq.tests.hotel;

import com.academy.mdq.pages.CheapTickets;
import com.academy.mdq.pages.hotel.HotelSearchResult;
import com.academy.mdq.pages.hotel.HotelSearch;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.academy.mdq.pages.CheapTickets.Product.HOTEL;
import static org.junit.Assert.*;

public class HotelSearchTest extends BaseTestSuite {

  private static final String CITY = "Miami Beach";
  private static final Set<String> AREAS =  new HashSet<>();

  @Test
  public void myTest() {
    CheapTickets home = new CheapTickets();
    HotelSearch hotelSearch = (HotelSearch) home.clickOn(HOTEL);
    HotelSearchResult hotelSearchResult = hotelSearch.typeGoingTo(CITY)
        .typeCheckIn("08/05/2019")
        .typeCheckOut("08/15/2019")
        .selectAdults("4")
        .selectChildren("1")
        .selectChildrenYear("7")
        .clickSearch();

    assertNotEquals("0", hotelSearchResult.getTotalResults());
    // TODO Validate results card are all for Miami Beach

    hotelSearchResult.writeHotelName("Faena");
    assertTrue(hotelSearchResult.getAllWords(), hotelSearchResult.getAllWords().contains(CITY));

    hotelSearchResult.clickOnFirstOptionFae().clickHotelSearchButton();

    assertTrue(hotelSearchResult.isCardVisible());
    hotelSearchResult.cardCityName();
    hotelSearchResult.cardHotelName();
    hotelSearchResult.cardNightlyClass();
    hotelSearchResult.cardPhone();
    hotelSearchResult.cardRate();
    hotelSearchResult.cardStars();

    assertEquals("Faena Hotel Miami Beach", hotelSearchResult.getHotelTitle());
  }
}
