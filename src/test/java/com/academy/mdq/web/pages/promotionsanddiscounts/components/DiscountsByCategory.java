package com.academy.mdq.web.pages.promotionsanddiscounts.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@FindBy(className = "discount__category")
public class DiscountsByCategory extends WebComponent {

  @FindBy(className = "discount__category__title")
  private WebElement discountTitle;

  @FindBy(className = "equal-height-child")
  private List<WebElement> discountCardsContainers;

  private final List<DiscountCard> discountCards = new ArrayList<>();

  public DiscountsByCategory(WebElement container) {
    super(container);
    discountCardsContainers.forEach(cont->discountCards.add(new DiscountCard(cont)));
  }

  public String getTitle(){
    return discountTitle.getText();
  }

  public boolean isVisibleTitle(){
    return discountTitle.isDisplayed();
  }

  public List<DiscountCard> getDiscountCards (){
    return discountCards;
  }
}
