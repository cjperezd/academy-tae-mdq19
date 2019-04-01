package com.academy.mdq.web.pages.books;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.commons.AddedToCartInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultDetails extends WebPage {

  @FindBy(id = "add-to-cart-button")
  private WebElement addToCartButton;


  public AddedToCartInfo addToCart() {
    click(addToCartButton);
    return new AddedToCartInfo();
  }
}
