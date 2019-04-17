package com.academy.mdq.web.pages.home.components.productSearch;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductResultsComponent extends WebComponent {

  @FindBy(className = "box-grid__result__card")
  private List<WebElement> productCardsContainers;

  private final List<SearchCard> cards = new ArrayList<>();

  public ProductResultsComponent(WebElement container) {
    super(container);
    productCardsContainers.forEach(cont -> cards.add(new SearchCard(cont)));
  }

  public List<SearchCard> getCards() {
    return cards;
  }

}
