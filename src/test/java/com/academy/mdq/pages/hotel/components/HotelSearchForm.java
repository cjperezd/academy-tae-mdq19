package com.academy.mdq.pages.hotel.components;

import com.academy.mdq.pages.commons.CalendarPicker;
import com.academy.mdq.driver.Drivers;
import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.hotel.HotelSearch;
import com.academy.mdq.pages.hotel.HotelSearchResults;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(id = "hotel-checkout-hlp")
    private WebElement checkOutInput;

    //@FindBy(css = ".datepicker-cal-date.start[data-year=\"2019\"][data-month=\"5\"][data-day=\"20\"]")
    private WebElement dayPickerCheckInButton;

    //@FindBy(className = "datepicker-close-btn close btn-text")
    //private WebElement checkInExitButton;

    //@FindBy(css = ".datepicker-cal-date[data-year=\"2019\"][data-month=\"5\"][data-day=\"23\"]")
    //private WebElement dayPickerCheckOutButton;

    @FindBy (css = "tbody.datepicker-cal-dates")
    private WebElement datePickerTable;

    //@FindBy(className = "datepicker-close-btn close btn-text")
    //private WebElement checkOutExitButton;

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

    private CalendarPicker calPicker;

    public HotelSearchForm(WebElement container) {
        super(container);
    }


    public HotelSearch typeDestination (String destination, HotelSearch hotelSearch)
    {
        Waits.isClickable(goingToInput).isEnabled();
        Waits.isClickable(checkInInput);
        type(goingToInput,destination);
        selectFirstOption();
        return hotelSearch;
    }

    private void selectFirstOption ()
    {
        click(firstOption);
    }


    public HotelSearch selectCheckInDateByPicker (HotelSearch hotelSearch, String day, String month, String year)
    {
        click(checkInInput);
        //calPicker.findDay("30");
        dayPickerCheckInButton = Drivers.getDriver().getWebDriver().findElement(By.cssSelector(".datepicker-cal-date.start[data-year=\""+ year + "\"][data-month=\"" + month + "\"][data-day=\"" + day + "\"]"));
        click(dayPickerCheckInButton);
        return hotelSearch;
    }

    public HotelSearch selectCheckInDate (String checkInDate, HotelSearch hotelSearch)
    {
        type(checkInInput,checkInDate);
        return hotelSearch;
    }

    public HotelSearch selectCheckOutDateByPicker (HotelSearch hotelSearch)
    {
        click(checkOutInput);
        calPicker.findDay("30");
        return hotelSearch;
    }

    public HotelSearch selectCheckOutDate (String checkOutDate, HotelSearch hotelSearch)
    {
        jsClear(checkOutInput);
        type(checkOutInput,checkOutDate);
        return hotelSearch;
    }

    public HotelSearch selectAdults (String adultsQuantity, HotelSearch hotelSearch)
    {
        selectByText(adultsSelect, adultsQuantity);
        return hotelSearch;
    }

    public HotelSearch selectChildren (String childrenQuantity, HotelSearch hotelSearch)
    {
        selectByText(childrenSelect, childrenQuantity);
        return hotelSearch;
    }

    public HotelSearch selectChildrenAge (String childrenAge, HotelSearch hotelSearch)
    {
        selectByText(childrenAgeSelect, childrenAge);
        return hotelSearch;
    }

    public HotelSearchResults clickSearchButton (WebElement waitingSign)
    {
        click(searchButton);
        isNotVisible(waitingSign);
        return new HotelSearchResults();
    }


}
