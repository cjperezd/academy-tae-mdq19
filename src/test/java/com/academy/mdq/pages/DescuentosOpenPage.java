package com.academy.mdq.pages;

import com.academy.mdq.component.DiscountCard;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.isClickable;
import static com.academy.mdq.waits.Waits.isVisible;

public class DescuentosOpenPage extends WebPage {

  @FindBy(className = "category")
  private List<WebElement> categoriesLi;

  @FindBy(className = "discount__category__title")
  private List<WebElement> catTitlesDiv;

  @FindBy(className = "card")
  private List<WebElement> cardsDiv;

  private final List<DiscountCard> discountCards = new ArrayList<>();

  public DescuentosOpenPage() {
    cardsDiv.forEach(card -> discountCards.add(new DiscountCard(card)));
  }

  public DescuentosOpenPage selectCategory(Categories cat) {
    if (cat.ordinal() < categoriesLi.size())
      click(categoriesLi.get(cat.ordinal()));
    return this;
  }

  public boolean areCategoriesVisible() {
    return categoriesLi.stream().allMatch(c -> isVisible(c).isDisplayed());
  }

  public boolean isTitleVisible(Categories cat) {
    return isClickable(catTitlesDiv.get(cat.ordinal())).isDisplayed();
  }

  public DiscountCard getDiscountCard(int index) {
    if (index < discountCards.size())
      return discountCards.get(index);
    else
      return null;
  }

  public int totalOfCards() {
    return discountCards.size();
  }

  public enum Categories {
    RESTAURANTES,
    MODA,
    HOTELES_Y_VIAJES,
    OCIO,
    TRANSPORTE,
    BELLEZA_Y_SALUD
  }

}
