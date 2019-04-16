package com.academy.mdq.web.pages.home.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchCards extends WebComponent {

  @FindBy(className = "box-grid__item__icon")
  private WebElement 


  protected SearchCards(WebElement container) {
    super(container);
  }
}
