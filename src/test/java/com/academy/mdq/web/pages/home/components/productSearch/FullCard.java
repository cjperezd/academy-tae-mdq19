package com.academy.mdq.web.pages.home.components.productSearch;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FullCard extends WebComponent {

  @FindBy(css = ".box-grid__item__image img")
  private WebElement cardImage;

  @FindBy(css = ".box-grid__item__icon img")
  private WebElement cardIcon;

  @FindBy(className = "box-grid__item__category")
  private WebElement cardCategory;

  @FindBy(css = "#product-search-fullcard .box-grid__item__title h2")
  private WebElement cardTitle;

  @FindBy(className = "box-grid__item__content__description")
  private WebElement cardDescription;

  @FindBy(className = "box-grid__item__content__advantages__header__title")
  private List<WebElement> cardAdvantages;

  @FindBy(className = "close-icon")
  private WebElement closeButton;

  public FullCard(WebElement container) {
    super(container);
  }

  public String getSrcIcon() {
    return cardIcon.getAttribute("src");
  }

  public String getCardTitle() {
    return cardTitle.getText();
  }

  public FullCard clickCloseButton() {
    click(closeButton);
    return this;
  }
}
