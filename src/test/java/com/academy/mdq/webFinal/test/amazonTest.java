package com.academy.mdq.webFinal.test;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.webFinal.pages.amazon.AmazonHomePage;
import com.academy.mdq.webFinal.pages.amazon.AmazonResultPage;
import com.academy.mdq.webFinal.pages.amazon.CartPage;
import com.academy.mdq.webFinal.pages.amazon.TakeScreenshotRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.*;


@RunWith(Parameterized.class)
public class AmazonTest extends BaseTestSuite {


    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Embracing the Power of AI", "Books"},
                {"Notebook", "Computers"},
                {"Optical Illusion 3D Glow LED", "Home & Kitchen"},
                {"Slide It In", "Music, CDs & Vinyl"},
                {"Arduino", "Industrial & Scientific"}
        });
    }

    @Parameter
    public String productName;

    @Parameter(1)
    public String categoryInput;

    @Rule
    public TakeScreenshotRule screenShotRule = new TakeScreenshotRule();


    @Test
    public void myTest(){


        AmazonResultPage amazonResultPage = new AmazonHomePage().getSearchBar().selectCategory(categoryInput).typeBookText(productName).search();
        String searchedBookName = amazonResultPage.getFirstCard().getBookName();
        Assert.assertTrue("Product name matches expected value", searchedBookName.contains(productName));
        amazonResultPage.getFirstCard().selectBook().addToCart().cartButton();
        CartPage cartPage = new CartPage().clickOnDelete();
        Assert.assertTrue(cartPage.isCartEmpty("Your Shopping Cart is empty."));
    }
}
