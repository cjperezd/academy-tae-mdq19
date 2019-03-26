package com.academy.mdq.pages.complements;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.hotel.HotelPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DatePickerMonth extends WebComponent {

  @FindBy(css = ".datepicker-day-number button:not(.disabled)")
  private List<WebElement> availableDaysLabel;

  @FindBy(css = ".datepicker-day-number .start")
  private WebElement startDay;

  @FindBy(className = "datepicker-cal-month-header")
  private WebElement monthHeader;

  public DatePickerMonth(WebElement container) {
    super(container);
  }

  /*private List<WebElement> getNotDisabledDays() {
    return daysLabel
        .stream()                                                              //stream a la lista
        .filter(day -> !day.getAttribute("class").contains("disabled"))        //filtro los que no tienen la clase disable y los demas los borro
        .collect(toList());                                                    //guardo la lista
  }*/

  //pick first day available in calendar
  public HotelPage pickFirstDayAvailable() {
    availableDaysLabel.stream().findFirst().ifPresent(WebElement::click);
    return new HotelPage();
  }

  //pick the day entered in the checkin input
  public HotelPage pickSelectedDate() {
    click(startDay);
    return new HotelPage();
  }

  //pick a random day after the checkin
  public HotelPage pickRandomDay() {
    availableDaysLabel.remove(0);                                      //remuevo el primer elemento para que no eliga el mismo
    availableDaysLabel.stream().findAny().ifPresent(WebElement::click);      // elijo uno al azar y le hago click
    return new HotelPage();
  }

  //pick a number of days after the checkin
  public HotelPage pickDaysAfter(int daysAfter) {
    LocalDate end = LocalDate.now().plusDays(daysAfter);
    return new HotelPage();
  }

  public String toStringMonth() {
    return monthHeader.getText().substring(0,3).toLowerCase();
  }

  public HotelPage pickDate(String date) {
    LocalDate finalDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    availableDaysLabel.stream().filter(day -> day.getText().equals(finalDate.getDayOfMonth())).findFirst().ifPresent(WebElement::click);
    return new HotelPage();
  }

}
