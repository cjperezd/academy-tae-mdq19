package com.academy.mdq.page.web;

import com.academy.mdq.driver.Driver;

import static com.academy.mdq.driver.Drivers.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class WebPage extends WebOperations {

  protected WebPage() {
    Driver driver = getDriver();
    initElements(driver.getWebDriver(), this);
  }

}
