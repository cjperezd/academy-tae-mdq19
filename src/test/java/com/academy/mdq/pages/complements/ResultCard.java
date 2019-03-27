package com.academy.mdq.pages.complements;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isClickable;
import static com.academy.mdq.waits.Waits.isVisible;

public class ResultCard extends WebComponent {

  @FindBy(className = "hotel-thumbnail")
  private WebElement imgDiv;

  @FindBy(className = "hotelTitle")
  private WebElement titleLi;

  @FindBy(css = ".flex-link[data-track]")
  private WebElement hotelLink;

  @FindBy(className = "neighborhood")
  private WebElement areaLi;

  @FindBy(className = "phone")
  private WebElement phoneLi;

  @FindBy(className = "starRating")
  private WebElement starLi;

  @FindBy(className = "reviewOverall")
  private WebElement reviewLi;

  @FindBy(className = "actualPrice")
  private WebElement priceSpan;

  public ResultCard(WebElement container) {
    super(container);
  }

  public boolean isImgDivVisible() {
    return isVisible(imgDiv).isDisplayed();
  }

  public boolean isHotelLiEqual(String property) {
    return titleLi.getText().equals(property);
  }

  public boolean isHotelLiEnable() {
    return titleLi.isEnabled();
  }

  public void selectCard() {
    click(isClickable(hotelLink));
  }

  public String getAreaLi() {
    return areaLi.getText().toLowerCase();
  }

  public boolean isAreaLiVisible() {
    return isVisible(areaLi).isDisplayed();
  }

  public boolean isPhoneLiVisible() {
    return isVisible(phoneLi).isDisplayed();
  }

  public boolean isStarLiVisible() {
    return isVisible(starLi).isDisplayed();
  }

  public boolean isReviewLiVisible() {
    return isVisible(reviewLi).isDisplayed();
  }

  public boolean isPriceSpanVisible() {
    return isVisible(priceSpan).isDisplayed();
  }
}
