package com.academy.mdq.pages.common.components;


import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;

import static com.academy.mdq.js.Javascript.click;
import static com.academy.mdq.waits.Waits.areVisible;
import static java.time.LocalDate.*;

public class DatePickerCalendar extends WebComponent {

    @FindBy(className = "datepicker-cal-month")
    private List<WebElement> calendars;

    @FindBy(className = "datepicker-next")
    private WebElement nextCalendarButton;

    public DatePickerCalendar(WebElement container) {
        super(container);
    }

    public DatePickerCalendar selectCheckIn(LocalDate checkIn) {
        int actualMonth = now().getMonthValue();
        while (actualMonth < checkIn.getMonthValue()) {
            click(nextCalendarButton);
            actualMonth++;
        }
        new DatePickerMonth(areVisible(calendars).get(0)).pickDate(checkIn.getDayOfMonth());
        return this;
    }

    public DatePickerCalendar selectCheckOut(LocalDate checkOut, int checkInMonth) {
        DatePickerMonth calendar;
        if (checkOut.getMonthValue() == checkInMonth) {
            calendar = new DatePickerMonth(areVisible(calendars).get(0));
        } else {
            calendar = new DatePickerMonth(areVisible(calendars).get(1));
        }

        calendar.pickDate(checkOut.getDayOfMonth());
        return this;
    }

}
