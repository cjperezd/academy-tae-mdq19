package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFullCard extends WebComponent {

  @FindBy(className = "box-grid__item__image")
  private WebElement photoImg;

  @FindBy(css = ".box-grid__item--expanded .box-grid__item__icon img")
  private WebElement iconImg;

  @FindBy(css = ".box-grid__item--expanded .box-grid__item__title h2")
  private WebElement cardTitle;

  @FindBy(css = ".box-grid__item--expanded .box-grid__item__content__description")
  private WebElement descriptionDiv;

  public ProductFullCard(WebElement container) {
    super(container);
  }

  public String getCardTitle() {
    return cardTitle.getText();
  }

  public String getDescriptionDiv() {
    return descriptionDiv.getText();
  }

  public String getIconSrc() {
    return iconImg.getAttribute("src");
  }
}
