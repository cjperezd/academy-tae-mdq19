package com.academy.mdq.tests;

import com.academy.mdq.component.ProductExpandedCard;
import com.academy.mdq.pages.OpenBankHomePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.hamcrest.CoreMatchers;
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

    checkThat("SearchBar types: " + searchBarText, searchBarText, CoreMatchers.containsString(home.getSearchBarText()));

    for (int i=0; i < home.totalCards(); i++) {
      String cardName = home.getProductCard(i).getTitle();
      String cardDesc = home.getProductCard(i).getDescriptionDiv();
      String cardIcon = home.getProductCard(i).getIconSrc();
      ProductExpandedCard expandedCard = home.selectACard(i);
      checkThat("Card title and full card title are the same", cardName, containsString(expandedCard.getTitle()));
      checkThat("Card icon and full card icon are the same", cardIcon, containsString(expandedCard.getIconSrc()));
      if (!cardDesc.equals(""))
        checkThat("Card description and full card description are the same", cardDesc, containsString(expandedCard.getDescriptionDiv()));
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
      String cardName = home.getProductCard(i).getTitle();
      String cardDesc = home.getProductCard(i).getDescriptionDiv();
      String cardIcon = home.getProductCard(i).getIconSrc();
      ProductExpandedCard expandedCard = home.selectACard(i);
      checkThat("Card title and full card title are the same", cardName, containsString(expandedCard.getTitle()));
      checkThat("Card icon and full card icon are the same", cardIcon, containsString(expandedCard.getIconSrc()));
      if (!cardDesc.equals(""))
        checkThat("Card description and full card description are the same", cardDesc, containsString(expandedCard.getDescriptionDiv()));
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

  }

}
