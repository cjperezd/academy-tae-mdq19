package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.common.components.PopUpClass;
import com.academy.mdq.pages.hotel.components.HotelSearchCard;
import com.academy.mdq.pages.hotel.components.HotelSearchFilters;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchResult extends WebPage {

  @FindBy(id = "searchForm")
  private WebElement searchSecondPage;

  @FindBy(className = "flex-link-wrap ")
  private WebElement card;

  @FindBy(className = "modal-body")
  private WebElement popUpComp;

  private final HotelSearchFilters hotelSearchFilters = new HotelSearchFilters(searchSecondPage);
  private final HotelSearchCard hotelSearchCard = new HotelSearchCard(card);
  private final PopUpClass popUpClass = new PopUpClass(popUpComp);

  public HotelSearchResult writeHotelName(String hotelName) {
    type(hotelSearchFilters.getInputHotelName(), hotelName);
    return this;
  }

  public HotelSearchResult clickHotelSearchButton() {
    click(hotelSearchFilters.getHotelNameButton());
    return new HotelSearchResult();
  }

  public String getTotalResults() {
    return hotelSearchFilters.getHotelResultTitle().getText().split(" ")[2];
  }

  public String getAllWords() {
    String arr;
    return arr = hotelSearchFilters.getHotelResultTitle().getText();
  }

  public HotelSearchResult clickOnFirstOptionFae() {
    click(hotelSearchFilters.getClickFirstOptionFae());
    return new HotelSearchResult();
  }

  public boolean isCardVisible() {
    Waits.isVisible(hotelSearchCard.getCardImage());
    return hotelSearchCard.getCardImage().isDisplayed();
  }

  public boolean cardHotelName() {
    //Waits.isVisible(hotelSearchCard.getHotelName());
    return hotelSearchCard.getHotelName().isDisplayed();
  }

  public boolean cardCityName() {
    //Waits.isVisible(hotelSearchCard.getCityArea());
    return hotelSearchCard.getCityArea().isDisplayed();
  }

  public boolean cardPhone() {
    //Waits.isVisible(hotelSearchCard.getPhone());
    return hotelSearchCard.getPhone().isDisplayed();
  }

  public boolean cardStars() {
    //Waits.isVisible(hotelSearchCard.getStars());
    return hotelSearchCard.getStars().isDisplayed();
  }

  public boolean cardRate() {
    //Waits.isVisible(hotelSearchCard.getRate());
    return hotelSearchCard.getRate().isDisplayed();
  }

  public boolean cardNightlyClass() {
    //Waits.isVisible(hotelSearchCard.getActualPrice());
    return hotelSearchCard.getActualPrice().isDisplayed();
  }


  public String getHotelTitle() {
    String arr;
    return arr = hotelSearchCard.getHotelName().getText();
  }

     /*public void clickClosePopUp() {
        click(hotelSearchFilters.getInputHotelName());
    }*/

}
