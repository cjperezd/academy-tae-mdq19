package CheckTest;

import Search.HotelPage;
import Search.HotelResults;
import Search.PropertyResults;
import Search.SelectHotels;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

public class PageTest extends BaseTestSuite {

    @Test
    public void booking() {
        SelectHotels home = new SelectHotels();
        String destination = "Miami Beach";
        String property = "Faena Hotel Miami Beach";

        HotelPage search = home.selectButton();

        HotelResults resultDest = search.enterDestination(destination).enterCheckin("06/20/19").enterCheckout("07/20/19").selectAdults(4).selectChildren(1).selectAge(7).selectButton();

        PropertyResults resultProp = resultDest.verifyResults(destination).searchProperty(property).selectGo();
    }

}
