package Complements;

import Search.HotelPage;
import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DatePicker extends WebComponent {

  @FindBy(css = ".datepicker-day-number button:not(.disabled)")
  private List<WebElement> availableDaysLabel;

  @FindBy(css = ".datepicker-day-number .start")
  private WebElement startday;

  public DatePicker(WebElement container) {
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
    click(startday);
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
    click(availableDaysLabel.get(daysAfter));
    return new HotelPage();
  }

}
