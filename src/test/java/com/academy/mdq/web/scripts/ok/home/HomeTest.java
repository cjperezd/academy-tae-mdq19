package com.academy.mdq.web.scripts.ok.home;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.home.Home;
import com.academy.mdq.web.pages.home.components.productSearch.FullCard;
import com.academy.mdq.web.pages.home.components.productSearch.SearchBar;
import com.academy.mdq.web.pages.home.components.productSearch.SearchCard;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


public class HomeTest extends BaseTestSuite {

  @Test
  public void productSearchTestES() {
    Home home = new Home();
    SearchBar searchBar = home.getSearchBar();

    checkThat("The AutoText is equals to the one expected.", searchBar.getAutoTextFromSearchInput(),
        equalTo("Busca aquí nuestros productos y servicios"));

    List<SearchCard> previewCards = home.getProductResultsComponent().getCards();

    for (SearchCard card : previewCards) {
      String title = card.getCardTitle();
      String icon = card.getSrcIcon();
      card.clickCardTitle();
      FullCard fullCard = home.getFullCard();
      checkThat("The search card title is equals to the full card title shown.", title, equalTo(fullCard.getCardTitle()));
      checkThat("The search card icon is equals to the full card icon shown.", icon, equalTo(fullCard.getSrcIcon()));
      home.getFullCard().clickCloseButton();
    }

    searchBar.typeProduct("tarjeta")
        .clickSearchButton();

    checkThat("The product searched exists", home.areResults(),
        equalTo(true));
    checkThat("The empty result section is not display", home.areResultsEmpty(),
        equalTo(false));

    searchBar.clickCloseButton()
        .typeProduct("tarjetasssss")
        .clickSearchButton();

    checkThat("The product searched does not exists", home.areResults(),
        equalTo(false));
    checkThat("The empty result section is display", home.areResultsEmpty(),
        equalTo(true));

    searchBar.clickCloseButton();
  }

//  @Test
//  public void productSearchTestEN() {
//    Home homeES = new Home();
//    TopBar topBar = homeES.getTopBar();
//    topBar.clickLanguageButton().clickENLanguegeButton();
//    Home homeEN = new Home();
//
//    SearchBar searchBar = homeEN.getSearchBar();
//
//    checkThat("The AutoText is equals to the one expected.", searchBar.getAutoTextFromSearchInput(),
//        equalTo("Busca aquí nuestros productos y servicios"));
//
//    List<SearchCard> previewCards = homeEN.getProductResultsComponent().getCards();
//
//    for (SearchCard card : previewCards) {
//      String title = card.getCardTitle();
//      String icon = card.getSrcIcon();
//      card.clickCardTitle();
//      FullCard fullCard = homeEN.getFullCard();
//      checkThat("The search card title is equals to the full card title shown.", title, equalTo(fullCard.getCardTitle()));
//      checkThat("The search card icon is equals to the full card icon shown.", icon, equalTo(fullCard.getSrcIcon()));
//      homeEN.getFullCard().clickCloseButton();
//    }
//
//    searchBar.typeProduct("tarjeta")
//        .clickSearchButton();
//
//    checkThat("The product searched exists", homeEN.areResults(),
//        equalTo(true));
//    checkThat("The empty result section is not display", homeEN.areResultsEmpty(),
//        equalTo(false));
//
//    searchBar.clickCloseButton()
//        .typeProduct("tarjetasssss")
//        .clickSearchButton();
//
//    checkThat("The product searched does not exists", homeEN.areResults(),
//        equalTo(false));
//    checkThat("The empty result section is display", homeEN.areResultsEmpty(),
//        equalTo(true));
//
//    searchBar.clickCloseButton();
//  }

}
