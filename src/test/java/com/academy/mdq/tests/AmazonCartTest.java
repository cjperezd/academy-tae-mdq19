package com.academy.mdq.tests;

import com.academy.mdq.pages.AmazonHomePage;
import com.academy.mdq.pages.CartListPage;
import com.academy.mdq.pages.SearchResultPage;
import com.academy.mdq.pages.commons.ResultCard;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmazonCartTest extends BaseTestSuite {

  @Test
  public void saveInCart() {

    String search = "Embracing the Power of AI";
    String filter = "Books";
    String price = "17.96";

    SearchResultPage resultPage = new AmazonHomePage()
        .setFilter(filter)
        .search(search);

    ResultCard firstCard = resultPage.getResultCard(0);

    assertEquals("The name of the book is correct", firstCard.getTitle().contains(search), true);
    assertEquals("The price of the book is correct", firstCard.getOriginalPrice().contains(price), true);

    CartListPage cartPage = resultPage
        .selectCard(0)
        .addToCard()
        .goToCart();

    assertEquals("The book in the cart list is correct", cartPage.getCartItem(0).getTitle().contains(search), true);

    CartListPage delete = cartPage.deleteItem(0);

    assertEquals("The cart is empty", delete.emptyTitle().equals("Your Shopping Cart is empty."), true);
    assertEquals("The book has been deleted", delete.emptyMessage().contains(search), true);

  }

}
