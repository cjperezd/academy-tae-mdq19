package com.academy.mdq.pages;


import com.academy.mdq.components.ResultCard;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PropertyResultPage extends WebPage {

    @FindBy (className = "flex-link-wrap")
    private WebElement cardContainer;

    private ResultCard resultCardComponent;

    public PropertyResultPage ()
    {
        super();

        resultCardComponent = new ResultCard(cardContainer);
    }

    public WebElement getCardContainer() {
        return cardContainer;
    }

    public String getHotelName ()
    {
        return resultCardComponent.getHotelName().getText();
    }

    public Boolean isDisplayed ()
    {
        return Waits.isVisible(cardContainer).isDisplayed();
    }

    public Boolean isNameEnabled ()
    {
        return Waits.isVisible(resultCardComponent.getHotelName()).isEnabled();
    }

    public Boolean isVisibleImage ()
    {
        return Waits.isVisible(resultCardComponent.getHotelImage()).isDisplayed();
    }

    public Boolean isVisibleCity ()
    {
        return Waits.isVisible(resultCardComponent.getCityName()).isDisplayed();
    }

    public Boolean isVisiblePhone ()
    {
        return Waits.isVisible(resultCardComponent.getHotelPhone()).isDisplayed();
    }

    public Boolean isVisibleStars ()
    {
        return Waits.isVisible(resultCardComponent.getReviewStars()).isDisplayed();
    }

    public Boolean isVisibleRate ()
    {
        return Waits.isVisible(resultCardComponent.getHotelRate()).isDisplayed();
    }

    public Boolean isVisibleNightlyPrice ()
    {
        return Waits.isVisible(resultCardComponent.getNightlyPrice()).isDisplayed();
    }
}
