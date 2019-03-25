package com.academy.mdq.pages.hotel.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchCard extends WebComponent {

  @FindBy(id = "bcol")
  private WebElement ContainerCards;

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

  public WebElement getContainerCards() {
    return ContainerCards;
  }

  public WebElement getCardImage() {
    return cardImage;
  }

  public WebElement getHotelName() {
    return hotelName;
  }

  public WebElement getPhone() {
    return phone;
  }

  public WebElement getStars() {
    return stars;
  }

  public WebElement getRate() {
    return rate;
  }

  public WebElement getActualPrice() {
    return actualPrice;
  }

  public WebElement getCityArea() {
    return cityArea;
  }
}
