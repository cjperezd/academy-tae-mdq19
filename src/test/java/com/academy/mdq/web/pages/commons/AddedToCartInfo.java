package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedToCartInfo extends WebPage {

  @FindBy(id = "navbar")
  private WebElement navBarContainer;

  private final NavigationBar navBar = new NavigationBar(navBarContainer);

  public Cart goToCart() {
    return navBar.clickCartButton();
  }

}
