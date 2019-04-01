package com.academy.mdq.web.pages.books.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.books.ResultDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookResultCard extends WebComponent {

  @FindBy(css = ".a-size-medium.a-color-base.a-text-normal")
  private WebElement bookTitle;

  @FindBy(className = "a-price")
  private WebElement bookPrice;

  public BookResultCard(WebElement container) {
    super(container);
  }

  public String getBookTitle() {
    return bookTitle.getText();
  }

  public String getBookPrice() {
    String[] price = bookPrice.getText().split("\n");

    return price[0].concat("." + price[1]);
  }

  public ResultDetails selectTitle() {
    click(bookTitle);
    return new ResultDetails();
  }
}
