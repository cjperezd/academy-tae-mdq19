package com.academy.mdq.Tests;



import com.academy.mdq.components.NavigationBar;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.HomePage;
import com.academy.mdq.pages.HotelsPage;
import com.academy.mdq.pages.SearchResultsPage;
import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.waits.Waits;
import org.junit.Test;

public class MyTest extends BaseTestSuite {

    @Test
    public void OneTest ()
    {
        HomePage homePage = new HomePage();

        HotelsPage selectOptionsHotel = homePage.clickOnButton();

        selectOptionsHotel.typeDestination("Miami Beach");
        selectOptionsHotel.selectCheckInDate("03/30/2019");
        selectOptionsHotel.selectCheckOutDate("04/06/2019");
        selectOptionsHotel.selectAdults("4");
        selectOptionsHotel.selectChildren("1");
        selectOptionsHotel.selectChildrenAge("7");

        SearchResultsPage resultsPage = selectOptionsHotel.clickOnSearchButton();

        resultsPage.closePopUp();



    }
}
