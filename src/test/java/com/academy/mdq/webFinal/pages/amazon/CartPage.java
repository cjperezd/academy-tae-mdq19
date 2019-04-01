package com.academy.mdq.webFinal.pages.amazon;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends WebPage {

  @FindBy(css = ".a-size-small.sc-action-delete")
  private WebElement deleteButton;

  @FindBy(className = "sc-list-item-content")
  private List<WebElement> shoppingCardItems;


  public CartPage clickOnDelete() {
    click(deleteButton);
    return this;
  }


}
