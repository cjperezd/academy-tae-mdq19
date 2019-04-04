package com.academy.mdq.web.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.complements.ResultCard;
import com.academy.mdq.waits.Waits;
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

  private final List<ResultCard> resultCards = new ArrayList<>();

  public boolean verifyCards() {
    closePopUp();
    click(isClickable(showMoreSpan));
    List<String> neighborhood = neighborhoods.stream().map(WebElement::getText).collect(Collectors.toList());
    transformCards();
    return resultCards.stream().allMatch(card -> neighborhood.contains(card.getAreaLi()));
  }

  public HotelResults searchProperty(String property) {
//    closePopUp();
    type(propertyInput, property);
    click(firstOption);
    return this;
  }

  public PropertyResultsPage selectGo() {
    click(goButton);
    waitForInvisibility(waitingDiv);
    return new PropertyResultsPage();
  }

  public HotelToReservePage selectCard(int card) {
    Waits.areVisible(cardsDiv);
    transformCards();
    if (card < resultCards.size())
      resultCards.get(card).selectCard();
    return new HotelToReservePage();
  }

  private HotelResults closePopUp() {
    if (isVisible(popUpDiv).isDisplayed()) {
      click(popUpButton);
    }
    return this;
  }

  private void transformCards() {
    cardsDiv.stream().forEach(element -> resultCards.add(new ResultCard(element)));
  }

}
