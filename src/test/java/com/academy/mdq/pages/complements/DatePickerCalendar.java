package com.academy.mdq.pages.complements;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.isClickable;

public class DatePickerCalendar extends WebComponent {

  @FindBy(className = "datepicker-cal-month")
  private List<WebElement> calendars;

  @FindBy(className = "datepicker-next")
  private WebElement nextCalendarButton;

  private List<DatePickerMonth> monthsCalendar = new ArrayList<>();

  public DatePickerCalendar(WebElement container) {
    super(container);
  }

  public void setCalendars() {
    Waits.areVisible(calendars);
    calendars.stream().forEach(element -> monthsCalendar.add(new DatePickerMonth(element)));
  }

  public void chooseMonth(String checkIn) {
    LocalDate start = LocalDate.parse(checkIn, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    while (!start.getMonth().name().substring(0,3).toLowerCase().equals(monthsCalendar.get(0).toStringMonth())) {
      click(isClickable(nextCalendarButton));
      setCalendars();
    }
    monthsCalendar.get(0).pickDate(checkIn);
  }

  public DatePickerMonth returnCorrectMonth(String date) {
    LocalDate finalDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    if (finalDate.getMonth().toString().substring(0,3).equals(monthsCalendar.get(0).toStringMonth()))
      return monthsCalendar.get(0);
    else
      return monthsCalendar.get(1);
  }

  public DatePickerMonth returnFirstMonth() {
    return monthsCalendar.get(0);
  }

  public DatePickerMonth returnSecondMonth() {
    return monthsCalendar.get(1);
  }

}
