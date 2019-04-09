package com.academy.mdq.web.tests.amazon;

import com.academy.mdq.reports.Report;
import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.listeners.AmazonListener;
import com.academy.mdq.web.pages.commons.Cart;
import com.academy.mdq.web.pages.commons.Home;
import com.academy.mdq.web.pages.commons.ResultCard;
import com.academy.mdq.web.pages.commons.SearchResults;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.academy.mdq.reports.Report.finishReport;
import static com.academy.mdq.reports.Report.getTest;
import static org.junit.Assert.assertTrue;

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

  @Rule
  public AmazonListener ss = new AmazonListener();

  @Test
  public void searchWithParametersTest() {

    Report.getNewTest("Amazon Search Test", "Using [category] : " + category + " and [product Name] : " + productName);
    SearchResults searchResult = new Home()
        .searchBy(category, productName);
    ResultCard resultCard = searchResult.getResultCard(0);

    assertTrue("ResultCard contains the title expected", resultCard.getTitle().contains(productName.toLowerCase()));

    getTest().pass("ResultCard contains the title expected");

    Cart cart = searchResult.selectCardTitle(0)
        .addToCart()
        .goToCart();

    assertTrue("ResultCard from Cart contains the title expected", cart.getTitle().contains(productName.toLowerCase()));
    getTest().pass("ResultCard from Cart contains the title expected");

    cart.deleteItem();

    assertTrue("The delete information contains both book name and 'was removed from shopping cart' indication",
        cart.getRemovedInformation().contains(productName.toLowerCase())
            && cart.getRemovedInformation().contains("was removed from shopping cart."));

    getTest().pass("The delete information contains both book name and 'was removed from shopping cart' indication");

    getTest().pass("Deleted");
  }

  @AfterClass
  public static void finish() {
    finishReport();
  }

}
