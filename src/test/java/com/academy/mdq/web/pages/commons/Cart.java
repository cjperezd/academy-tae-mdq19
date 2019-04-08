package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class Cart extends WebPage {

  @FindBy(css = ".a-size-medium.sc-product-title.a-text-bold")
  private WebElement bookTitle;

  @FindBy(css = ".sc-price-sign.a-text-bold")
  private WebElement bookPrice;

  @FindBy(css = ".a-size-small.sc-action-delete")
  private WebElement deleteButton;

  @FindBy(css = ".sc-list-item-removed-msg.a-padding-medium")
  private WebElement removedInfomation;

  public String getTitle() {
    return bookTitle.getText().toLowerCase();
  }

  public String getPrice() {
    return bookPrice.getText().toLowerCase();
  }

  public Cart deleteItem() {
    click(deleteButton);
    return this;
  }

  public String getRemovedInformation() {
    isVisible(removedInfomation);
    return removedInfomation.getText().toLowerCase();
  }

}
