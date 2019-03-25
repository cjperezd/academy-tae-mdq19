package com.academy.mdq.pages.hotel;

import com.academy.mdq.pages.complements.Banner;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelPage extends Banner {

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
  private WebElement datePickerContainer;

  public HotelPage(){
    super();
    if (!isVisible()){
      throw new NotFoundException("Unable to create Hotel page, elements are not visible...");
    }
  }

  public HotelPage enterDestination(String destination) {
    type(destinInput, destination);
    click(destinLi);
    return this;
  }

  public HotelPage enterCheckIn(String dateIn) {
    click(checkinInput);
    type(checkinInput, dateIn);
    datePicker().pickFirstDayAvailable();
    return this;
  }

  public HotelPage enterCheckOut(String dateOut) {
    click(checkoutInput);
    jsClear(checkoutInput);
    type(checkoutInput, dateOut);
    return this;
  }

  public HotelPage pickFirstDay() {
    click(checkinInput);
    datePicker().pickFirstDayAvailable();
    return this;
  }

  public HotelPage pickRandomLastDate() {
    click(checkoutInput);
    datePicker().pickRandomDay();
    return this;
  }

  public HotelPage pickLastDay(int days) {
    click(checkinInput);
    jsClear(checkinInput);
    datePicker().pickDaysAfter(days);
    return this;
  }

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
