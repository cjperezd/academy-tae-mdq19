package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;

import static com.academy.mdq.waits.Waits.areVisible;
import static java.time.LocalDate.now;

public class CalendarPicker extends WebComponent {

    @FindBy(className = "datepicker-cal-month")
    private List<WebElement> calendars;

    @FindBy(className = "datepicker-next")
    private WebElement nextCalendarButton;

    public CalendarPicker(WebElement container) {
        super(container);
    }

    public CalendarPicker selectCheckIn(LocalDate checkIn) {
        int actualMonth = now().getMonthValue();
        while (actualMonth < checkIn.getMonthValue()) {
            click(nextCalendarButton);
            actualMonth++;
        }
        new CalendarMonth(areVisible(calendars).get(0)).pickDate(checkIn.getDayOfMonth());
        return this;
    }

    public CalendarPicker selectCheckOut(LocalDate checkOut, int checkInMonth) {
        CalendarMonth calendar;
        if (checkOut.getMonthValue() == checkInMonth) {
            calendar = new CalendarMonth(areVisible(calendars).get(0));
        } else {
            calendar = new CalendarMonth(areVisible(calendars).get(1));
        }

        calendar.pickDate(checkOut.getDayOfMonth());
        return this;
    }

}