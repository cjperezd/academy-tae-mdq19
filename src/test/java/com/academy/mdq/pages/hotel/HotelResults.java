package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.complements.ResultCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.academy.mdq.waits.Waits.*;

public class HotelResults extends WebPage {

  @FindBy(id = "inpHotelNameMirror")
  private WebElement propertyInput;

  @FindBy(id = "aria-option-0")
  private WebElement firstOption;

  @FindBy(id = "hotelNameGoBtn")
  private WebElement goButton;

  @FindBy(css = "div[class = 'modal-body']")
  private WebElement popUpDiv;

  @FindBy(id = "modalCloseButton")
  private WebElement popUpButton;

  @FindBy(css = "div .flex-link-wrap")
  private List<WebElement> cardsDiv;

  @FindBy(className = "neighborhoodTextLabel")
  private List<WebElement> neighborhoods;

  @FindBy(css = "#neighborhoodContainer .toggleFilters span:nth-of-type(3)")
  private WebElement showMoreSpan;

  @FindBy(id = "modalInterstitial")
  private WebElement waitingDiv;

  public boolean verifyCards() {
    closePopUp();
    List<ResultCard> resultCards = new ArrayList<>();
    click(isClickable(showMoreSpan));
    List<String> neighborhood = neighborhoods.stream().map(WebElement::getText).collect(Collectors.toList());
    cardsDiv.stream().forEach(element -> resultCards.add(new ResultCard(element)));
    return resultCards.stream().allMatch(card -> neighborhood.contains(card.getAreaLi()));
  }

  private HotelResults closePopUp() {
    if (isVisible(popUpDiv).isDisplayed()) {
      click(popUpButton);
    }
    return this;
  }

  public HotelResults searchProperty(String property) {
    type(propertyInput, property);
    click(firstOption);
    return this;
  }

  public PropertyResults selectGo() {
    click(goButton);
    waitForInvisibility(waitingDiv);
    return new PropertyResults();
  }

}
