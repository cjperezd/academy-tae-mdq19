package com.academy.mdq.webFinal.test;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.webFinal.pages.amazon.AmazonHomePage;
import com.academy.mdq.webFinal.pages.amazon.AmazonResultPage;
import com.academy.mdq.webFinal.pages.amazon.CartPage;
import com.academy.mdq.extentReports.errorCollector.CheckError;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class AmazonTest extends BaseTestSuite {
    private static String cartAssert = "Your Shopping Cart is empty.";


    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Embracing the Power of AI", "Books"},
                {"Notebook", "Computers"},
                {"Optical Illusion 3D Glow LED", "Home & Kitchen"},
                {"Slide It In", "Music, CDs & Vinyl"},
                {"Arduino", "Industrial & Scientific"}
        });
    }

    @Parameter
    public String productName;

    @Parameter(1)
    public String categoryInput;

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public CheckError checkError = new CheckError();


    @Test
    public void myTest() throws IOException, InterruptedException {
        //Extent extentReport = new Extent();

        AmazonResultPage amazonResultPage = new AmazonHomePage().getSearchBar().selectCategory(categoryInput).typeBookText(productName).search();
        String searchedBookName = amazonResultPage.getFirstCard().getBookName();

        checkError.checkThat("Product name matches expected value", searchedBookName, containsString(productName));


        amazonResultPage.getFirstCard().selectBook().addToCart().cartButton();
        CartPage cartPage = new CartPage().clickOnDelete();

        Thread.sleep(5000);
        String cartInformation = cartPage.getCartInformation();

        checkError.checkThat("Cart is empty", cartInformation, containsString(cartAssert));

        checkError.callTear();

    }

}
