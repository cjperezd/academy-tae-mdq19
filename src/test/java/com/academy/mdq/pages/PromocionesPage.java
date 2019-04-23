package com.academy.mdq.pages;

import com.academy.mdq.component.PromotionCard;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.areVisible;

public class PromocionesPage extends WebPage {

  @FindBy(className = "promotion-grid__item")
  private List<WebElement> cardsDiv;

  private final List<PromotionCard> promotionCards = new ArrayList<>();

  public PromocionesPage() {
    areVisible(cardsDiv);
    cardsDiv.forEach(card -> promotionCards.add(new PromotionCard(card)));
  }

  public int totalOfCards() {
    return promotionCards.size();
  }

  public PromotionCard getCard(int index) {
    if (index < promotionCards.size()) {
      return promotionCards.get(index);
    }
    else
      return null;
  }



}
