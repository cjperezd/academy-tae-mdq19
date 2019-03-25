package Search;

import Complements.Banner;
import com.academy.mdq.waits.Waits;

public class HotelPage extends Banner {

  public HotelPage enterDestination(String destination) {
    type(getDestinInput(), destination);
    click(getDestinLi());
    return this;
  }

  public HotelPage enterCheckIn(String dateIn) {
    click(getCheckinInput());
    type(getCheckinInput(), dateIn);
    return this;
  }

  public HotelPage enterCheckOut(String dateOut) {
    click(getCheckoutInput());
    jsClear(getCheckoutInput());
    type(getCheckoutInput(), dateOut);
    return this;
  }

  public HotelPage pickFirstDay() {
    click(getCheckinInput());
    getDatePicker().pickFirstDay();
    return this;
  }

  public HotelPage pickRandomLastDate() {
    click(getCheckoutInput());
    getDatePicker().pickRandomDay();
    return this;
  }

  public HotelPage pickDaysAfter(String date, long days) {
    click(getCheckoutInput());
    getDatePicker().pickDaysAfter(date, days);
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
