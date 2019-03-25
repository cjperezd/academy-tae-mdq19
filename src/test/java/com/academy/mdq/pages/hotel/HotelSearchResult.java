package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.hotel.components.HotelSearchCard;
import com.academy.mdq.pages.hotel.components.HotelSearchFilters;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HotelSearchResult extends WebPage {


  @FindBy(id = "bcol")
  private WebElement wrapAll;

  @FindBy(className = "flex-link-wrap ")
  private List<WebElement> cardsContainer;

  @FindBy(className = "flex-link-wrap ")
  private WebElement cardsForConstructor;


  @FindBy(id = "searchForm")
  private WebElement searchSecondPage;

  @FindBy(className = "modal-body")
  private WebElement popUpComp;


  private final HotelSearchFilters hotelSearchFilters = new HotelSearchFilters(searchSecondPage);
  private final HotelSearchCard hotelSearchCard = new HotelSearchCard(cardsForConstructor);


  private List<HotelSearchCard> listOfCards = new ArrayList<>();


  public List<HotelSearchCard> initializer() {
    cardsContainer.forEach(card -> listOfCards.add(new HotelSearchCard(card)));
    return listOfCards;
  }

  public HotelSearchFilters typeHotelName(String hotelName) {
    return hotelSearchFilters.typeHotelName(hotelName);
  }

  public HotelSearch clickHotelSearchButton() {
    return hotelSearchFilters.clickHotelSearchButton();
  }

  public String getTotalResults() {
    return hotelSearchFilters.getTotalResults();
  }

  public String getAllWords() {
    return hotelSearchFilters.getAllWords();
  }

  public HotelSearch clickOnFirstOptionFae() {
    return hotelSearchFilters.clickOnFirstOptionFae();
  }

  public boolean isCardVisible() {
    isVisibleCard();
    return hotelSearchCard.isCardVisible();
  }

  public boolean cardHotelName() {
    return hotelSearchCard.cardHotelName();
  }

  public boolean cardCityName() {
    return hotelSearchCard.cardCityName();
  }

  public boolean cardPhone() {
    return hotelSearchCard.cardPhone();
  }

  public boolean cardStars() {
    return hotelSearchCard.cardStars();
  }

  public boolean cardRate() {
    return hotelSearchCard.cardRate();
  }

  public boolean cardNightlyClass() {
    return hotelSearchCard.cardNightlyClass();
  }


  public String getHotelTitle() {
    isVisibleCard();
    return hotelSearchCard.getHotelTitle();
  }

  private void isVisibleCard(){
    Waits.isVisible(wrapAll);
  }
}
