package com.academy.mdq.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.commons.Header;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartResultPage extends WebPage {

  @FindBy(id = "navbar")
  private WebElement navegationBar;

  private final Header navBar = new Header(navegationBar);

  public CartListPage goToCart() {
    navBar.selectCart();
    return new CartListPage();
  }

}
