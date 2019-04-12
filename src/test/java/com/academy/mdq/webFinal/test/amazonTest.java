package com.academy.mdq.webFinal.test;

import com.academy.mdq.extentReports.EmailReport;
import com.academy.mdq.extentReports.errorCollector.CheckError;
import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.webFinal.pages.amazon.AmazonHomePage;
import com.academy.mdq.webFinal.pages.amazon.AmazonResultPage;
import com.academy.mdq.webFinal.pages.amazon.CartPage;
import com.academy.mdq.webFinal.pages.amazon.readWrite.YamlReader;
import com.academy.mdq.webFinal.pages.amazon.readWrite.YamlWriter;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class AmazonTest extends BaseTestSuite {
    private static String cartAssert = "Your Shopping Cart is empty.";
    private static String productsPath = "C:/Users/juan.poli/Desktop/Yaml/products.yaml";
    YamlWriter yamlWriter = new YamlWriter();
    static YamlReader yamlReader = new YamlReader();
    //EmailReport emailReport = new EmailReport();


//    @Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][]{
//
//                {"Embracing the Power of AI", "Books"},
//                {"Notebook", "Computers"},
//                {"Optical Illusioon 3D Glow LED", "Home & Kitchen"},
//                {"Slide It In", "Music, CDs & Vinyl"},
//                {"Arduino", "Industrial & Scientific"}
//        });
//    }

    @Before
    public void createSearch() {
        yamlWriter.create(productsPath, "Embracing the Power of AI", "Books");
        yamlWriter.create(productsPath, "Notebook", "Computers");
        yamlWriter.create(productsPath, "Optical Illusion 3D Glow LED", "Home & Kitchen");
        yamlWriter.create(productsPath, "Slide It In", "Music, CDs & Vinyl");
        yamlWriter.create(productsPath, "Arduino", "Industrial & Scientific");
    }

    @Parameters
    public static Collection<Object[]> data() {
        return yamlReader.getList(productsPath);
    }

    @Parameter
    public String productName;

    @Parameter(1)
    public String categoryInput;

    @Rule
    public CheckError checkError = new CheckError();

    @Test
    public void myTest() throws InterruptedException {

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

    @AfterClass
    public static void sendEmails(){
        EmailReport emailReport = new EmailReport();
        emailReport.sendEmail();
    }


}
