package com.academy.mdq.okweb.test;

import com.academy.mdq.okweb.pages.okpage.okpages.HomePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static com.academy.mdq.okweb.pages.okpage.components.ProductCardContainer.getCardsOnList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;

public class OKEngTest extends BaseTestSuite {

    private int idx = 0;
    private String cardName;
    private String textAnimation = " Find here our products and services";

    @Test
    public void myTest() {

        HomePage homePage = new HomePage();
        homePage.getTopBar().clickLanguageSelector().clickLanguage();
        int size = homePage.getProductCardContainer().getCardsOnList().size();

        homePage.scrollPage();

        checkThat("Text animation matches", homePage.getProductSearchBar().getInputTextAnimation(), containsString(textAnimation));


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

        for (int i = 0; i < homePage.getTopBar().getWebElementsSize(); i++) {
            checkThat("Buttons appear: ", homePage.getTopBar().getText(i), notNullValue());
        }

        checkThat("Login button correct name: ", homePage.getSectionsBar().isCorrectLoginName(), is(true));
        checkThat("Register button correct name: ", homePage.getSectionsBar().isCorrectRegisterName(), is(true));

        for (int i=0; i< homePage.getSectionsBar().getOptionsSize();i++){
            checkThat("Sections button exists: ", homePage.getSectionsBar().getSectionsTexts(i), notNullValue());
            checkThat("Are displayed sections buttons: ", homePage.getSectionsBar().areButtonsDisplayed(i),is(true));
        }

        checkThat("Login/Register buttons displayed",homePage.getSectionsBar().areAccountBottonsDisplayed(),is(true));




        callTear();
    }
}
