package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.books.ResultDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResultCard extends WebComponent {

  @FindBy(css = ".a-size-medium.a-color-base.a-text-normal")
  private WebElement productNameLink;

  @FindBy(className = "a-price")
  private WebElement price;

  public ResultCard(WebElement container) {
    super(container);
  }

  public String getProductNameLink() {
    return productNameLink.getText().toLowerCase();
  }

  public String getPrice() {
    String[] price = this.price.getText().split("\n");
    return price[0].concat("." + price[1]);
  }

  public ResultDetails clickProductNameLink() {
    click(productNameLink);
    return new ResultDetails();
  }
}
