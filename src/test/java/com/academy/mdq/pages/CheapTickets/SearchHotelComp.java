package com.academy.mdq.pages.CheapTickets;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotelComp extends WebComponent {

    protected SearchHotelComp(WebElement container) {
        super(container);
    }

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


    public WebElement getInputGoingTo() {
        return inputGoingTo;
    }

    public WebElement getClickOnFirstOption() {
        return clickOnFirstOption;
    }

    public WebElement getInputCheckIn() {
        return inputCheckIn;
    }

    public WebElement getInputCheckOut() {
        return inputCheckOut;
    }

    public WebElement getClickCalendarIn() {
        return clickCalendarIn;
    }

    public WebElement getClickCalendarOut() {
        return clickCalendarOut;
    }

    public WebElement getInputRooms() {
        return inputRooms;
    }

    public WebElement getInputAdults() {
        return inputAdults;
    }

    public WebElement getInputChildrens() {
        return inputChildrens;
    }

    public WebElement getClickAddAFlightCheckbox() {
        return clickAddAFlightCheckbox;
    }

    public WebElement getClickAddCarCheckbox() {
        return clickAddCarCheckbox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getClickHotelOnly() {
        return clickHotelOnly;
    }

    public WebElement getClickHotelFlight() {
        return ClickHotelFlight;
    }

    public WebElement getClickHotelFlightCar() {
        return clickHotelFlightCar;
    }

    public WebElement getClickHotelCar() {
        return clickHotelCar;
    }

    public WebElement getHeaderText() {
        return headerText;
    }

    public WebElement getChildrensYears() {
        return childrensYears;
    }

    public WebElement getWaitSearch() {
        return waitSearch;
    }
}
