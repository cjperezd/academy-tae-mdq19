package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartItem extends WebComponent {

  @FindBy(className = "sc-product-title")
  private WebElement itemTitle;

  @FindBy(css = "input[value='Delete']")
  private WebElement deleteButton;

  public CartItem(WebElement container) {
    super(container);
  }

  public String getTitle() {
    return itemTitle.getText();
  }

  public void deleteItem() {
    click(deleteButton);
  }

}
