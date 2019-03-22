package com.academy.mdq.page.web;

import com.academy.mdq.page.CommonOperations;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.academy.mdq.driver.Drivers.getDriver;
import static com.academy.mdq.waits.Waits.isTextPresent;
import static com.academy.mdq.waits.Waits.isVisible;

public abstract class WebOperations extends CommonOperations {

  /**
   * Navigates to the URL.
   *
   * @param url the URL
   */
  protected void goTo(String url) {
    getDriver().getWebDriver().get(url);
  }

  /**
   * Refresh the page.
   */
  protected void refresh() {
    getDriver().getWebDriver().navigate().refresh();
  }

  /**
   * Types on the element.
   *
   * @param webElement the {@link WebElement}
   * @param text       the text
   */
  protected boolean type(WebElement webElement, String text) {
    isVisible(webElement).sendKeys(text);
    return isTextPresent(webElement, text);
  }

  /**
   * Selects an option by text from an HTML Select.
   *
   * @param webElement the {@link WebElement}
   * @param text       the text to select
   */
  protected void selectByText(WebElement webElement, String text) {
    select(webElement).selectByVisibleText(text);
  }

  private Select select(WebElement webElement) {
    return new Select(webElement);
  }

  public void jsClear(WebElement element){
    JavascriptExecutor js = (JavascriptExecutor) getDriver().getWebDriver();
    element.click();
    js.executeScript("return arguments[0].value = '';", element);
  }

}
