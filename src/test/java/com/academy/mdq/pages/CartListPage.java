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

  private final List<CartItem> items = new ArrayList<>();

  public boolean verifyFirstItem(String search) {
    setItems();
    return items.get(0).getTitle().contains(search);
  }

  public CartListPage deleteFirstItem() {
    items.get(0).deleteItem();
    return this;
  }

  public boolean verifyDelete() {
    isVisible(emptyTitle);
    return emptyTitle.getText().contains("Your Shopping Cart is empty.");
  }

  private void setItems() {
    cardDivs.stream().forEach(card -> items.add(new CartItem(card)));
  }

}
