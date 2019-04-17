package com.academy.mdq.web.pages.home.components.productSearch;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchCard extends WebComponent {

  @FindBy(css = ".box-grid__item__icon img")
  private WebElement cardIcon;

  @FindBy(css = ".box-grid__item__title--product-card h2")
  private WebElement cardTitle;

  public SearchCard(WebElement container) {
    super(container);
  }

  public String getSrcIcon() {
    return cardIcon.getAttribute("src");
  }

  public String getCardTitle() {
    return cardTitle.getText();
  }

  public void clickCardTitle() {
    click(cardTitle);
  }

}
