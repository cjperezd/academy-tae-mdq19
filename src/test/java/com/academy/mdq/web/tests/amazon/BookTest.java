package com.academy.mdq.web.tests.amazon;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.commons.SearchResults;
import com.academy.mdq.web.pages.commons.ResultCard;
import com.academy.mdq.web.pages.commons.Cart;
import com.academy.mdq.web.pages.commons.Home;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookTest extends BaseTestSuite {

  private final static String BOOK_NAME = "Embracing the Power of AI";

  private final static String BOOK_PRICE = "17.96";

  @Test
  public void searchBookTest() {
    SearchResults searchResult = new Home()
        .searchBy("Books", BOOK_NAME);

    ResultCard resultCard = searchResult.getResultCard(0);

    assertTrue("ResultCard contains the name expected", resultCard.getProductNameLink().contains(BOOK_NAME));
    assertTrue("ResultCard contains the price expected", resultCard.getPrice().contains(BOOK_PRICE));

    Cart cart = searchResult.clickProductName(0)
        .addToCart()
        .goToCart();

    assertTrue("ResultCard from Cart contains the title expected", cart.getTitle().contains(BOOK_NAME));
    assertTrue("ResultCard from Cart contains the price expected", cart.getPrice().contains(BOOK_PRICE));

    cart.deleteItem();

    assertTrue("The delete information contains both book name and 'was removed from shopping cart' indication",
        cart.getRemovedInformationText().contains(BOOK_NAME)
            && cart.getRemovedInformationText().contains("was removed from Shopping Cart."));
  }


}
