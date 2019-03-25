package com.academy.mdq.pages.hotel.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;

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

  @FindBy(css = ".neighborhood.secondary")
  private WebElement cityArea;

  public HotelSearchCard(WebElement container) {
    super(container);
  }

  public boolean isCardVisible() {
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
    String arr;
    return arr = hotelName.getText();
  }

}
