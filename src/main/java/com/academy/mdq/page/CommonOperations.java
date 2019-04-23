package com.academy.mdq.page;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

import static com.academy.mdq.driver.Drivers.getDriver;
import static com.academy.mdq.properties.ReportProperties.REPORT_PROPERTIES;
import static com.academy.mdq.reports.Report.logInfo;
import static com.academy.mdq.waits.Waits.isClickable;
import static com.academy.mdq.waits.Waits.isVisible;
import static com.aventstack.extentreports.Status.INFO;
import static java.lang.String.format;
import static java.util.stream.Stream.of;

public abstract class CommonOperations {

  /**
   * Navigates back.
   */
  protected void back() {
    getDriver().getWebDriver().navigate().back();
  }

  /**
   * Clicks on the element.
   *
   * @param webElement the {@link WebElement}
   */
  protected void click(WebElement webElement) {
    logInfo(INFO, format(REPORT_PROPERTIES.clicking(), getWebElementName(webElement)));
    isClickable(webElement).click();
  }

  protected String getWebElementName(WebElement webEl) {
    String name = null;
    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      try {
        Object fieldValue = field.get(this);
        if (fieldValue != null && fieldValue == webEl) {
          name = field.getName();
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    if (name == null) {
      name = webEl.getText();
    }
    return name;
  }

  /**
   * Gets the text from the web element.
   *
   * @param webElement the {@link WebElement}
   * @return the text
   */
  protected String getText(WebElement webElement) {
    return isVisible(webElement).getText();
  }

  /**
   * Verifies if the WebElement's text matches all the criteria.
   *
   * @param webElement the {@link WebElement}
   * @param texts      the expected texts
   * @return {@code TRUE} if WebElement's text matches the criteria
   */
  protected boolean match(WebElement webElement, String... texts) {
    return of(texts).allMatch(text -> getText(webElement).toLowerCase().contains(text.toLowerCase()));
  }

}
