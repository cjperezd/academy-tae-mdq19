package CheckTest;

import Search.HotelPage;
import Search.HotelResults;
import Search.PropertyResults;
import Search.SelectHotels;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;

public class PageTest extends BaseTestSuite {

    @Test
    public void booking() {
        String destination = "Miami Beach";
        String property = "Faena Hotel Miami Beach";

        SelectHotels home = new SelectHotels();

        HotelPage hotelPage = home.selectButton();

        //verify all the elements on the page to load
        Assert.assertEquals("All elements are visible", hotelPage.isVisibleMethod(), true);

        //enter date by click
        HotelResults resultDest = hotelPage.enterDestination(destination).enterCheckIn("03/30/2019").pickLastDay(10).selectAdults(4).selectChildren(1).selectAge(7).selectButton();
        //enter date by text
//        HotelResults resultDest = hotelPage.enterDestination(destination).enterCheckIn("03/30/2019").enterCheckOut("04/17/2019").selectAdults(4).selectChildren(1).selectAge(7).selectButton();

        PropertyResults resultProp = resultDest.verifyResults(destination).searchProperty("Faena").selectGo();

        //wait for property result page to load, verify results
        resultProp.waiting();
        Assert.assertEquals("The image is visible", resultProp.isImgDivVisible(), true);
        Assert.assertEquals("The name of hotel is enable and visible", resultProp.isHotelLiEnable() && resultProp.isHotelLiEqual(property), true);
        Assert.assertEquals("The area is visible", resultProp.isAreaLiVisible(), true);
        Assert.assertEquals("The phone is visible", resultProp.isPhoneLiVisible(), true);
        Assert.assertEquals("The stars are visible", resultProp.isStarLiVisible(), true);
        Assert.assertEquals("The rate is visible", resultProp.isReviewLiVisible(), true);
        Assert.assertEquals("The price is visible", resultProp.isPriceSpanVisible(), true);
    }

}
