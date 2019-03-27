package com.academy.mdq.pages.hotel.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.commons.CalendarPicker;
import com.academy.mdq.pages.hotel.HotelSearch;
import com.academy.mdq.pages.hotel.HotelSearchResults;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.isClickable;
import static com.academy.mdq.waits.Waits.isNotVisible;


public class HotelSearchForm extends WebComponent {

    @FindBy(className = "wizard-tabs launch-page-title")
    private WebElement titleH1;

    @FindBy(id = "section-hotel-tab-hlp")
    private WebElement hotelOnlyButton;

    @FindBy(id = "section-hotelFlight-tab-hlp-fh")
    private WebElement hotelFlightButton;

    @FindBy(id = "section-hotelFlightCar-tab-hlp-fh")
    private WebElement hotelFlightCarButton;

    @FindBy(id = "section-hotelCar-tab-hlp-fh")
    private WebElement hotelCarButton;

    @FindBy(id = "hotel-destination-hlp")
    private WebElement goingToInput;

    @FindBy(id = "aria-option-0")
    private WebElement firstOption;

    @FindBy(id = "hotel-checkin-hlp")
    private WebElement checkInInput;

    @FindBy(css = ".datepicker-dropdown .datepicker-cal")
    private List<WebElement> calendarContainer;

    @FindBy(id = "hotel-checkout-hlp")
    private WebElement checkOutInput;

    @FindBy(id = "hotel-rooms-hlp")
    private WebElement roomsSelect;

    @FindBy(id = "hotel-1-adults-hlp")
    private WebElement adultsSelect;

    @FindBy(id = "hotel-1-children-hlp")
    private WebElement childrenSelect;

    @FindBy(id = "hotel-1-age-select-1-hlp")
    private WebElement childrenAgeSelect;

    @FindBy(id = "hotel-add-flight-checkbox-hlp")
    private WebElement addFlightCheckBox;

    @FindBy(id = "hotel-add-car-checkbox-hlp")
    private WebElement addCarCheckBox;

    @FindBy(css = "#gcw-hotel-form-hlp .search-btn-col button")
    private WebElement searchButton;

    private List<CalendarPicker> calendarCheckInOut = new ArrayList<>();



    public HotelSearchForm(WebElement container) {
        super(container);
    }

    public HotelSearch typeDestination(String destination, HotelSearch hotelSearch) {
        isClickable(goingToInput).isEnabled();
        click(goingToInput);
        type(goingToInput, destination);
        selectFirstOption();
        return hotelSearch;
    }

    private void selectFirstOption() {
        click(firstOption);
    }


    public HotelSearch selectCheckInDate(String checkInDate, HotelSearch hotelSearch) {
        type(checkInInput, checkInDate);
        return hotelSearch;
    }

    public HotelSearch selectCheckOutDate(String checkOutDate, HotelSearch hotelSearch) {
        jsClear(checkOutInput);
        type(checkOutInput, checkOutDate);
        return hotelSearch;
    }


    public HotelSearch clickCheckInInput(HotelSearch hotelSearch) {
        click(checkInInput);
        return hotelSearch;
    }

    public HotelSearch clickCheckOutInput(HotelSearch hotelSearch) {
        click(checkInInput);
        return hotelSearch;
    }

    public HotelSearch selectAdults(String adultsQuantity, HotelSearch hotelSearch) {
        selectByText(adultsSelect, adultsQuantity);
        return hotelSearch;
    }

    public HotelSearch selectChildren(String childrenQuantity, HotelSearch hotelSearch) {
        selectByText(childrenSelect, childrenQuantity);
        return hotelSearch;
    }

    public HotelSearch selectChildrenAge(String childrenAge, HotelSearch hotelSearch) {
        selectByText(childrenAgeSelect, childrenAge);
        return hotelSearch;
    }

    public HotelSearchResults clickSearchButton(WebElement waitingSign) {
        click(searchButton);
        isNotVisible(waitingSign);
        return new HotelSearchResults();
    }

    //CALENDAR PICKER METHODS

    public void initializeCalendarPickers ()
    {
        int i = 0;
        for (CalendarPicker calendar : calendarCheckInOut)
        {
            calendar = new CalendarPicker(calendarContainer.get(i));
            i++;
        }
    }

    private HotelSearch locateActualCalendarMonth (String date, HotelSearch hotelSearch)
    {
        int monthNow = LocalDate.now().getMonthValue();
        int monthWanted = LocalDate.parse(date).getMonthValue();

        int monthDifference = monthWanted - monthNow;

        if (monthDifference<0)
        {
            for (int i = 0; i <monthDifference ; i++) {
                calendarCheckInOut.get(0).clickNext();
            }

        }
        return hotelSearch;
    }

    public HotelSearch pickCheckInDate (String date, HotelSearch hotelSearch)
    {
        clickCheckInInput(hotelSearch);
        locateActualCalendarMonth(date, hotelSearch);
        calendarCheckInOut.get(0).clickDay(date);
        calendarCheckInOut.get(0).closeCalendar();
        return hotelSearch;
    }

    public HotelSearch pickCheckOutDate (String date, HotelSearch hotelSearch)
    {
        clickCheckOutInput(hotelSearch);

        calendarCheckInOut.get(1).closeCalendar();
        return hotelSearch;
    }

}
