package Complements;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultSidebar extends WebPage {

  @FindBy(id = "modalInterstitial")
  private WebElement waitingDiv;

  @FindBy(css = "div[class = 'modal-body']")
  private WebElement popUpDiv;

  @FindBy(id = "modalCloseButton")
  private WebElement popUpButton;

  @FindBy(css = "[class='section-header-main']")
  private WebElement resultsHeader;

  @FindBy(id = "inpHotelNameMirror")
  private WebElement propertyInput;

  @FindBy(id = "aria-option-0")
  private WebElement firstOption;

  @FindBy(id="hotelNameGoBtn")
  private WebElement goButton;

  @FindBy(id = "resultsContainer")
  private WebElement cardDiv;

  @FindBy(className = "hotel-thumbnail")
  private WebElement imgDiv;

  @FindBy(css = "h4[data-automation='hotel-name']")
  private WebElement hotelLi;

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

  public WebElement getWaitingDiv() {
    return waitingDiv;
  }

  public WebElement getPopUpDiv() {
    return popUpDiv;
  }

  public WebElement getPopUpButton() {
    return popUpButton;
  }

  public WebElement getResultsHeader() {
    return resultsHeader;
  }

  public WebElement getPropertyInput() {
    return propertyInput;
  }

  public WebElement getFirstOption() {
    return firstOption;
  }

  public WebElement getGoButton() {
    return goButton;
  }

  public WebElement getCardDiv() {
    return cardDiv;
  }

  public WebElement getImgDiv() {
    return imgDiv;
  }

  public WebElement getHotelLi() {
    return hotelLi;
  }

  public WebElement getAreaLi() {
    return areaLi;
  }

  public WebElement getPhoneLi() {
    return phoneLi;
  }

  public WebElement getStarLi() {
    return starLi;
  }

  public WebElement getReviewLi() {
    return reviewLi;
  }

  public WebElement getPriceSpan() {
    return priceSpan;
  }
}
