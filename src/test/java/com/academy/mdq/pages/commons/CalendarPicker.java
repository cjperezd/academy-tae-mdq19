package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;

public class CalendarPicker extends WebComponent {

    @FindBy(className = "datepicker-close")
    private WebElement datePickerCloseButton;

    @FindBy(className = "datepicker-cal-month")
    private List<WebElement> calendarMonthContainers;

    @FindBy(className = "datepicker-prev")
    private WebElement prevButton;

    @FindBy(className = "datepicker-next")
    private WebElement nextButton;

    private List<CalendarMonth> calendarsComponents;

    public CalendarPicker(WebElement container) {
        super(container);
    }

    private void clickNext() {
        click(nextButton);
    }

    private void clickPrev() {
        click(prevButton);

    }

    public void clickCheckInDate (String date)
    {

    }


    public void closeCalendar() {
        click(datePickerCloseButton);
    }

}
