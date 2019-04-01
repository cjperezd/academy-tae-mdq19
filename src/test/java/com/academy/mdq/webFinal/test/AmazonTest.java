package com.academy.mdq.webFinal.test;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.webFinal.pages.amazon.AmazonHomePage;
import com.academy.mdq.webFinal.pages.amazon.AmazonPageBook;
import com.academy.mdq.webFinal.pages.amazon.AmazonResultPage;
import com.academy.mdq.webFinal.pages.amazon.CartPage;
import org.junit.Assert;
import org.junit.Test;

public class AmazonTest extends BaseTestSuite {

  private static final String bookName = "Embracing the Power of AI";

  @Test
  public void myTest() {

    AmazonResultPage amazonResultPage = new AmazonHomePage().getSearchBar().selectCategory("Books").typeBookText(bookName).search();

    String searchedBookName = amazonResultPage.getFirstCard().getBookName();

    Assert.assertTrue("Book name matches expected value", searchedBookName.contains(bookName));

    amazonResultPage.getFirstCard().selectBook().addToCart().cartButton();

//    AmazonPageBook amazonPageBook = amazonResultPage.clickRightBook();
//    amazonPageBook.addToCart();
//    CartPage cartPage = amazonPageBook.cartButton();
//    cartPage.clickOnDelete();
//    Assert.assertTrue(cartPage.isTheName());


  }
}
