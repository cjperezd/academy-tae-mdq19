package com.academy.mdq.web.scripts.ok.home;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.commons.ToolBarComponents.TopBar;
import com.academy.mdq.web.pages.home.Home;
import com.academy.mdq.web.pages.home.components.ProductSearchComponent;
import com.academy.mdq.web.pages.home.components.productSearch.ExpandedSearchCard;
import com.academy.mdq.web.pages.home.components.productSearch.SearchBar;
import com.academy.mdq.web.pages.home.components.productSearch.SearchCard;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class ProductSearchTest extends BaseTestSuite {

  private static final String INPUT_TEXT_ES = "Busca aquí nuestros productos y servicios";
  private static final String INPUT_TEXT_EN = "Find here our products and services";

  @Test
  public void productSearchTestES() {
    ProductSearchComponent productSearchComponent = new Home().getProductSearchComponent();
    SearchBar searchBar = productSearchComponent.getSearchBar();

    checkThat("The AutoText is equals to the one expected.", searchBar.getAutoTextFromSearchInput(),
        equalTo(INPUT_TEXT_ES));

    for (SearchCard card : productSearchComponent.getCards()) {
      String title = card.getCardTitle();
      String icon = card.getSrcIcon();
      ExpandedSearchCard expandedSearchCard = productSearchComponent.clickSearchCard(card);
      checkThat("The search card title is equals to the full card title shown.", title, equalTo(expandedSearchCard.getCardTitle()));
      checkThat("The search card icon is equals to the full card icon shown.", icon, equalTo(expandedSearchCard.getSrcIcon()));
      expandedSearchCard.clickCloseButton();
    }

    searchBar.typeProduct("tarjeta")
        .clickSearchButton();

    checkThat("The product searched exists", productSearchComponent.areResults(),
        equalTo(true));
    checkThat("The empty result section is not display", productSearchComponent.areResultsEmpty(),
        equalTo(false));

    searchBar.clickCloseButton()
        .typeProduct("tarjetasssss")
        .clickSearchButton();

    checkThat("The product searched does not exists", productSearchComponent.areResults(),
        equalTo(false));
    checkThat("The empty result section is display", productSearchComponent.areResultsEmpty(),
        equalTo(true));

    searchBar.clickCloseButton();
  }

  @Test
  public void productSearchTestEN() {
    TopBar esTopBar = new Home().getTopBar();
    ProductSearchComponent productSearchComponent = esTopBar.clickLanguageButton().clickENLanguageButton().getProductSearchComponent();
    SearchBar searchBar = productSearchComponent.getSearchBar();

    checkThat("The AutoText is equals to the one expected.", searchBar.getAutoTextFromSearchInput(),
        equalTo(INPUT_TEXT_EN));

    for (SearchCard card : productSearchComponent.getCards()) {
      String title = card.getCardTitle();
      String icon = card.getSrcIcon();
      ExpandedSearchCard expandedSearchCard = productSearchComponent.clickSearchCard(card);
      checkThat("The search card title is equals to the full card title shown.", title, equalTo(expandedSearchCard.getCardTitle()));
      checkThat("The search card icon is equals to the full card icon shown.", icon, equalTo(expandedSearchCard.getSrcIcon()));
      expandedSearchCard.clickCloseButton();
    }

    searchBar.typeProduct("card")
        .clickSearchButton();

    checkThat("The product searched exists", productSearchComponent.areResults(),
        equalTo(true));
    checkThat("The empty result section is not display", productSearchComponent.areResultsEmpty(),
        equalTo(false));

    searchBar.clickCloseButton()
        .typeProduct("cardsssss")
        .clickSearchButton();

    checkThat("The product searched does not exists", productSearchComponent.areResults(),
        equalTo(false));
    checkThat("The empty result section is display", productSearchComponent.areResultsEmpty(),
        equalTo(true));

    searchBar.clickCloseButton();
  }

}
