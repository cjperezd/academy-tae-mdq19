package com.academy.mdq.pages.complements;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Banner extends WebPage {

  @FindBy(className = "datepicker-cal")
  private WebElement datePickerContainer;

  private final DatePicker datePicker = new DatePicker(datePickerContainer);

  protected DatePicker datePicker(){
    return datePicker;
  }

}
