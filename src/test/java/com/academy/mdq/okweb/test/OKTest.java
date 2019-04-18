package com.academy.mdq.okweb.test;

import com.academy.mdq.okweb.pages.okpage.okpages.HomePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static com.academy.mdq.okweb.pages.okpage.components.ProductCardContainer.getCardsOnList;
import static org.hamcrest.CoreMatchers.*;


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

        //TEST 2


        for (int i = 0; i < homePage.getTopBar().getWebElementsSize(); i++) {
            checkThat("Buttons appear: ", homePage.getTopBar().getText(i), notNullValue());
        }

        checkThat("Login button correct name: ", homePage.getSectionsBar().isCorrectLoginName(), is(true));
        checkThat("Register button correct name: ", homePage.getSectionsBar().isCorrectRegisterName(), is(true));

        for (int i = 0; i < homePage.getSectionsBar().getOptionsSize(); i++) {
            checkThat("Sections button exists: ", homePage.getSectionsBar().getSectionsTexts(i), notNullValue());
            checkThat("Are displayed sections buttons: ", homePage.getSectionsBar().areButtonsDisplayed(i), is(true));
        }

        checkThat("Login/Register buttons displayed", homePage.getSectionsBar().areAccountBottonsDisplayed(), is(true));

        checkThat("The url is the correct one: ", homePage.getSectionsBar().isWhoWeAreAttributeRight(), is(true));

        for (int i = 0; i < homePage.getSectionsBar().navigationMenuListSize(); i++) {
            checkThat("The menu content is displayed: ", homePage.getSectionsBar().isContentDisplayed(i), is(true));
        }

        checkThat("Is register attribute right: ", homePage.getSectionsBar().isRegisterAttributeRight(), is(true));
        homePage.clickLogin();
        checkThat("Login content is displayed correctly: ", homePage.getLogin().isBackgroundVisible(), is(true));

        checkThat("TopBar elements url's are correct: ", homePage.getTopBar().areTopbarElementsCorrect(), is(true));


        //TEST 3

        for (int i = 0; i < homePage.getSectionsBar().getMenuContents().getSubmenuListSize(); i++) {

        }


        callTear();
    }
}
