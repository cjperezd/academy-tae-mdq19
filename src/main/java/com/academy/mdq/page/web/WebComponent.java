package com.academy.mdq.page.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class WebComponent extends WebOperations {

  private WebElement container;

  protected WebComponent(WebElement container) {
    this.container = container;
    initElements(new DefaultElementLocatorFactory(container), this);
  }

  protected WebElement getContainer() {
    return container;
  }

}
