package com.academy.mdq.oKWeb.test;

import com.academy.mdq.oKWeb.pages.oKPage.oKpages.HomePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;


public class OKTest extends BaseTestSuite {
    private int idx = 0;
    private String cardName;
    private String textAnimation = " Busca aquí nuestros productos y servicios";

    @Test
    public void myTest() throws InterruptedException {

        HomePage homePage = new HomePage();
        int size = homePage.getCardsOnList().size();

        checkThat("Text animation matches",homePage.getInputTextAnimation(), containsString(textAnimation));
        homePage.clickCloseCookiesButton();

        for (int i = 0; i < size; i++) {
            cardName = homePage.getCardName(i);
            homePage.clickOnCard(i);
            checkThat("Card Name equals to full card name: ", homePage.getFullCardName(), containsString(cardName));
            homePage.clickCloseFullCard();
        }

        homePage.typeNoExistsProduct();
        homePage.clickOnSearchButton();
        checkThat("No exist description match: ", homePage.getNoExistsDescription(), containsString("No hemos encontrado"));
        homePage.clickOnNoSearchButton();

        homePage.typeExistsProduct().clickOnSearchButton();
        //checkThat("No text Visible: ", homePage.getNoExistsDescription(), CoreMatchers.containsString(""));
        homePage.clickOnNoSearchButton();


        callTear();
    }
}
