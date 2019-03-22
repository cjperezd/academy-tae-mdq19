package com.academy.mdq.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotelsForm extends WebComponent {

    public SearchHotelsForm(WebElement container) {
        super(container);
    }

    @FindBy (className = "wizard-tabs launch-page-title")
    private WebElement titleH1;

    @FindBy (id = "section-hotel-tab-hlp")
    private WebElement hotelOnlyButton;

    @FindBy (id = "section-hotelFlight-tab-hlp-fh")
    private WebElement hotelFlightButton;

    @FindBy (id = "section-hotelFlightCar-tab-hlp-fh")
    private WebElement hotelFlightCarButton;

    @FindBy (id = "section-hotelCar-tab-hlp-fh")
    private WebElement hotelCarButton;

    @FindBy (id = "hotel-destination-hlp")
    private WebElement goingToInput;

    @FindBy (id = "aria-option-0")
    private WebElement firstOption;

    @FindBy (id = "hotel-checkin-hlp")
    private WebElement checkInInput;

    @FindBy (className = "datepicker-close-btn close btn-text")
    private WebElement checkInExitButton;

    @FindBy (id = "hotel-checkout-hlp")
    private WebElement checkOutInput;

    @FindBy (className = "datepicker-close-btn close btn-text")
    private WebElement checkOutExitButton;

    @FindBy (id = "hotel-rooms-hlp")
    private WebElement roomsSelect;

    @FindBy (id = "hotel-1-adults-hlp")
    private WebElement adultsSelect;

    @FindBy (id = "hotel-1-children-hlp")
    private WebElement childrenSelect;

    @FindBy (id = "hotel-1-age-select-1-hlp")
    private WebElement childrenAgeSelect;

    @FindBy (id = "hotel-add-flight-checkbox-hlp")
    private WebElement addFlightCheckBox;

    @FindBy (id = "hotel-add-car-checkbox-hlp")
    private WebElement addCarCheckBox;

    @FindBy (css = "#gcw-hotel-form-hlp .search-btn-col button")
    private WebElement searchButton;


    public WebElement getTitleH1() {
        return titleH1;
    }

    public WebElement getHotelOnlyButton() {
        return hotelOnlyButton;
    }

    public WebElement getHotelFlightButton() {
        return hotelFlightButton;
    }

    public WebElement getHotelFlightCarButton() {
        return hotelFlightCarButton;
    }

    public WebElement getHotelCarButton() {
        return hotelCarButton;
    }

    public WebElement getGoingToInput() {
        return goingToInput;
    }

    public WebElement getCheckInInput() {
        return checkInInput;
    }

    public WebElement getCheckInExitButton() {
        return checkInExitButton;
    }

    public WebElement getCheckOutInput() {
        return checkOutInput;
    }

    public WebElement getCheckOutExitButton() {
        return checkOutExitButton;
    }

    public WebElement getRoomsSelect() {
        return roomsSelect;
    }

    public WebElement getAdultsSelect() {
        return adultsSelect;
    }

    public WebElement getChildrenSelect() {
        return childrenSelect;
    }

    public WebElement getChildrenAgeSelect() {
        return childrenAgeSelect;
    }

    public WebElement getAddFlightCheckBox() {
        return addFlightCheckBox;
    }

    public WebElement getAddCarCheckBox() {
        return addCarCheckBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getFirstOption () { return firstOption; }
}
