package com.academy.mdq.tests.hotel;

import com.academy.mdq.pages.CheapTicketsHome;
import com.academy.mdq.pages.hotel.HotelSearchResult;
import com.academy.mdq.pages.hotel.HotelSearch;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.academy.mdq.pages.CheapTicketsHome.Product.HOTEL;
import static org.junit.Assert.*;

public class HotelSearchTest extends BaseTestSuite {

  private static final String CITY = "Miami Beach";
  private static final Set<String> AREAS =  new HashSet<>();

  @Test
  public void myTest() {
    CheapTicketsHome home = new CheapTicketsHome();
    HotelSearch hotelSearch = (HotelSearch) home.clickOn(HOTEL);
    HotelSearchResult hotelSearchResult = hotelSearch.typeGoingTo(CITY)
        .typeCheckIn("10/05/2019")
        .typeCheckOut("10/15/2019")
        .selectAdults("4")
        .selectChildren("1")
        .selectChildrenYear("7")
        .clickSearch();


    assertNotEquals("0", hotelSearchResult.getTotalResults());
    // TODO Validate results card are all for Miami Beach
    hotelSearchResult.initializer();
    System.out.println("Size: "+hotelSearchResult.initializer().size());

    hotelSearchResult.typeHotelName("Faena");
    assertTrue(hotelSearchResult.getAllWords(), hotelSearchResult.getAllWords().contains(CITY));

    hotelSearchResult.clickOnFirstOptionFae();
    hotelSearchResult.clickHotelSearchButton();

    assertTrue(hotelSearchResult.isCardVisible());
    assertTrue(hotelSearchResult.cardCityName());
    assertTrue(hotelSearchResult.cardHotelName());
    assertTrue(hotelSearchResult.cardNightlyClass());
    assertTrue(hotelSearchResult.cardPhone());
    assertTrue(hotelSearchResult.cardRate());
    assertTrue(hotelSearchResult.cardStars());

    assertEquals("Faena Hotel Miami Beach", hotelSearchResult.getHotelTitle());
  }
}
