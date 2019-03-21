package com.academy.mdq.js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.academy.mdq.driver.Drivers.getDriver;

/**
 * Javascript.
 */
public final class Javascript {

  /**
   * Executes a click on the element by javascript.
   *
   * @param webElement the {@link WebElement}
   */
  public static void click(WebElement webElement) {
    js().executeScript("arguments[0].click();", webElement);
  }

  /**
   * Creates an javascript executor.
   *
   * @return the {@link JavascriptExecutor}
   */
  private static JavascriptExecutor js() {
    return (JavascriptExecutor) getDriver().getWebDriver();
  }


}
