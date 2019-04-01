package com.academy.mdq.webFinal.pages.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.webFinal.pages.amazon.AmazonPageBook;
import com.academy.mdq.webFinal.pages.amazon.AmazonResultPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookCard extends WebComponent {

  public BookCard(WebElement container) {
    super(container);
  }

  @FindBy(className = "s-image")
  private WebElement bookImage;

  @FindBy(className = "s-line-clamp-2")
  private WebElement bookName;

  @FindBy(css = "a-offscreen")
  private WebElement bookPrice;


  public AmazonResultPage click() {
    click(bookName);
    return new AmazonResultPage();
  }

  public AmazonPageBook selectBook() {
    click(bookImage);
    return new AmazonPageBook();
  }

  public String getBookName() {
    return getText(bookName);
  }


}
