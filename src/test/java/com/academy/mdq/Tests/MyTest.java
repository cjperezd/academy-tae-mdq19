package com.academy.mdq.Tests;


import com.academy.mdq.pages.HomePage;
import com.academy.mdq.pages.HotelsPage;
import com.academy.mdq.pages.PropertyResultPage;
import com.academy.mdq.pages.SearchResultsPage;
import com.academy.mdq.testsuite.BaseTestSuite;

import org.junit.Assert;
import org.junit.Test;

public class MyTest extends BaseTestSuite {

    @Test
    public void OneTest() {
        HomePage homePage = new HomePage();

        HotelsPage selectOptionsHotel = homePage.clickOnButton();

        selectOptionsHotel.typeDestination("Miami Beach");
        selectOptionsHotel.selectCheckInDate("05/20/2019");
        selectOptionsHotel.selectCheckOutDate("05/23/2019");
        selectOptionsHotel.selectAdults("4");
        selectOptionsHotel.selectChildren("1");
        selectOptionsHotel.selectChildrenAge("7");

        SearchResultsPage resultsPage = selectOptionsHotel.clickOnSearchButton();

        resultsPage.enterHotelName("Faena Hotel Miami Beach");

        //resultsPage.enterHotelName("Fae");

        PropertyResultPage propertyResults = resultsPage.clickGoButton();

        Assert.assertNotEquals("0", resultsPage.getPropertyQuantity());

        Assert.assertTrue(resultsPage.getPropertyTitle().contains("Miami Beach"));


        Assert.assertTrue(propertyResults.isDisplayed());

        Assert.assertTrue(propertyResults.isVisibleImage());

        Assert.assertTrue(propertyResults.isNameEnabled());

        Assert.assertEquals("Faena Hotel Miami Beach", propertyResults.getHotelName());

        Assert.assertTrue(propertyResults.isVisibleCity());

        Assert.assertTrue(propertyResults.isVisiblePhone());

        Assert.assertTrue(propertyResults.isVisibleStars());

        Assert.assertTrue(propertyResults.isVisibleRate());

        Assert.assertTrue(propertyResults.isVisibleNightlyPrice());


    }
}
