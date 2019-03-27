package com.academy.mdq.tests.hotel;

import com.academy.mdq.driver.Drivers;
import com.academy.mdq.pages.CheapTicketsHome;
import com.academy.mdq.pages.hotel.HotelDetails;
import com.academy.mdq.pages.hotel.HotelDetailsResult;
import com.academy.mdq.pages.hotel.HotelSearch;
import com.academy.mdq.pages.hotel.HotelSearchResult;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static com.academy.mdq.pages.CheapTicketsHome.Product.HOTEL;
import static java.time.LocalDate.now;

public class HotelReserveTest extends BaseTestSuite {

    private static final String CITY = "Miami Beach";
    private static final Set<String> AREAS =  new HashSet<>();

    @Test
    public void myTest() {
        CheapTicketsHome home = new CheapTicketsHome();
        HotelSearch hotelSearch = (HotelSearch) home.clickOn(HOTEL);
        LocalDate checkIn = now().plusMonths(14).minusDays(10);
        HotelSearchResult hotelSearchResult = hotelSearch.typeGoingTo(CITY)
                .selectCheckIn(checkIn)
                .selectCheckOut(checkIn.plusDays(10), checkIn.getMonthValue())
                //.typeCheckIn("10/05/2019")
                //.typeCheckOut("10/15/2019")
                .selectAdults("1")
                .selectChildren("0")
                .clickSearch();

        hotelSearchResult.getCardsOnList();
        //Drivers.getDriver().getWebDriver().switchTo().
        HotelDetails hotelDetails = hotelSearchResult.getFirstHotel();
        hotelSearchResult.switchToNewWindow();
        hotelDetails.clickReserveHotel();
        HotelDetailsResult hotelDetailsResult = hotelDetails.clickPayButton();

        Assert.assertTrue(hotelDetailsResult.isInputCardNameVisible());
        Assert.assertTrue(hotelDetailsResult.isInputCardNumberVisible());
        Assert.assertTrue(hotelDetailsResult.isExpirationDateMonthVisible());
        Assert.assertTrue(hotelDetailsResult.isExpirationDateYearVisible());
        Assert.assertTrue(hotelDetailsResult.isSecurityCodeVisible());
        Assert.assertTrue(hotelDetailsResult.isBillingZipCodeVisible());
    }
}
