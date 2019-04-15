package com.academy.mdq.web.tests.amazon;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.commons.Cart;
import com.academy.mdq.web.pages.commons.Home;
import com.academy.mdq.web.pages.commons.ResultCard;
import com.academy.mdq.web.pages.commons.SearchResults;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Collection;

import static com.academy.mdq.excelutils.ExcelUtils.readExcel;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class SearchTest extends BaseTestSuite {

  private static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\dataFiles\\dataFiles.xlsx";
  private static final String SHEET_NAME = "Sheet1";

  //WITH PARAMETERS
//  @Parameterized.Parameters
//  public static Collection<Object[]> data() {
//    return Arrays.asList(new Object[][]{
//        {"Books", "Embracing the Power of AI"},
//        {"Computers", "ms gp63"},
//        {"Music, CDs & Vinyl", "the beatles"},
//        {"Software", "Dictionary"},
//        {"Video Games", "Looper"}
//    });
//  }

  //WITH PARAMETERS FROM EXCEL
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return asList(readExcel(FILE_PATH, SHEET_NAME));
  }

  @Parameter
  public String category;

  @Parameter(1)
  public String productName;

  @Test
  public void searchWithParametersTest() {
    SearchResults searchResult = new Home()
        .searchBy(category, productName);
    ResultCard resultCard = searchResult.getResultCard(0);

    checkThat("ResultCard contains the title expected", resultCard.getProductNameLink(), containsString(productName.toLowerCase()));

    Cart cart = searchResult.clickProductName(0)
        .addToCart()
        .goToCart();

    checkThat("ResultCard from Cart contains the title expected", cart.getTitle(), containsString(productName.toLowerCase()));

    cart.deleteItem();

    checkThat("The delete information contains product name.",
        cart.getRemovedInformationText(), containsString(productName.toLowerCase()));
    checkThat("The delete information contains the expression 'was removed from shopping cart'",
        cart.getRemovedInformationText(), containsString("was removed from shopping cart."));
  }

}
