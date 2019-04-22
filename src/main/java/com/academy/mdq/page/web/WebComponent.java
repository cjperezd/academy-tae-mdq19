package com.academy.mdq.page.web;

import com.academy.mdq.driver.Drivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import static com.academy.mdq.driver.Drivers.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class WebComponent extends WebOperations {

  private WebElement container;

  protected WebComponent(WebElement container) {
    this.container = container;
    initElements(new DefaultElementLocatorFactory(container), this);
  }

  protected WebComponent(){
    initElements(new DefaultElementLocatorFactory(getDriver().getWebDriver().findElement(findClass(this.getClass()))),this);
  }

  private By findClass(Class<?> claz){
    if(claz == null){
      throw new IllegalStateException("class couldn't find the annotation");
    }
    return new FindBy.FindByBuilder().buildIt(claz.getAnnotation(FindBy.class),null);
  }

  protected WebElement getContainer() {
    return container;
  }

}
