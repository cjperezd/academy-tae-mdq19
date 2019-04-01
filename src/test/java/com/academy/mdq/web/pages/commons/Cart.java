package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends WebPage {

  @FindBy(css = ".a-size-medium.sc-product-title.a-text-bold")
  private WebElement bookTitle;

  @FindBy(css = ".sc-price-sign.a-text-bold")
  private WebElement bookPrice;

  @FindBy(css = ".a-size-small.sc-action-delete")
  private WebElement deleteButton;

  @FindBy(css = ".a-row.sc-cart-header")
  private WebElement empySign;


  public boolean compareResults(String name, String price) {
    return bookTitle.getText().contains(name) && bookPrice.getText().equals(price);
  }

  public Cart deleteItem() {
    click(deleteButton);
    return this;
  }

  public String emptyCart() {
    Waits.isTextPresent(empySign, "Your Shopping Cart is empty");
    return empySign.getText();
  }

}
