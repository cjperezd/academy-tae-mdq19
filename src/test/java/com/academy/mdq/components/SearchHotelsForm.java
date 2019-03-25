package com.academy.mdq.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.HotelsPage;
import com.academy.mdq.pages.SearchResultsPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isNotVisible;

public class SearchHotelsForm extends WebComponent {

    public SearchHotelsForm(WebElement container) {
        super(container);
    }

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

    @FindBy(className = "datepicker-close-btn close btn-text")
    private WebElement checkInExitButton;

    @FindBy(id = "hotel-checkout-hlp")
    private WebElement checkOutInput;

    @FindBy(className = "datepicker-close-btn close btn-text")
    private WebElement checkOutExitButton;

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


    public HotelsPage typeDestination (String destination, HotelsPage hotelsPage)
    {
        Waits.isClickable(goingToInput).isEnabled();
        type(goingToInput,destination);
        selectFirstOption();
        return hotelsPage;
    }

    private void selectFirstOption ()
    {
        click(firstOption);
    }

    public HotelsPage selectCheckInDate (String checkInDate, HotelsPage hotelsPage)
    {
        type(checkInInput,checkInDate);
        return hotelsPage;
    }

    public HotelsPage selectCheckOutDate (String checkOutDate, HotelsPage hotelsPage)
    {
        jsClear(checkOutInput);
        type(checkOutInput,checkOutDate);
        return hotelsPage;
    }

    public  HotelsPage selectAdults (String adultsQuantity, HotelsPage hotelsPage)
    {
        type(adultsSelect,adultsQuantity);
        return hotelsPage;
    }

    public  HotelsPage selectChildren (String childrenQuantity, HotelsPage hotelsPage)
    {
        type(childrenSelect,childrenQuantity);
        return hotelsPage;
    }

    public  HotelsPage selectChildrenAge (String childrenAge, HotelsPage hotelsPage)
    {
        type(childrenAgeSelect,childrenAge);
        return hotelsPage;
    }

    public SearchResultsPage clickSearchButton (WebElement waitingSign)
    {
        click(searchButton);
        isNotVisible(waitingSign);
        return new SearchResultsPage();
    }


}
