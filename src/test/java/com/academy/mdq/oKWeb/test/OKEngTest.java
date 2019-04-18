package com.academy.mdq.oKWeb.test;

import com.academy.mdq.oKWeb.pages.oKPage.components.ProductCardContainer;
import com.academy.mdq.oKWeb.pages.oKPage.oKpages.HomePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static com.academy.mdq.oKWeb.pages.oKPage.components.ProductCardContainer.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OKEngTest extends BaseTestSuite {

    private int idx = 0;
    private String cardName;
    private String textAnimation = " Find here our products and services";

    @Test
    public void myTest() {

        HomePage homePage = new HomePage();
        homePage.getTopBar().clickLanguageSelector().clickLanguage();
        int size =  homePage.getProductCardContainer().getCardsOnList().size();

        homePage.scrollPage();

        checkThat("Text animation matches",homePage.getProductSearchBar().getInputTextAnimation(), containsString(textAnimation));



        for (int i = 0; i < size; i++) {
            cardName = homePage.getProductCard().getCardName(i);
            homePage.getProductCard().clickOnCard(i);
            checkThat("Card Name equals to full card name: ", homePage.getFullCardName(), containsString(cardName));
            homePage.getProductFullCard().clickCloseFullCard();
        }


        homePage.getProductSearchBar().typeNoExistsProductEN().clickOnSearchButton();
        checkThat("No exist description match: ", homePage.getNoExistsDescription(), containsString("We haven't found"));
        homePage.getProductSearchBar().clickOnNoSearchButton();

        homePage.getProductSearchBar().typeExistsProductEN();
        homePage.getProductSearchBar().clickOnSearchButton();
        checkThat("No text Visible: ", getCardsOnList().get(0), notNullValue());
        homePage.getProductSearchBar().clickOnNoSearchButton();

        callTear();
    }
}
