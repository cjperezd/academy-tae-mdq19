package com.academy.mdq.web.tests.amazon;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.Listeners.ScreenShotOnFailed;
import com.academy.mdq.web.pages.commons.Cart;
import com.academy.mdq.web.pages.commons.Home;
import com.academy.mdq.web.pages.commons.ResultCard;
import com.academy.mdq.web.pages.commons.SearchResults;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

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
  public ScreenShotOnFailed ss = new ScreenShotOnFailed();

  @Test
  public void searchWithParametersTest() {
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    ExtentReports extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    ExtentTest test = extent.createTest("Amazon Search Test", "Search with parameters test");


    SearchResults searchResult = new Home()
        .searchBy(category, productName);

    ResultCard resultCard = searchResult.getResultCard(0);

    assertTrue("ResultCard contains the name expected", resultCard.getTitle().contains(productName.toLowerCase()));

    Cart cart = searchResult.selectCardTitle(0)
        .addToCart()
        .goToCart();

    assertTrue("ResultCard from Cart contains the title expected", cart.getTitle().contains(productName.toLowerCase()));

    cart.deleteItem();

    assertTrue("The delete information contains both book name and 'was removed from shopping cart' indication",
        cart.getRemovedInformation().contains(productName.toLowerCase())
            && cart.getRemovedInformation().contains("was removed from shopping cart."));

    htmlReporter.flush();
  }

}
