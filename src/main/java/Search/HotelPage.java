package Search;

import Complements.Banner;
import com.academy.mdq.waits.Waits;

public class HotelPage extends Banner {

  public HotelPage enterDestination(String destination) {
    type(getDestinInput(), destination);
    click(getDestinLi());
    return this;
  }

  //enter checkin manually and pick date in calendar
  public HotelPage enterCheckIn(String dateIn) {
    click(getCheckinInput());
    type(getCheckinInput(), dateIn);
    getDatePicker().pickFirstDayAvailable();
    return this;
  }

  //enter checkout manually
  public HotelPage enterCheckOut(String dateOut) {
    click(getCheckoutInput());
    jsClear(getCheckoutInput());
    type(getCheckoutInput(), dateOut);
    return this;
  }

  //pick first day available in calendar
  public HotelPage pickFirstDay() {
    click(getCheckinInput());
    getDatePicker().pickFirstDayAvailable();
    return this;
  }

  //pick random checkout day in calendar
  public HotelPage pickRandomLastDate() {
    click(getCheckoutInput());
    getDatePicker().pickRandomDay();
    return this;
  }

  //pick a number of days after the checkin
  public HotelPage pickLastDay(int days) {
    click(getCheckoutInput());
    jsClear(getCheckoutInput());
    getDatePicker().pickDaysAfter(days);
    return this;
  }

  public HotelPage selectAdults(int num) {
    selectByText(getAdultSelect(), String.valueOf(num));
    return this;
  }

  public HotelPage selectChildren(int num) {
    selectByText(getChildrenSelect(), String.valueOf(num));
    return this;
  }

  public HotelPage selectAge(int num) {
    selectByText(getChildrenAgeSelectt(), String.valueOf(num));
    return this;
  }

  public HotelResults selectButton() {
    click(getSearchButton());
    return new HotelResults();
  }

  public boolean isVisibleMethod() {
    return Waits.isVisible(getDestinInput()).isDisplayed() && Waits.isVisible(getCheckinInput()).isDisplayed() && Waits.isVisible(getCheckoutInput()).isDisplayed() && Waits.isVisible(getSearchButton()).isDisplayed();
  }

}
