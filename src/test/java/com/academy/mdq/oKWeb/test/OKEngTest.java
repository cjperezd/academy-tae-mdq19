package com.academy.mdq.oKWeb.test;

import com.academy.mdq.oKWeb.pages.oKPage.oKpages.HomePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OKEngTest extends BaseTestSuite {

    private int idx = 0;
    private String cardName;
    private String textAnimation = " Find here our products and services";

    @Test
    public void myTest() {

        HomePage homePage = new HomePage().clickLanguageSelector().clickLanguage();
        int size = homePage.getCardsOnList().size();

        checkThat("Text animation matches",homePage.getInputTextAnimation(), containsString(textAnimation));


        for (int i = 0; i < size; i++) {
            cardName = homePage.getCardName(i);
            homePage.clickOnCard(i);
            checkThat("Card Name equals to full card name: ", homePage.getFullCardName(), containsString(cardName));
            homePage.clickCloseFullCard();
        }


        homePage.typeNoExistsProductEN();
        homePage.clickOnSearchButton();
        checkThat("No exist description match: ", homePage.getNoExistsDescription(), CoreMatchers.containsString("We haven't found"));
        homePage.clickOnNoSearchButton();

        homePage.typeExistsProductEN().clickOnSearchButton();
        checkThat("No text Visible: ", homePage.getCardsOnList().get(0), notNullValue());
        homePage.clickOnNoSearchButton();


        callTear();
    }
}
