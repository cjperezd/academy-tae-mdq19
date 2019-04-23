package com.academy.mdq.web.pages.promotionsanddiscounts.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscountCard extends WebComponent {

  @FindBy(className = "title")
  private WebElement title;

  @FindBy(className = "description")
  private WebElement description;

  @FindBy(className = "button")
  private WebElement button;

  public DiscountCard(WebElement container) {
    super(container);
  }

  public boolean isVisibleTitle() {
    return title.isDisplayed();
  }

  public boolean isVisibleDescription() {
    return description.isDisplayed();
  }

  public boolean isVisibleButton() {
    return button.isDisplayed();
  }
}
