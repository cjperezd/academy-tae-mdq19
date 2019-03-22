package com.academy.mdq.pages.CheapTickets.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarComp extends WebComponent {


    protected CalendarComp(WebElement container) {
        super(container);
    }

    @FindBy(className = "datepicker-close-btn close btn-text")
    private WebElement clickCloseCalendar;
}
