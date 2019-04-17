package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class ProductCard extends WebComponent {

  @FindBy(css = "a.box-grid__item__wrapper")
  private WebElement fullCardLink;

  @FindBy(css = ".box-grid__item__icon img")
  private WebElement iconImg;

  @FindBy(css = ".box-grid__item__title h2")
  private WebElement cardTitle;

  @FindBy(className = "box-grid__item__content__description")
  private WebElement descriptionDiv;

  public ProductCard(WebElement container) {
    super(container);
  }

  public void selectFullCard() {
    click(isVisible(fullCardLink));
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
