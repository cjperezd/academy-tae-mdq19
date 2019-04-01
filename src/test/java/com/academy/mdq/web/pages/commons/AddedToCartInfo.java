package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedToCartInfo extends WebPage {
  @FindBy(id = "hlb-view-cart-announce")
  private WebElement cart;

  @FindBy(id = "nav-search")
  private WebElement navBarContainer;

  private NavigationBar navBar = new NavigationBar(navBarContainer);

  public Cart goToCart() {
    click(cart);
    return new Cart();
    //return navBar.clickCartButton();
  }

}
