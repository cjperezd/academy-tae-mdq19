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


    public String getHotelName ()
    {
        return resultCardComponent.getHotelName();
    }

    public Boolean isDisplayed ()
    {
        return resultCardComponent.isDisplayed(cardContainer);
    }

    public Boolean isNameEnabled ()
    {
        return resultCardComponent.isNameEnabled();
    }

    public Boolean isVisibleImage ()
    {
        return resultCardComponent.isVisibleImage();
    }

    public Boolean isVisibleCity ()
    {
        return resultCardComponent.isVisibleCity();
    }

    public Boolean isVisiblePhone ()
    {
        return resultCardComponent.isVisiblePhone();
    }

    public Boolean isVisibleStars ()
    {
        return resultCardComponent.isVisibleStars();
    }

    public Boolean isVisibleRate () { return resultCardComponent.isVisibleRate(); }

    public Boolean isVisibleNightlyPrice ()
    {
        return resultCardComponent.isVisibleNightlyPrice();
    }
}
