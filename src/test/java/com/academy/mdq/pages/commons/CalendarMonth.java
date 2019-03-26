package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CalendarMonth extends WebComponent {

    @FindBy(css = ".datepicker-day-number button:not(.disabled)")
    private List<WebElement> dayButtons;

    public CalendarMonth(WebElement container) {
        super(container);
    }

    public CalendarMonth clickCheckInDate(String dayCheck) {
        click(getDayElement(dayCheck));
        return this;
    }

    private WebElement getDayElement(String dayCheck) {
        for (WebElement dayElem : dayButtons) {
            if (dayElem.getText().equals(dayCheck)) {
                return dayElem;
            }
        }
        return dayButtons.get(0);
    }

}
