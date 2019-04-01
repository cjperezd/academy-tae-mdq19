package com.academy.mdq.pages;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends WebPage {

  @FindBy(id = "add-to-cart-button")
  private WebElement addToCartButton;

  public AddToCartResultPage addToCard() {
    click(addToCartButton);
    return new AddToCartResultPage();
  }

}
