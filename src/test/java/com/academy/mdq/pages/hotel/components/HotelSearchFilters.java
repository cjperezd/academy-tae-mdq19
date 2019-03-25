package com.academy.mdq.pages.hotel.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchFilters extends WebComponent {

    @FindBy (id = "inpHotelNameMirror")
    private WebElement inputHotelName;

    @FindBy (className = "section-header-main")
    private WebElement hotelResultTitle;

    @FindBy (id = "hotelNameGoBtn")
    private WebElement hotelNameButton;

    @FindBy (id = "aria-option-0")
    private WebElement clickFirstOptionFae;

    @FindBy (id = "modalInterstitial")
    private WebElement waitSearch;

    public HotelSearchFilters(WebElement container) {
        super(container);
    }

    public WebElement getInputHotelName() {

        return inputHotelName;
    }

    public WebElement getHotelResultTitle() {

        return hotelResultTitle;
    }

    public WebElement getHotelNameButton() {

        return hotelNameButton;
    }

    public WebElement getClickFirstOptionFae() {

        return clickFirstOptionFae;
    }

    public WebElement getWaitSearch() {
        return waitSearch;
    }
}
