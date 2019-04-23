package com.academy.mdq.tests;

import com.academy.mdq.component.*;
import com.academy.mdq.component.commons.FooterTop;
import com.academy.mdq.component.commons.MenuBar;
import com.academy.mdq.component.commons.TopBar;
import com.academy.mdq.driver.Drivers;
import com.academy.mdq.pages.*;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static com.academy.mdq.component.ProductsMenu.Items;
import static com.academy.mdq.component.ProductsMenu.Items.DEPOSITOS;
import static com.academy.mdq.component.ProductsMenu.Items.FINANCIACION;
import static com.academy.mdq.pages.DescuentosOpenPage.Categories.MODA;
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
  public void verifyTopBar() {

    OpenBankHomePage home = new OpenBankHomePage();
    TopBar topBar = home.getTopBar();
    MenuBar menuBar = home.getMenuBar();

    checkThat("Ayuda Urgente button is visible", topBar.isAyudaUrgenteButtonVisible(), is(true));
    checkThat("Ayuda Urgente button is enable", topBar.isAyudaUrgenteButtonEnable(), is(true));
    checkThat("Ayuda Urgente button URL is correct", topBar.getAyudaUrgenteURL(), containsString("https://www.openbank.es/ayuda-urgente"));

    checkThat("Contáctanos button is visible", topBar.isContactanosButtonVisible(), is(true));
    checkThat("Contáctanos button is enable", topBar.isCajerosButtonEnable(), is(true));
    checkThat("Contáctanos button URL is correct", topBar.getContactanosURL(), containsString("https://www.openbank.es/contacto"));


    checkThat("Preguntas Frecuentes button is visible", topBar.isPreguntasFrecuentesButtonVisible(), is(true));
    checkThat("Preguntas Frecuentes button is enable", topBar.isPreguntasFrecuentesButtonEnable(), is(true));
    checkThat("Preguntas Frecuentes button URL is correct", topBar.getPreguntasFrecuentesURL(), containsString("https://www.openbank.es/ayuda"));

    checkThat("Cajeros button is visible", topBar.isCajerosButtonVisible(), is(true));
    checkThat("Cajeros button is enable", topBar.isCajerosButtonEnable(), is(true));
    checkThat("Cajeros button URL is correct", topBar.getCajerosURL(), containsString("https://www.openbank.es/cajeros-oficinas"));

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
  public void verifyProductsMenu() {

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

  @Test
  public void verifyPromotions() {

    String[] links = {"promocion-amazon-alexa-echo-dot-0419",
        "promo-casa-del-libro",
        "gana-100-euros-gestion-discrecional",
        "descuentos-estaciones-servicio-galp-cataluna",
        "sorteo-samsung-galaxy-watch",
        "aplazar-compras-pagos-5",
        "ahorrar-dinero-consigue-premios",
        "invertir-bolsa",
        "sorteo-tarjetas-500-euros-carburante",
        "promocion-nomina-cumplenomina"
    };

    PromocionesPage promocionesPage = new OpenBankHomePage().getMenuBar().selectPromociones();

    for (int i = 0; i < promocionesPage.totalOfCards(); i++) {
      PromotionCard card = promocionesPage.getCard(i);
      checkThat("Promotion card number " + i + " background image is visible", card.isImgPictureVisible(), is(true));
      checkThat("Promotion card number " + i + " title is visible", card.isTitleDivVisible(), is(true));
      checkThat("Promotion card number " + i + " description is visible", card.isDescriptionDivVisible(), is(true));
      checkThat("Promotion card number " + i + " button is enable", card.isCtaDivEnable(), is(true));
      checkThat("The link of the cards is correct", card.getLink(), containsString(links[i]));
    }

    for (int i=0; i < promocionesPage.totalOfCards(); i++) {
      PromoPage promoPage = promocionesPage.getCard(i).select();

      Header header = promoPage.getHeader();
      SmallBanner banner = header.getSmallBanner();
      checkThat("Header is visible", header.isTitleVisible() && header.isImgVisible(), is(true));
      checkThat("Banner is visible", banner.isTitleVisible() && banner.isButtonEnable(), is(true));

      Drivers.getDriver().getWebDriver().navigate().back();
      promocionesPage = new PromocionesPage();
    }

  }

  @Test
  public void verifyDiscounts() {

    DescuentosOpenPage descuentosOpenPage = new OpenBankHomePage().getMenuBar().selectDescuentosOpen();

    checkThat("All categories are visible", descuentosOpenPage.areCategoriesVisible(), is(true));

    descuentosOpenPage.selectCategory(MODA);

    checkThat("Title of category " + MODA + " is visible", descuentosOpenPage.isTitleVisible(MODA), is(true));

    for (int i=0; i<descuentosOpenPage.totalOfCards(); i++) {
      DiscountCard card = descuentosOpenPage.getDiscountCard(i);
      checkThat("Card number " + (i+1) + " title is visible", card.isTitleDivVisible(), is(true));
      checkThat("Card number " + (i+1) + " description is visible", card.isDescriptionDivVisible(), is(true));
      checkThat("Card number " + (i+1) + " button is visible", card.isCtaButtonVisible(), is(true));
    }

  }

  @Test
  public void verifyPrensa() {

    FooterTop footerTop = new OpenBankHomePage().getFooterTop();

    checkThat("Footer is visible", footerTop.areAllOptionsVisible(), is(true));

    PrensaPage prensaPage = footerTop.selectPrensa();

    for (int i=0; i<prensaPage.totalOfNews(); i++) {
      NewSection newSection = prensaPage.getNewSection(i);
      checkThat("Section number " + (i+1) + " img is visible", newSection.isImgVisible(), is(true));
      checkThat("Section number " + (i+1) + " date is visible", newSection.isDateVisible(), is(true));
      checkThat("Section number " + (i+1) + " title is visible", newSection.isTitleVisible(), is(true));
      checkThat("Section number " + (i+1) + " description is visible", newSection.isDescriptionVisible(), is(true));
    }
  }

  @Test
  public void verifyAyudaUrgente() {

    TopBar topBar = new OpenBankHomePage().getTopBar();

    checkThat("Ayuda Urgente button is visible", topBar.isAyudaUrgenteIconVisible(), is(true));
    checkThat("Ayuda Urgente icon is correct", topBar.isAyudaUrgenteButtonEnable(), equalTo("icon-ayuda-urgente"));

    AyudaUrgentePage ayudaUrgentePage = topBar.selectAyudaUrgente();

    for (int i=0; i < ayudaUrgentePage.totalOfCards(); i++) {
      HelpCard helpCard = ayudaUrgentePage.getHelpCard(i);
      checkThat("Card number " + (i+1) + " icon is visible", helpCard.isIconVisible(), is(true));
      checkThat("Card number " + (i+1) + " icon is correct", helpCard.getIconImg(), equalTo("/assets/2017-05/Tarjetas.svg"));
      checkThat("Card number " + (i+1) + " title is visible", helpCard.isTitleVisible(), is(true));
      checkThat("Card number " + (i+1) + " description is visible", helpCard.isTextVisible(), is(true));
    }

  }

}
