package com.academy.mdq.tests;

import com.academy.mdq.component.*;
import com.academy.mdq.component.commons.MenuBar;
import com.academy.mdq.component.commons.TopBar;
import com.academy.mdq.pages.*;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static com.academy.mdq.component.ProductsMenu.*;
import static com.academy.mdq.component.ProductsMenu.Items.*;
import static org.hamcrest.CoreMatchers.*;

public class OpenBankHomeTest extends BaseTestSuite {

  @Test
  public void searchProductSpanish() {

    String searchBarText = "Busca aquí nuestros productos y servicios";
    String prod2 = "prestamo";
    String prod3 = "lapiz";

    OpenBankHomePage home = new OpenBankHomePage();

    checkThat("SearchBar types: " + searchBarText, home.getSearchBarText().toLowerCase(), containsString(searchBarText.toLowerCase()));

    for (int i=0; i < home.totalCards(); i++) {
      String cardName = home.getProductCard(i).getTitle();
      String cardDesc = home.getProductCard(i).getDescriptionDiv();
      String cardIcon = home.getProductCard(i).getIconSrc();
      ProductExpandedCard expandedCard = home.selectACard(i);
      checkThat("Card title and full card title are the same", expandedCard.getTitle(), containsString(cardName));
      checkThat("Card icon and full card icon are the same", expandedCard.getIconSrc(), containsString(cardIcon));
      if (!cardDesc.equals(""))
        checkThat("Card description and full card description are the same", expandedCard.getDescriptionDiv(), containsString(cardDesc));
    }

    home.typeInSearchBar(prod2);

    checkThat("Search has results", home.checkIfHasResults(), is(true));
    checkThat("Search is not empty", !home.checkIfEmpty(), is(true));

    home.typeInSearchBar(prod3);

    checkThat("Search has results", home.checkIfHasResults(), is(true));
    checkThat("Search is not empty", !home.checkIfEmpty(), is(true));

  }

  @Test
  public void searchProductEnglish() {

    String searchBarText = "Find here our products and services";
    String prod2 = "loan";
    String prod3 = "pencil";
    String language = "english";

    OpenBankHomePage home = new OpenBankHomePage().changeLanguage(language);

    checkThat("SearchBar types: " + searchBarText, home.getSearchBarText().toLowerCase(), containsString(searchBarText.toLowerCase()));

    for(int i=0; i < home.totalCards(); i++) {
      String cardName = home.getProductCard(i).getTitle();
      String cardDesc = home.getProductCard(i).getDescriptionDiv();
      String cardIcon = home.getProductCard(i).getIconSrc();
      ProductExpandedCard expandedCard = home.selectACard(i);
      checkThat("Card title and full card title are the same", expandedCard.getTitle(), containsString(cardName));
      checkThat("Card icon and full card icon are the same", expandedCard.getIconSrc(), containsString(cardIcon));
      if (!cardDesc.equals(""))
        checkThat("Card description and full card description are the same", expandedCard.getDescriptionDiv(), containsString(cardDesc));
    }

    home.typeInSearchBar(prod2);

    checkThat("Search has results", home.checkIfHasResults(), is(true));
    checkThat("Search is not empty", !home.checkIfEmpty(), is(true));

    home.typeInSearchBar(prod3);

    checkThat("Search has results", home.checkIfHasResults(), is(true));
    checkThat("Search is not empty", !home.checkIfEmpty(), is(true));

  }

  @Test
  public void checkTopBar() {

    OpenBankHomePage home = new OpenBankHomePage();
    TopBar topBar = home.getTopBar();
    MenuBar menuBar = home.getMenuBar();

    checkThat("Ayuda Urgente button is visible", topBar.isButtonVisible("Ayuda Urgente"), is(true));
    checkThat("Ayuda Urgente button is enable", topBar.isButtonEnable("Ayuda Urgente"), is(true));
    checkThat("Ayuda Urgente button URL is correct", topBar.getButtonURL("Ayuda Urgente"), containsString("https://www.openbank.es/ayuda-urgente"));

    checkThat("Contáctanos button is visible", topBar.isButtonVisible("Contáctanos"), is(true));
    checkThat("Contáctanos button is enable", topBar.isButtonEnable("Contáctanos"), is(true));
    checkThat("Contáctanos button URL is correct", topBar.getButtonURL("Contáctanos"), containsString("https://www.openbank.es/contacto"));


    checkThat("Preguntas Frecuentes button is visible", topBar.isButtonVisible("Preguntas Frecuentes"), is(true));
    checkThat("Preguntas Frecuentes button is enable", topBar.isButtonEnable("Preguntas Frecuentes"), is(true));
    checkThat("Preguntas Frecuentes button URL is correct", topBar.getButtonURL("Preguntas Frecuentes"), containsString("https://www.openbank.es/ayuda"));

    checkThat("Cajeros button is visible", topBar.isButtonVisible("Cajeros"), is(true));
    checkThat("Cajeros button is enable", topBar.isButtonEnable("Cajeros"), is(true));
    checkThat("Cajeros button URL is correct", topBar.getButtonURL("Cajeros"), containsString("https://www.openbank.es/cajeros-oficinas"));

    checkThat("Language button is visible", topBar.isLanguageButtonVisible(), is(true));
    checkThat("Language button is enable", topBar.isLanguageButtonEnable(), is(true));
    checkThat("Language menu shows correctly", topBar.areLanguagesVisible(), is(true));

//------------------------------------------------------------------------------------------------------------------------------------------------------

    checkThat("Productos button is visible", menuBar.isProductButtonVisible(), is(true));
    checkThat("Productos button is enable", menuBar.isProductButtonEnable(), is(true));
    ProductsMenu productsMenu = menuBar.selectProductsMenu();
    checkThat("Productos menu shows correctly", productsMenu.areItemsVisible() && productsMenu.areItemsEnable(), is(true));

    checkThat("Promociones y descuentos button is visible", menuBar.isPromButtonVisible(), is(true));
    checkThat("Promociones y descuentos button is enable", menuBar.isPromButtonEnable(), is(true));
    checkThat("Promociones y descuentos menu shows correctly", menuBar.isPromContainerVisible(), is(true));

    checkThat("Quiénes somos button is visible", menuBar.isAboutButtonVisible(), is(true));
    checkThat("Quiénes somos button is enable", menuBar.isAboutButtonEnable(), is(true));
    checkThat("Quiénes somos  button URL is correct", menuBar.getAboutButtonURL(), containsString("https://www.openbank.es/quienes-somos"));

    checkThat("Hazte Cliente button is visible", menuBar.isRegisterButtonVisible(), is(true));
    checkThat("Hazte Cliente button is enable", menuBar.isRegisterButtonEnable(), is(true));
    checkThat("Hazte Cliente button URL is correct", menuBar.getRegisterButtonURL(), containsString("https://www.openbank.es/hazte-cliente"));

    checkThat("Área Clientes button is visible", menuBar.isLoginButtonVisible(), is(true));
    checkThat("Área Clientes button is enable", menuBar.isLoginButtonEnable(), is(true));
    Login login = home.selectLogin();
    checkThat("Área Clientes access area shows correctly", login.isAccessButtonVisible() && login.isDocumentInputEnable() && login.isDocumentSelectEnable(), is(true));

  }

  @Test
  public void checkProductsMenu() {

    String[] items = {"Cuentas", "Tarjetas", "Financiación", "Depósitos", "Servicios y Herramientas", "Openbank Wealth"};

    ProductsMenu subMenu = new OpenBankHomePage().getMenuBar().selectProductsMenu();

    for(Items i : Items.values()) {
      NavegationContainer nav = subMenu.selectAnItem(i);
      checkThat("Item '" + items[i.ordinal()] + "' selection was correct", subMenu.getSelectedItem(), equalTo(items[i.ordinal()]));
      checkThat("Item '" + items[i.ordinal()] + "' title matches navegation title", nav.getItemHeader(), equalTo(subMenu.getSelectedItem()));
    }

    HipotecasOpenPage hipotecasOpenPage =  subMenu.selectAnItem(FINANCIACION).selectHipotecasOpen();
    Header header = hipotecasOpenPage.getHeader();
    SmallBanner banner = header.getSmallBanner();

    checkThat("Header is visible", header.isTitleVisible() && header.isImgVisible(), is(true));
    checkThat("Header title is correct", header.getHeaderTitle(), containsString("Hipotecas Open"));
    checkThat("Banner is visible", banner.isTitleVisible() && banner.isButtonEnable(), is(true));

    PrestamosYCreditosPage prestamosYCreditosPage = hipotecasOpenPage
        .getMenuBar()
        .selectProductsMenu()
        .selectAnItem(FINANCIACION)
        .selectPrestamosYCreditos();
    header = prestamosYCreditosPage.getHeader();
    banner = header.getSmallBanner();

    checkThat("Header is visible", header.isTitleVisible() && header.isImgVisible(), is(true));
    checkThat("Header title is correct", header.getHeaderTitle(), containsString("Préstamos y Créditos"));
    checkThat("Banner is visible", banner.isTitleVisible() && banner.isButtonEnable(), is(true));

    ProteccionDeDescubiertoPage proteccionDeDescubiertoPage = prestamosYCreditosPage
        .getMenuBar()
        .selectProductsMenu()
        .selectAnItem(FINANCIACION)
        .selectProteccionDeDescubierto();
    header = proteccionDeDescubiertoPage.getHeader();
    banner = header.getSmallBanner();

    checkThat("Header is visible", header.isTitleVisible() && header.isImgVisible(), is(true));
    checkThat("Header title is correct", header.getHeaderTitle(), containsString("Protección de Descubierto"));
    checkThat("Banner is visible", banner.isTitleVisible() && banner.isButtonEnable(), is(true));

    DepositoPage depositoPage = proteccionDeDescubiertoPage
        .getMenuBar()
        .selectProductsMenu()
        .selectAnItem(DEPOSITOS)
        .selectDeposito();
    header = depositoPage.getHeader();
    banner = header.getSmallBanner();
    RiskSidebar riskSidebar = depositoPage.getRiskSidebar();

    checkThat("Header is visible", header.isTitleVisible() && header.isImgVisible(), is(true));
    checkThat("Header title is correct", header.getHeaderTitle(), containsString("Depósito Open 13 meses"));
    checkThat("Banner is visible", banner.isTitleVisible() && banner.isButtonEnable(), is(true));
    checkThat("Risk section is visible", riskSidebar.isTextVisible(), is(true));

  }

}
