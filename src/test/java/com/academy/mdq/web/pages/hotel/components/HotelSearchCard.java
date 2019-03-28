package com.academy.mdq.web.pages.hotel.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.hotel.HotelDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchCard extends WebComponent {

  @FindBy(className = "hotel-thumbnail")
  private WebElement cardImage;

  @FindBy(css = ".hotelName.fakeLink")
  private WebElement hotelName;

  @FindBy(className = "no-wrap")
  private WebElement phone;

  @FindBy(css = ".starRating.secondary")
  private WebElement stars;

  @FindBy(className = "reviewOverall")
  private WebElement rate;

  @FindBy(className = "hotel-price")
  private WebElement actualPrice;

  @FindBy (css = ".neighborhood.secondary")
  private WebElement cityArea;

  @FindBy (id = "modalInterstitial")
  private WebElement updatingSearch;

  @FindBy (css = ".flex-link[data-track]")
  private WebElement hotelLink;

  @FindBy(id = "bcol")
  private WebElement wrapAll;

  public HotelSearchCard(WebElement container) {
    super(container);
  }


  public boolean isImageVisible() {
    return cardImage.isDisplayed();
  }

  public boolean cardHotelName() {
    return hotelName.isDisplayed();
  }

  public boolean cardCityName() {
    return cityArea.isDisplayed();
  }

  public boolean cardPhone() {
    return phone.isDisplayed();
  }

  public boolean cardStars() {
    return stars.isDisplayed();
  }

  public boolean cardRate() {
    return rate.isDisplayed();
  }

  public boolean cardNightlyClass() {
    return actualPrice.isDisplayed();
  }

  public String getHotelTitle() {
    return hotelName.getText();
  }

  public String getCityName(){
    return cityArea.getText();
  }

  public HotelDetails selectHotel() {
    click(hotelLink);
    return new HotelDetails();
  }
}
