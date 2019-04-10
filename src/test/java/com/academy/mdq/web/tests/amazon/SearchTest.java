package com.academy.mdq.web.tests.amazon;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.listeners.AmazonRuler;
import com.academy.mdq.web.pages.commons.Cart;
import com.academy.mdq.web.pages.commons.Home;
import com.academy.mdq.web.pages.commons.ResultCard;
import com.academy.mdq.web.pages.commons.SearchResults;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.academy.mdq.reports.Report.finishReport;
import static com.academy.mdq.reports.Report.getNewTest;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class SearchTest extends BaseTestSuite {

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"Books", "Embracing the Power of AI"},
        {"Computers", "ms gp63"},
        {"Music, CDs & Vinyl", "the beatles"},
        {"Software", "Ditionary"},
        {"Video Games", "Looper"}
    });
  }

  @Parameter
  public String category;

  @Parameter(1)
  public String productName;

  //@Rule
  //public AmazonListener ss = new AmazonListener();

  @Rule
  public AmazonRuler ru = new AmazonRuler();

  @Before
  public void createTestReport() {
    getNewTest("Amazon Search Test", "Using [category] : " + category + " and [product Name] : " + productName);
  }

  @Test
  public void searchWithParametersTest() {
    SearchResults searchResult = new Home()
        .searchBy(category, productName);
    ResultCard resultCard = searchResult.getResultCard(0);

    ru.checkThat("ResultCard contains the title expected", resultCard.getTitle(), containsString(productName.toLowerCase()));

    Cart cart = searchResult.selectCardTitle(0)
        .addToCart()
        .goToCart();

    ru.checkThat("ResultCard from Cart contains the title expected", cart.getTitle(), containsString(productName.toLowerCase()));

    cart.deleteItem();

    ru.checkThat("The delete information contains product name.",
        cart.getRemovedInformation(), containsString(productName.toLowerCase()));
    ru.checkThat("The delete information contains the expression 'was removed from shopping cart' ",
        cart.getRemovedInformation(), containsString("was removed from shopping cart."));
  }

  @AfterClass
  public static void finish() {
    finishReport();
  }

}
