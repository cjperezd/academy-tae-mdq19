package com.academy.mdq.okweb.test;

import com.academy.mdq.okweb.pages.okpage.okpages.*;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static com.academy.mdq.okweb.pages.okpage.components.ProductCardContainer.getCardsOnList;
import static org.hamcrest.CoreMatchers.is;


public class OKTest extends BaseTestSuite {
    private int idx = 0;
    private String cardName;
    private String textAnimation = " Busca aquí nuestros productos y servicios";

    @Test
    public void myTest() throws InterruptedException {

        HomePage homePage = new HomePage();
        int size = getCardsOnList().size();
        String urlOpenSolidario = "https://www.openbank.es/open-solidario";
        String urlDepositOpen = "https://www.openbank.es/deposito-plazo-fijo-13-meses";
        String urlHipotecasOpen = "https://www.openbank.es/hipoteca-open";
        String urlPrestamosyCreditos = "https://www.openbank.es/comparador-prestamos-creditos";

        homePage.scrollPage();

//        checkThat("Text animation matches", homePage.getProductSearchBar().getInputTextAnimation(), containsString(textAnimation));
//        homePage.clickCloseCookiesButton();
//
//        for (int i = 0; i < size; i++) {
//            cardName = homePage.getProductCard().getCardName(i);
//            homePage.getProductCard().clickOnCard(i);
//            checkThat("Card Name equals to full card name: ", homePage.getFullCardName(), containsString(cardName));
//            homePage.getProductFullCard().clickCloseFullCard();
//        }
//
//        homePage.getProductSearchBar().typeNoExistsProduct().clickOnSearchButton();
//        checkThat("No exist description match: ", homePage.getNoExistsDescription(), containsString("No hemos encontrado"));
//        homePage.getProductSearchBar().clickOnNoSearchButton();
//
//        homePage.getProductSearchBar().typeExistsProduct().clickOnSearchButton();
//        homePage.getProductSearchBar().clickOnNoSearchButton();
//
//        //TEST 2
//
//
//        for (int i = 0; i < homePage.getTopBar().getWebElementsSize(); i++) {
//            checkThat("Buttons appear: ", homePage.getTopBar().getText(i), notNullValue());
//        }
//
//        checkThat("Login button correct name: ", homePage.getSectionsBar().isCorrectLoginName(), is(true));
//        checkThat("Register button correct name: ", homePage.getSectionsBar().isCorrectRegisterName(), is(true));
//
//        for (int i = 0; i < homePage.getSectionsBar().getOptionsSize(); i++) {
//            checkThat("Sections button exists: ", homePage.getSectionsBar().getSectionsTexts(i), notNullValue());
//            checkThat("Are displayed sections buttons: ", homePage.getSectionsBar().areButtonsDisplayed(i), is(true));
//        }
//
//        checkThat("Login/Register buttons displayed", homePage.getSectionsBar().areAccountBottonsDisplayed(), is(true));
//
//        checkThat("The url is the correct one: ", homePage.getSectionsBar().isWhoWeAreAttributeRight(), is(true));
//
//        for (int i = 0; i < homePage.getSectionsBar().navigationMenuListSize(); i++) {
//            checkThat("The menu content is displayed: ", homePage.getSectionsBar().isContentDisplayed(i), is(true));
//        }
//
//        checkThat("Is register attribute right: ", homePage.getSectionsBar().isRegisterAttributeRight(), is(true));
//        homePage.clickLogin();
//        checkThat("Login content is displayed correctly: ", homePage.getLogin().isBackgroundVisible(), is(true));
//
//        checkThat("TopBar elements url's are correct: ", homePage.getTopBar().areTopbarElementsCorrect(), is(true));


        //TEST 3

        homePage.getSectionsBar().clickOnProducts();
//
//        for (int i = 0; i < homePage.getNavigationMenuContents().getNavigationMenuLeftContentsForSize().getSectionsSize(); i++) {
//
//            homePage.getNavigationMenuContents().getNavigationMenuLeftContents(i).clickSection(i);
//            checkThat("Are the texts Equals: ", homePage.getNavigationMenuContents().areTheSameTexts(i), is(true));
//        }
//


        homePage.getNavigationMenuContents().getNavigationMenuLeftContents(4).clickSection(4);
        checkThat("is the url right: ",homePage.getNavigationMenuContents().getNavigationMenuRightContents().isopenSolidarioUrlRight(urlOpenSolidario),is(true));

        OpenSolidarioPage openSolidarioPage = homePage.getNavigationMenuContents().getNavigationMenuRightContents().clickOpenSolidario();
        checkThat("are banners visible: ", openSolidarioPage.areBannersVisible(),is(true));
        checkThat("is mini banner button visible: ", openSolidarioPage.isMinibannerButtonVisible(1),is(true));




        openSolidarioPage.getHomePage().getSectionsBar().clickOnProducts();

        openSolidarioPage.getHomePage().getNavigationMenuContents().getNavigationMenuLeftContents(3).clickSection(3);
        checkThat("is url right: ", openSolidarioPage.getHomePage().getNavigationMenuContents().getNavigationMenuRightContents().isDepositOpenUrlRight(urlDepositOpen),is(true));

        DepositOpenPage depositOpenPage = openSolidarioPage.getHomePage().getNavigationMenuContents().getNavigationMenuRightContents().clickDepositOpenSection();
        checkThat("Are banners visible: ", depositOpenPage.areBannersVisible(),is(true));
        checkThat("is mini banner button visible: ", depositOpenPage.isMinibannerButtonVisible(0),is(true));
        checkThat("Is risk container visible: ", depositOpenPage.isRiskContainerVisible(),is(true));





        depositOpenPage.getHomePage().getSectionsBar().clickOnProducts();

        depositOpenPage.getHomePage().getNavigationMenuContents().getNavigationMenuLeftContents(2).clickSection(2);
        checkThat("is url right: ", depositOpenPage.getHomePage().getNavigationMenuContents().getNavigationMenuRightContents().isHipotecaOpenUrlRight(urlHipotecasOpen),is(true));

        HipotecaOpenPage hipotecaOpenPage = depositOpenPage.getHomePage().getNavigationMenuContents().getNavigationMenuRightContents().clickHipotecasOpenSection();
        checkThat("Are banners visible: ", hipotecaOpenPage.areBannersVisible(),is(true));
        checkThat("is mini banner button visible: ", hipotecaOpenPage.isMinibannerButtonVisible(1),is(true));





        hipotecaOpenPage.getHomePage().getSectionsBar().clickOnProducts();

        hipotecaOpenPage.getHomePage().getNavigationMenuContents().getNavigationMenuLeftContents(2).clickSection(2);
        checkThat("is url right: ", hipotecaOpenPage.getHomePage().getNavigationMenuContents().getNavigationMenuRightContents().isPrestamosyCreditosUrlRight(urlPrestamosyCreditos),is(true));

        PrestamosyCreditosPage prestamosyCreditosPage = hipotecaOpenPage.getHomePage().getNavigationMenuContents().getNavigationMenuRightContents().clickPrestamosyCreditosSection();
        checkThat("Are banners visible: ", prestamosyCreditosPage.areBannersVisible(),is(true));
        checkThat("is mini banner button visible: ", prestamosyCreditosPage.isMinibannerButtonVisible(0),is(true));


        //TEST 4

        PromotionAndDiscountsPage promotionAndDiscountsPage = homePage.getSectionsBar().clickOnPromotionsAndDiscounts().clickPromotionAndDiscounts();
        System.out.println("TITLE: " +promotionAndDiscountsPage.getTitleFirstCard());

        //TODO: Continuar con esto, devuelve bien el titulo de la primer card


        callTear();
    }
}
