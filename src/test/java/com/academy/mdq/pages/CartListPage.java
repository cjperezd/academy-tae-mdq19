package com.academy.mdq.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.commons.CartItem;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.*;

public class CartListPage extends WebPage {

  @FindBy(className = "sc-list-item-content")
  private List<WebElement> cardDivs;

  @FindBy(css = ".sc-cart-header h1")
  private WebElement emptyTitle;

  @FindBy(className = "sc-list-item-removed-msg")
  private WebElement emptyMessage;

  private final List<CartItem> items = new ArrayList<>();

  public CartListPage() {
    cardDivs.stream().forEach(card -> items.add(new CartItem(card)));
  }

  public CartItem getCartItem(int index) {
    Waits.areVisible(cardDivs);
    return items.get(index);
  }

  public CartListPage deleteItem(int index) {
    items.get(index).deleteItem();
    return this;
  }

  public String emptyTitle() {
    return isVisible(emptyTitle).getText();
  }

  public String emptyMessage() {
    return isVisible(emptyMessage).getText();
  }

}
