package com.academy.mdq.oKWeb.test;

import com.academy.mdq.oKWeb.pages.oKPage.components.ProductCardContainer;
import com.academy.mdq.oKWeb.pages.oKPage.oKpages.HomePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static com.academy.mdq.oKWeb.pages.oKPage.components.ProductCardContainer.*;
import static org.hamcrest.CoreMatchers.containsString;


public class OKTest extends BaseTestSuite {
    private int idx = 0;
    private String cardName;
    private String textAnimation = " Busca aquí nuestros productos y servicios";

    @Test
    public void myTest() throws InterruptedException {

        HomePage homePage = new HomePage();
        int size = getCardsOnList().size();

        homePage.scrollPage();

        checkThat("Text animation matches", homePage.getProductSearchBar().getInputTextAnimation(), containsString(textAnimation));
        homePage.clickCloseCookiesButton();

        for (int i = 0; i < size; i++) {
            cardName = homePage.getProductCard().getCardName(i);
            homePage.getProductCard().clickOnCard(i);
            checkThat("Card Name equals to full card name: ", homePage.getFullCardName(), containsString(cardName));
            homePage.getProductFullCard().clickCloseFullCard();
        }

        homePage.getProductSearchBar().typeNoExistsProduct().clickOnSearchButton();
        checkThat("No exist description match: ", homePage.getNoExistsDescription(), containsString("No hemos encontrado"));
        homePage.getProductSearchBar().clickOnNoSearchButton();

        homePage.getProductSearchBar().typeExistsProduct().clickOnSearchButton();
        //checkThat("No text Visible: ", homePage.getNoExistsDescription(), CoreMatchers.containsString(""));
        homePage.getProductSearchBar().clickOnNoSearchButton();


        callTear();
    }
}
