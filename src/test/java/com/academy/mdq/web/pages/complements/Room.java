package com.academy.mdq.web.pages.complements;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Room extends WebComponent {

  @FindBy(css = ".rate-plan-first .book-button-wrapper")
  private WebElement reserveButton;

  public Room(WebElement container) {
    super(container);
  }

  public void reserveRoom() {
    click(reserveButton);
  }

}
