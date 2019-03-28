package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.areVisible;

public class CalendarMonth extends WebComponent {

    @FindBy(css = ".datepicker-day-number button:not(.disabled)")
    private List<WebElement> availableDaysLabel;

    @FindBy(css = ".datepicker-day-number .start")
    private WebElement startDay;

    @FindBy(className = "datepicker-cal-month-header")
    private WebElement monthHeader;

    public CalendarMonth(WebElement container) {
        super(container);
    }

    public void pickDate(int dayOfMonth) {
        String day = String.valueOf(dayOfMonth);
        areVisible(availableDaysLabel)
                .stream()
                .filter(availableDay -> availableDay.getText().contains(day))
                .findFirst()
                .ifPresent(WebElement::click);
    }

}