package com.academy.mdq.tests.hotel;

import com.academy.mdq.pages.CheapTicketsHome;
import com.academy.mdq.pages.hotel.HotelSearch;
import com.academy.mdq.pages.hotel.HotelSearchResult;
import com.academy.mdq.testsuite.BaseTestSuite;
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
    hotelSearchResult.getCardsOnList();
    hotelSearchResult.getAreas();
    assertTrue("All are present in all cards", hotelSearchResult.areAreasInTheCards());
    hotelSearchResult.typeHotelName("Faena");
    assertTrue(hotelSearchResult.getAllWords(), hotelSearchResult.getAllWords().contains(CITY));



    hotelSearchResult.clickOnFirstOptionFae();
    hotelSearchResult.clickHotelSearchButton();
    hotelSearchResult.getAreas();
    hotelSearchResult.getCardsOnList();

    //hotelSearchResult.setCardsOnList();
    //hotelSearchResult.getAreas();

    assertTrue(hotelSearchResult.selectACard(0).isImageVisible());
    assertTrue(hotelSearchResult.selectACard(0).cardCityName());
    assertTrue(hotelSearchResult.selectACard(0).cardHotelName());
    assertTrue(hotelSearchResult.selectACard(0).cardNightlyClass());
    assertTrue(hotelSearchResult.selectACard(0).cardPhone());
    assertTrue(hotelSearchResult.selectACard(0).cardRate());
    assertTrue(hotelSearchResult.selectACard(0).cardStars());

    assertEquals("Faena Hotel Miami Beach", hotelSearchResult.selectACard(0).getHotelTitle());
  }
}