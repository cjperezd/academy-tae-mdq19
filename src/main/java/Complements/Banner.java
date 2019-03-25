package Complements;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Banner extends WebPage {

  @FindBy(id = "hotel-destination-hlp")
  private WebElement destinInput;

  @FindBy(id = "aria-option-0")
  private WebElement destinLi;

  @FindBy(id = "hotel-checkin-hlp")
  private WebElement checkinInput;

  @FindBy(id = "hotel-checkout-hlp")
  private WebElement checkoutInput;

  @FindBy(id = "hotel-rooms-hlp")
  private WebElement roomsSelect;

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

  DatePicker datePicker = new DatePicker(datePickerContainer);

  public WebElement getDestinInput() {
    return destinInput;
  }

  public WebElement getDestinLi() {
    return destinLi;
  }

  public WebElement getCheckinInput() {
    return checkinInput;
  }

  public WebElement getCheckoutInput() {
    return checkoutInput;
  }

  public WebElement getRoomsSelect() {
    return roomsSelect;
  }

  public WebElement getAdultSelect() {
    return adultSelect;
  }

  public WebElement getChildrenSelect() {
    return childrenSelect;
  }

  public WebElement getChildrenAgeSelectt() {
    return childrenAgeSelect;
  }

  public WebElement getSearchButton() {
    return searchButton;
  }

  public DatePicker getDatePicker() {
    return datePicker;
  }

}
