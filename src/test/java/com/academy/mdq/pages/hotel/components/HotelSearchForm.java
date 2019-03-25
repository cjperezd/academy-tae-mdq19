package com.academy.mdq.pages.hotel.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.hotel.HotelSearchResult;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isClickable;

public class HotelSearchForm extends WebComponent {

    @FindBy (id = "hotel-destination-hlp")
    private WebElement inputGoingTo;

    @FindBy (id = "aria-option-0")
    private WebElement clickOnFirstOption;

    @FindBy (id = "hotel-checkin-hlp")
    private WebElement inputCheckIn;

    @FindBy(id = "hotel-checkout-hlp")
    private WebElement inputCheckOut;

    @FindBy(xpath= "//*[@id=\"hotel-checkin-wrapper-hlp\"]/label/span[2]")
    private WebElement clickCalendarIn;

    @FindBy (xpath = "//*[@id=\"hotel-checkout-wrapper-hlp\"]/label/span[2]")
    private  WebElement clickCalendarOut;

    @FindBy(id = "hotel-rooms-hlp")
    private WebElement inputRooms;

    @FindBy(id = "hotel-1-adults-hlp")
    private WebElement inputAdults;

    @FindBy (id = "hotel-1-children-hlp")
    private WebElement inputChildrens;

    @FindBy (id = "hotel-add-flight-checkbox-hlp")
    private WebElement clickAddAFlightCheckbox;

    @FindBy (id = "hotel-add-car-checkbox-hlp")
    private WebElement clickAddCarCheckbox;

    @FindBy (xpath = "//*[@id=\"gcw-hotel-form-hlp\"]/div[8]/label/button")
    private WebElement searchButton;

    @FindBy (id = "tab-hotel-tab-hlp")
    private WebElement clickHotelOnly;

    @FindBy (id = "tab-hotelFlight-tab-hlp-fh")
    private WebElement ClickHotelFlight;

    @FindBy (id = "tab-hotelFlightCar-tab-hlp-fhc")
    private WebElement clickHotelFlightCar;

    @FindBy (id = "tab-hotelCar-tab-hlp-hc")
    private WebElement clickHotelCar;

    @FindBy (className = "wizard-tabs launch-page-title ")
    private WebElement headerText;

    @FindBy (id = "hotel-1-age-select-1-hlp")
    private WebElement childrensYears;

    @FindBy (id = "modalInterstitial")
    private WebElement waitSearch;

    public HotelSearchForm(WebElement container) {
        super(container);
    }

    public HotelSearchForm typeGoingTo(String goingTo) {
        isClickable(inputGoingTo);
        type(inputGoingTo, goingTo);
        return this;
    }

    public HotelSearchForm typeCheckIn(String checkIn) {
        type(inputCheckIn, checkIn);
        return this;
    }

    public HotelSearchForm typeCheckOut(String checkOut) {
        jsClear(inputCheckOut);
        type(inputCheckOut, checkOut);
        return this;
    }

    public HotelSearchForm selectAdults(String adults) {
        selectByText(inputAdults, adults);
        return this;
    }

    public HotelSearchForm selectChildren(String children) {
        selectByText(inputChildrens, children);
        return this;
    }

    public HotelSearchForm selectChildrenYear(String childrenYear) {
        selectByText(childrensYears, childrenYear);
        return this;
    }

    public HotelSearchResult clickSearch() {
        click(searchButton);
        return new HotelSearchResult();
    }

}
