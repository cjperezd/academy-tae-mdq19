package com.academy.mdq.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarPicker extends WebComponent {

    @FindBy (className = "datepicker-close")
    private WebElement datePickerCloseButton;

    private List<WebElement> columns;

    protected CalendarPicker(WebElement container) {
        super(container);

        columns = container.findElements(By.tagName("td"));
    }

    public void findDay (String day)
    {
        for (WebElement days : columns)
        {
            if (days.getText().equals(day))
            {
                click(days.findElement(By.linkText(day)));
                closeCalendar();
                break;
            }
        }
    }

    private void closeCalendar ()
    {
           click(datePickerCloseButton);

    }

}
