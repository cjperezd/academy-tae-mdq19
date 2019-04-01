package com.academy.mdq.webFinal.test;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.webFinal.pages.amazon.AmazonHomePage;
import com.academy.mdq.webFinal.pages.amazon.AmazonPageBook;
import com.academy.mdq.webFinal.pages.amazon.AmazonResultPage;
import com.academy.mdq.webFinal.pages.amazon.CartPage;
import org.junit.Assert;
import org.junit.Test;

public class amazonTest extends BaseTestSuite {

    private static final String bookName = "Embracing the Power of AI";

    @Test
    public void myTest() throws InterruptedException {

        AmazonHomePage amazonHomePage = new AmazonHomePage();

        amazonHomePage.clickCategotySelector();
        amazonHomePage.clickOnBooks();
        amazonHomePage.typeText(bookName);
        AmazonResultPage amazonResultPage = amazonHomePage.clickOnGo();
        amazonResultPage.getCardsOnList();
        AmazonPageBook amazonPageBook = amazonResultPage.clickRightBook();
        amazonPageBook.clickOnAddToCart();
        CartPage cartPage = amazonPageBook.clickCartButton();
        cartPage.clickOnDelete();
        Thread.sleep(5000);
        Assert.assertTrue(cartPage.isTheName());





    }
}
