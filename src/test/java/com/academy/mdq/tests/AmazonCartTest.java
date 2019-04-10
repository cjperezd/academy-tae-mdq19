package com.academy.mdq.tests;

import com.academy.mdq.pages.AmazonHomePage;
import com.academy.mdq.pages.CartListPage;
import com.academy.mdq.pages.SearchResultPage;
import com.academy.mdq.pages.commons.ResultCard;
import com.academy.mdq.reports.BasicExtentReport;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AmazonCartTest extends BaseTestSuite {

  @Parameters
  public static Collection<Object[]> data() {
    return asList(new Object[][]{
        {"Embracing the Power of AI", "Books", "17.96"},
        {"handbag", "Women's Fashion", "15.96"},
        {"Ray-Ban", "Men's Fashion", "178"},
        {"Yoyo", "Toys & Games", "9.39"},
        {"Bob Ross", "Arts & Crafts", "9.99"}
    });
  }

  private String search;
  private String filter;
  private String price;

  public AmazonCartTest(String search, String filter, String price) {
    this.search = search;
    this.filter = filter;
    this.price = price;
  }

  @BeforeClass
  public static void startReport() {
    BasicExtentReport.startReport();
  }

  @Before
  public void createTest() {
    BasicExtentReport.startTest("Looking for product: " + search + ", category: " + filter);
  }

  @Test
  public void saveInCart() {

    SearchResultPage resultPage = new AmazonHomePage()
        .setFilter(filter)
        .search(search);

    ResultCard firstCard = resultPage.getResultCard(0);

    collector.checkThat("The name of the product is correct", firstCard.getTitle().toLowerCase(), containsString(search.toLowerCase()));
    collector.checkThat("The price of the product is correct", firstCard.getOriginalPrice(), containsString(price));

    CartListPage cartPage = resultPage
        .selectCard(0)
        .addToCard()
        .goToCart();

    collector.checkThat("The product in the cart list is correct", cartPage.getCartItem(0).getTitle().toLowerCase(), containsString(search.toLowerCase()));

    CartListPage delete = cartPage.deleteItem(0);

    collector.checkThat("The cart is empty", delete.emptyTitle(), containsString("Your Shopping Cart is empty."));
    collector.checkThat("The product has been deleted", delete.emptyMessage(), containsString("was removed from Shopping Cart"));

  }
}
