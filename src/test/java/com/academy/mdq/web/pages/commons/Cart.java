package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class Cart extends WebPage {

  @FindBy(css = ".a-size-medium.sc-product-title.a-text-bold")
  private WebElement productNameText;

  @FindBy(css = ".sc-price-sign.a-text-bold")
  private WebElement productPrice;

  @FindBy(css = ".a-size-small.sc-action-delete")
  private WebElement deleteButton;

  @FindBy(css = ".sc-list-item-removed-msg.a-padding-medium")
  private WebElement removedInfomationText;

  public String getTitle() {
    return productNameText.getText().toLowerCase();
  }

  public String getPrice() {
    return productPrice.getText().toLowerCase();
  }

  public Cart deleteItem() {
    click(deleteButton);
    return this;
  }

  public String getRemovedInformationText() {
    isVisible(removedInfomationText);
    return removedInfomationText.getText().toLowerCase();
  }

}
