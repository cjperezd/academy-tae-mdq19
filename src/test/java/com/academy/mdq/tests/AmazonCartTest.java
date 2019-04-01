package com.academy.mdq.tests;

import com.academy.mdq.pages.AmazonHomePage;
import com.academy.mdq.pages.CartListPage;
import com.academy.mdq.pages.SearchResultPage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;

public class AmazonCartTest extends BaseTestSuite {

  @Test
  public void saveInCart() {

    String search = "Embracing the Power of AI";
    String filter = "Books";
    String price = "17.96";

    SearchResultPage resultPage = new AmazonHomePage()
        .setFilter(filter)
        .search(search);

    Assert.assertEquals("The result of the book is correct", resultPage.checkFirstCard(search, price), true);

    CartListPage cartPage = resultPage.selectFirstCard()
        .addToCard()
        .goToCart();

    Assert.assertEquals("The book in the cart list is correct", cartPage.verifyFirstItem(search), true);

    CartListPage delete = cartPage.deleteFirstItem();

    Assert.assertEquals("The book has been deleted", delete.verifyDelete(), true);

  }

}
