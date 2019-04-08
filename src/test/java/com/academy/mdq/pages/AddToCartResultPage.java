package com.academy.mdq.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.commons.Header;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartResultPage extends WebPage {

  @FindBy(id = "navbar")
  private WebElement navegationBar;

  private final Header navBar = new Header(navegationBar);

  public CartListPage goToCart() {
    return navBar.selectCart();
  }

}
