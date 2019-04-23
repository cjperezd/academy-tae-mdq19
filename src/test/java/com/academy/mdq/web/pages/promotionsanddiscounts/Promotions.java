package com.academy.mdq.web.pages.promotionsanddiscounts;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.promotionsanddiscounts.components.PreviewPromotionCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Promotions extends WebPage {

  @FindBy(className = "promotion-grid__item")
  private List<WebElement> promotionsCardsContainers;

  private final List<PreviewPromotionCard> promotionsCards = new ArrayList<>();

  public Promotions() {
    promotionsCardsContainers.forEach(container -> promotionsCards.add(new PreviewPromotionCard(container)));
  }

  public List<PreviewPromotionCard> getPromotionCards() {
    return promotionsCards;
  }


}
