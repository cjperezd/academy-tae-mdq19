package com.academy.mdq.pages.CheapTickets.components;
import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.crypto.Data;

public class CalendarComp extends WebComponent {


    public CalendarComp(WebElement container) {
        super(container);
    }

    @FindBy(className = "datepicker-close-btn close btn-text")
    private WebElement clickCloseCalendar;

    @FindBy (xpath = "//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[3]/table/tbody/tr[2]/td[1]/button")
    private WebElement calendarDay;

    public WebElement getClickCloseCalendar() {
        return clickCloseCalendar;
    }

    public WebElement getCalendarDay() {
        return calendarDay;
    }
}
