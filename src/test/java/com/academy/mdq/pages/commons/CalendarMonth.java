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

    public void clickSelectedDay (int selectedDay)
    {
        WebElement daySelected = dayButtons.get(0);
        for (WebElement day : dayButtons)
        {
            if (day.getText().equals(String.valueOf(selectedDay)))
            {
                daySelected = day;
            }
        }
        click(daySelected);
    }
}
