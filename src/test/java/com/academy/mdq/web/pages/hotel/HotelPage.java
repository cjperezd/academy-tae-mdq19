package com.academy.mdq.web.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.complements.DatePickerCalendar;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class HotelPage extends WebPage {

  @FindBy(id = "hotel-destination-hlp")
  private WebElement destinInput;

  @FindBy(id = "aria-option-0")
  private WebElement destinLi;

  @FindBy(id = "hotel-checkin-hlp")
  private WebElement checkinInput;

  @FindBy(id = "hotel-checkout-hlp")
  private WebElement checkoutInput;

  @FindBy(id = "hotel-1-adults-hlp")
  private WebElement adultSelect;

  @FindBy(id = "hotel-1-children-hlp")
  private WebElement childrenSelect;

  @FindBy(id = "hotel-1-age-select-1-hlp")
  private WebElement childrenAgeSelect;

  @FindBy(css = "[data-gcw-change-submit-text='Search']")
  private WebElement searchButton;

  @FindBy(className = "datepicker-cal")
  private WebElement datepicker;

  public HotelPage() {
    super();
    if (!isVisible()) {
      throw new NotFoundException("Unable to create Hotel page, elements are not visible...");
    }
  }

  public HotelPage enterDestination(String destination) {
    click(Waits.isVisible(destinInput));
    type(destinInput, destination);
    click(destinLi);
    return this;
  }

  public HotelPage selectCheckIn(LocalDate checkIn) {
    click(checkinInput);
    new DatePickerCalendar(datepicker).selectCheckIn(checkIn);
    return this;
  }

  public HotelPage selectCheckOut(LocalDate checkOut, int checkInMonth) {
    click(checkoutInput);
    new DatePickerCalendar(datepicker).selectCheckOut(checkOut, checkInMonth);
    return this;
  }

  /*public HotelPage enterCheckIn(String dateIn) {
    click(checkinInput);
    calendar.setCalendars();
    type(checkinInput, dateIn);
    calendar.returnFirstMonth().pickFirstDayAvailable();
    return this;
  }

  public HotelPage enterCheckOut(String dateOut) {
    click(checkoutInput);
    calendar.setCalendars();
    jsClear(checkoutInput);
    type(checkoutInput, dateOut);
    return this;
  }

  public HotelPage pickFirstDay() {
    click(checkinInput);
    calendar.setCalendars();
    calendar.returnFirstMonth().pickFirstDayAvailable();
    return this;
  }

  public HotelPage pickDaysAfter(int daysAfter) {
    click(checkoutInput);
    calendar.setCalendars();
    jsClear(checkoutInput);
    calendar.returnSecondMonth().pickDaysAfter(daysAfter);
    return this;
  }*/

  public HotelPage selectAdults(int num) {
    selectByText(adultSelect, String.valueOf(num));
    return this;
  }

  public HotelPage selectChildren(int num) {
    selectByText(childrenSelect, String.valueOf(num));
    return this;
  }

  public HotelPage selectAge(int num) {
    selectByText(childrenAgeSelect, String.valueOf(num));
    return this;
  }

  public HotelResults search() {
    click(searchButton);
    return new HotelResults();
  }

  private boolean isVisible() {
    return Waits.isVisible(destinInput).isDisplayed() && Waits.isVisible(checkinInput).isDisplayed() && Waits.isVisible(checkoutInput)
        .isDisplayed() && Waits.isVisible(searchButton).isDisplayed();
  }

}
