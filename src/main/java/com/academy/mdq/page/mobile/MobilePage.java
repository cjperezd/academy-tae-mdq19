package com.academy.mdq.page.mobile;

import com.academy.mdq.page.CommonOperations;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;

import static com.academy.mdq.driver.Drivers.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class MobilePage extends CommonOperations {

  protected MobilePage() {
    WebDriver webDriver = getDriver().getWebDriver();
    initElements(new AppiumFieldDecorator(webDriver), this);
  }

}
