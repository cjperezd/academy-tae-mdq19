package com.academy.mdq.web.tests.books;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.books.SearchResults;
import com.academy.mdq.web.pages.books.components.BookResultCard;
import com.academy.mdq.web.pages.commons.Cart;
import com.academy.mdq.web.pages.commons.Home;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookTest extends BaseTestSuite {

  private final static String BOOK_NAME = "Embracing the Power of AI";

  private final static String BOOK_PRICE = "$17.96";

  @Test
  public void SearchBookTest() {
    SearchResults searchResult = new Home()
        .searchBy("Books", BOOK_NAME);

    BookResultCard resultCard = searchResult.getResultCard(0);

    assertTrue("ResultCard contains the name expected", resultCard.getBookTitle().contains(BOOK_NAME));
    assertTrue("ResultCard contains the price expected", resultCard.getBookPrice().contains(BOOK_PRICE));

    Cart cart = searchResult.selectCardTitle(0)
        .addToCart()
        .goToCart();

    assertTrue("ResultCard from Cart contains the title expected", cart.getTitle().contains(BOOK_NAME));
    assertTrue("ResultCard from Cart contains the price expected", cart.getPrice().contains(BOOK_PRICE));

    cart.deleteItem();

    assertTrue("The delete information contains both book name and 'was removed from shopping cart' indication",
        cart.getRemovedInformation().contains(BOOK_NAME)
            && cart.getRemovedInformation().contains("was removed from Shopping Cart."));
  }

}
