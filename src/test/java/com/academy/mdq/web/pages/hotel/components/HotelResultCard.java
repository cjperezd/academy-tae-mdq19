package com.academy.mdq.web.pages.hotel.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class HotelResultCard extends WebComponent {

    @FindBy (className = "hotel-thumbnail")
    private WebElement hotelImage;

    @FindBy (className = "hotelTitle")
    private WebElement hotelName;

    @FindBy (css=".flex-link[data-track]")
    private WebElement hotelNameLink;

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

    public HotelResultCard(WebElement container) {
        super(container);
    }

    public String getHotelName ()
    {
        return hotelName.getText();
    }

    public String getCityName () { return cityName.getText();}

    public Boolean isNameEnabled ()
    {
        return isVisible(hotelName).isEnabled();
    }

    public Boolean isVisibleImage ()
    {
        return isVisible(hotelImage).isDisplayed();
    }

    public Boolean isVisibleCity ()
    {
        return isVisible(cityName).isDisplayed();
    }

    public Boolean isVisiblePhone ()
    {
        return isVisible(hotelPhone).isDisplayed();
    }

    public Boolean isVisibleStars ()
    {
        return isVisible(reviewStars).isDisplayed();
    }

    public Boolean isVisibleRate ()
    {
        return isVisible(hotelRate).isDisplayed();
    }

    public Boolean isVisibleNightlyPrice ()
    {
        return isVisible(nightlyPrice).isDisplayed();
    }

    public void clickHotelName ()
    {
        click(hotelNameLink);

    }
}
