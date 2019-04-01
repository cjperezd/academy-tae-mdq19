package com.academy.mdq.web.tests.books;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.books.ResultDetails;
import com.academy.mdq.web.pages.books.SearchResults;
import com.academy.mdq.web.pages.commons.AddedToCartInfo;
import com.academy.mdq.web.pages.commons.Cart;
import com.academy.mdq.web.pages.commons.Home;
import org.junit.Assert;
import org.junit.Test;

public class BookTest extends BaseTestSuite {

  private String bookName = "Embracing the Power of AI";
  private String bookPrice = "$17.96";

  @Test
  public void SearchBookTest() {

    Home homePage = new Home();
    SearchResults searchResult = homePage.searchByBooks(bookName);
    //Verify Title and price are Equals To Expected
    Assert.assertTrue(searchResult.compareResults(bookName, bookPrice));
    ResultDetails result = searchResult.selectBook();
    AddedToCartInfo addedInfo = result.addToCart();
    Cart cart = addedInfo.goToCart();
    //Verify Title and price are Equals To Expected
    Assert.assertTrue(cart.compareResults(bookName, bookPrice));
    cart.deleteItem();
    //Verify Empty Cart message is Display
    Assert.assertEquals("Your Shopping Cart is empty.", cart.emptyCart());


  }
}
