package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.hotel.components.HotelSearchForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearch extends WebPage {
    @FindBy(id = "gcw-hotel-form-hlp")
    private WebElement searchContainer;

    @FindBy(id = "modalInterstitial")
    private WebElement waitingSign;

    private final HotelSearchForm searchFormComponent = new HotelSearchForm(searchContainer);

    public HotelSearch typeDestination(String destination) {
        return searchFormComponent.typeDestination(destination, this);
    }

    public HotelSearch selectCheckInDate(String date) {
        return searchFormComponent.selectCheckInDate(date, this);
    }

    public HotelSearch selectCheckOutDate(String date) {
        return searchFormComponent.selectCheckOutDate(date, this);
    }

    public HotelSearch selectAdults(String adultsQuantity) {
        return searchFormComponent.selectAdults(adultsQuantity, this);
    }

    public HotelSearch selectChildren(String childrenQuantity) {
        return searchFormComponent.selectChildren(childrenQuantity, this);
    }

    public HotelSearch selectChildrenAge(String childrenAge) {
        return searchFormComponent.selectChildrenAge(childrenAge, this);
    }

    public HotelSearchResults clickOnSearchButton() {
        return searchFormComponent.clickSearchButton(waitingSign);
    }

    public HotelSearch pickDateCheckIn (String date)
    {
        searchFormComponent.pickCheckInDate(date,this);
        return  this;
    }
}
