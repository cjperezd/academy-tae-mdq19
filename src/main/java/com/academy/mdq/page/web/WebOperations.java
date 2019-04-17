package com.academy.mdq.page.web;

import com.academy.mdq.driver.Drivers;
import com.academy.mdq.page.CommonOperations;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static com.academy.mdq.driver.Drivers.getDriver;
import static com.academy.mdq.reports.BasicExtentReport.*;
import static com.academy.mdq.waits.Waits.isTextPresent;
import static com.academy.mdq.waits.Waits.isVisible;
import static com.aventstack.extentreports.Status.*;

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
    getTest().log(INFO, "Typing " + text + " on element " + getNameOfElement(webElement));
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
    getTest().log(INFO, "Selecting " + text + " from " + getNameOfElement(webElement));
    select(webElement).selectByVisibleText(text);
  }

  private Select select(WebElement webElement) {
    return new Select(webElement);
  }

  protected void hover(WebElement webElement) {
    Actions actions = new Actions(getDriver().getWebDriver());
    actions.moveToElement(webElement).perform();
  }

  protected void scroll(WebElement webElement) {
    JavascriptExecutor js =(JavascriptExecutor)Drivers.getDriver().getWebDriver();
    js.executeScript("arguments[0].scrollIntoView(false);", webElement);
  }

}
