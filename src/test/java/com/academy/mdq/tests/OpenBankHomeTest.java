package com.academy.mdq.tests;

import com.academy.mdq.pages.OpenBankHomePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class OpenBankHomeTest extends BaseTestSuite {

  @Test
  public void searchProductSpanish() {

    String searchBarText = "Busca aquí nuestros productos y servicios";
    String prod2 = "prestamo";
    String prod3 = "lapiz";

    OpenBankHomePage home = new OpenBankHomePage();

    checkThat("SearchBar types: " + searchBarText, searchBarText.toLowerCase(), containsString(home.getSearchBarText().toLowerCase()));

    for (int i=0; i < home.totalCards(); i++) {
      String cardName = home.getProductCard(i).getCardTitle();
      String cardDesc = home.getProductCard(i).getDescriptionDiv();
      String cardIcon = home.getProductCard(i).getIconSrc();
      home.selectACard(i);
      checkThat("Card title and full card title are the same", cardName, containsString(home.getFullCardTitle()));
      checkThat("Card icon and full card icon are the same", cardIcon, containsString(home.getFullCardIconSrc()));
      if (!cardDesc.equals(""))
        checkThat("Card description and full card description are the same", cardDesc, containsString(home.getFullCardDescription()));
    }

    home.typeInSearchBar(prod2);

    checkThat("Search has results", true, equalTo(home.checkIfHasResults()));
    checkThat("Search is not empty", true, equalTo(!home.checkIfEmpty()));

    home.typeInSearchBar(prod3);

    checkThat("Search is empty", true, equalTo(home.checkIfEmpty()));
    checkThat("Search has no results", true, equalTo(!home.checkIfHasResults()));

  }

  @Test
  public void searchProductEnglish() {

    String searchBarText = "Find here our products and services";
    String prod2 = "loan";
    String prod3 = "pencil";
    String language = "english";

    OpenBankHomePage home = new OpenBankHomePage().changeLanguage(language);

    checkThat("SearchBar types: " + searchBarText, searchBarText.toLowerCase(), containsString(home.getSearchBarText().toLowerCase()));

    for(int i=0; i < home.totalCards(); i++) {
      String cardName = home.getProductCard(i).getCardTitle();
      String cardDesc = home.getProductCard(i).getDescriptionDiv();
      String cardIcon = home.getProductCard(i).getIconSrc();
      home.selectACard(i);
      checkThat("Card title and full card title are the same", cardName, containsString(home.getFullCardTitle()));
      checkThat("Card icon and full card icon are the same", cardIcon, containsString(home.getFullCardIconSrc()));
      if (!cardDesc.equals(""))
        checkThat("Card description and full card description are the same", cardDesc, containsString(home.getFullCardDescription()));
    }

    home.typeInSearchBar(prod2);

    checkThat("Search has results", true, equalTo(home.checkIfHasResults()));
    checkThat("Search is not empty", true, equalTo(!home.checkIfEmpty()));

    home.typeInSearchBar(prod3);

    checkThat("Search is empty", true, equalTo(home.checkIfEmpty()));
    checkThat("Search has no results", true, equalTo(!home.checkIfHasResults()));

  }

  @Test
  public void checkTopBar() {

    OpenBankHomePage home = new OpenBankHomePage();

    checkThat("Ayuda Urgente button exists", true, equalTo(home.topButtonMatch("Ayuda Urgente")));
    checkThat("Ayuda Urgente button is enable", true, equalTo(home.isTopButtonEnable("Ayuda Urgente")));
    checkThat("Ayuda Urgente button is clickable", true, equalTo(home.isTopButtonClickable("Ayuda Urgente")));

    checkThat("Contáctanos button exists", true, equalTo(home.topButtonMatch("Contáctanos")));
    checkThat("Contáctanos button is enable", true, equalTo(home.isTopButtonEnable("Contáctanos")));
    checkThat("Contáctanos button is clickable", true, equalTo(home.isTopButtonClickable("Contáctanos")));

    checkThat("Preguntas Frecuentes button exists", true, equalTo(home.topButtonMatch("Preguntas Frecuentes")));
    checkThat("Preguntas Frecuentes button is enable", true, equalTo(home.isTopButtonEnable("Preguntas Frecuentes")));
    checkThat("Preguntas Frecuentes button is clickable", true, equalTo(home.isTopButtonClickable("Preguntas Frecuentes")));

    checkThat("Cajeros button exists", true, equalTo(home.topButtonMatch("Cajeros")));
    checkThat("Cajeros button is enable", true, equalTo(home.isTopButtonEnable("Cajeros")));
    checkThat("Cajeros button is clickable", true, equalTo(home.isTopButtonClickable("Cajeros")));

    checkThat("Idioma Español button is enable", true, equalTo(home.isTopButtonEnable("change language es")));
    checkThat("Idioma Español button is enable", true, equalTo(home.isTopButtonEnable("change language es")));
    checkThat("Idioma English button is clickable", true, equalTo(home.isTopButtonClickable("change language en")));
    checkThat("Idioma English button is clickable", true, equalTo(home.isTopButtonClickable("change language en")));

  }

}
