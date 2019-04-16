package com.academy.mdq.page.web;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

import static com.academy.mdq.driver.Drivers.getDriver;
import static com.academy.mdq.extentReports.Extent.getTest;
import static com.academy.mdq.waits.Waits.isClickable;
import static com.academy.mdq.waits.Waits.isVisible;
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
        getTest().log(Status.INFO, "clicking on " + getElement(webElement) + "");
        isClickable(webElement).click();
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

    public String getElement(WebElement webElement) {
        Field[] fields = this.getClass().getDeclaredFields();
        String name = "Not found";
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object fieldValue = field.get(this);
                if (fieldValue != null && fieldValue == webElement) {
                    name = field.getName();
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}
