import com.academy.mdq.pages.CheapTickets.CheapTickets;
import com.academy.mdq.pages.CheapTickets.HotelPage;
import com.academy.mdq.pages.CheapTickets.SearchHotelPage;
import com.academy.mdq.testsuite.BaseTestSuite;

import com.academy.mdq.waits.Waits;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyTest extends BaseTestSuite {

    @Test
    public void myTest() {

        CheapTickets home = new CheapTickets();
        SearchHotelPage searchHotelPage = new SearchHotelPage();
        HotelPage hotelPage = new HotelPage();
        String text= ("Miami Beach");
        String inDate = ("08/05/2019");
        String outDate = ("08/15/2019");
        String adults = ("4");
        String childrens = ("1");
        String childrensYear = ("7");
        String hotelType = ("Faena");
        String properties ="0";
        String hotelName = "Faena Hotel Miami Beach";
        home.clickOn();
        searchHotelPage.writeOnHotelComp(text)
                //.clickOnFirstOption()
                .writeOnCheckIn(inDate);
                //.clickCheckInCalendarDay();
        searchHotelPage.writeOnCheckOut(outDate)
                .writeAdults(adults)
                .writeChildrens(childrens)
                .writeChildrensYear(childrensYear)
                .clickSearch();
        hotelPage.writeHotelName(hotelType);
        assertNotEquals(properties,hotelPage.getTheTitle()[2]);
        assertTrue(hotelPage.getAllWords(),hotelPage.getAllWords().contains("Miami Beach"));
        hotelPage.clickOnFirstOptionFae()
                .clickHotelSearchButton()
                .cardImageVisible();
        hotelPage.cardCityName();
        hotelPage.cardHotelName();
        hotelPage.cardNightlyClass();
        hotelPage.cardPhone();
        hotelPage.cardRate();
        hotelPage.cardStars();
        assertEquals(hotelName,hotelPage.getHotelTitle());
    }
}
