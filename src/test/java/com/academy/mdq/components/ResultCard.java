package com.academy.mdq.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultCard extends WebComponent {

    public ResultCard(WebElement container) {
        super(container);
    }

    @FindBy (className = "hotel-thumbnail")
    private WebElement hotelImage;

    @FindBy (css = "h4[data-automation='hotel-name']")
    private WebElement hotelName;

    @FindBy (css = ".neighborhood.secondary ")
    private WebElement cityName;

    @FindBy (className = "no-wrap")
    private WebElement hotelPhone;

    @FindBy (css = ".starRating.secondary")
    private WebElement reviewStars;

    @FindBy (className = "reviewOverall")
    private WebElement hotelRate;

    @FindBy (className = "hotel-price")
    private WebElement nightlyPrice;

    public WebElement getHotelImage() {
        return hotelImage;
    }

    public WebElement getHotelName() {
        return hotelName;
    }

    public WebElement getCityName() {
        return cityName;
    }

    public WebElement getHotelPhone() {
        return hotelPhone;
    }

    public WebElement getReviewStars() {
        return reviewStars;
    }

    public WebElement getHotelRate() {
        return hotelRate;
    }

    public WebElement getNightlyPrice() {
        return nightlyPrice;
    }
}
