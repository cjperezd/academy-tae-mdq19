package com.academy.mdq.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

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


    public String getHotelName ()
    {
        return hotelName.getText();
    }

    public Boolean isDisplayed (WebElement cardContainer)
    {
        return isVisible(cardContainer).isDisplayed();
    }

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
}
