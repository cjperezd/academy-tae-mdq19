package com.academy.mdq.tests;

import com.academy.mdq.pages.AmazonHomePage;
import com.academy.mdq.pages.CartListPage;
import com.academy.mdq.pages.SearchResultPage;
import com.academy.mdq.pages.commons.ResultCard;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static com.academy.mdq.JSONFiles.ReadJSONFile.readFile;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AmazonCartTest extends BaseTestSuite {

  @Parameters
  public static Collection<Object[]> data() {
    String[] keys = {"search", "filter", "price"};
    return readFile("src/test/resources/amazon.json", keys);
  }

  private String search;
  private String filter;
  private String price;

  public AmazonCartTest(String search, String filter, String price) {
    this.search = search;
    this.filter = filter;
    this.price = price;
  }

  @Test
  public void saveInCart() {

    SearchResultPage resultPage = new AmazonHomePage()
        .setFilter(filter)
        .search(search);

    ResultCard firstCard = resultPage.getResultCard(0);

    checkThat("The name of the product is correct", firstCard.getTitle().toLowerCase(), containsString(search.toLowerCase()));
    checkThat("The price of the product is correct", firstCard.getOriginalPrice(), containsString(price));

    CartListPage cartPage = resultPage
        .selectCard(0)
        .addToCard()
        .goToCart();

    checkThat("The product in the cart list is correct", cartPage.getCartItem(0).getTitle().toLowerCase(), containsString(search.toLowerCase()));

    CartListPage delete = cartPage.deleteItem(0);

    checkThat("The cart is empty", delete.emptyTitle(), containsString("Your Shopping Cart is empty."));
    checkThat("The product has been deleted", delete.emptyMessage(), containsString("was removed from Shopping Cart"));

  }
}
