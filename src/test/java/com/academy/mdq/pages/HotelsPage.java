package com.academy.mdq.pages;

import com.academy.mdq.components.SearchHotelsForm;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsPage extends WebPage
{
    @FindBy (id = "gcw-hotel-form-hlp")
    private WebElement searchContainer;

    private SearchHotelsForm searchFormComponent;

    public HotelsPage ()
    {
        super();

        searchFormComponent = new SearchHotelsForm(searchContainer);

    }

    public HotelsPage typeDestination (String destination)
    {

        type(searchFormComponent.getGoingToInput(),destination);

        return this;
    }

    public HotelsPage selectCheckInDate (String checkInDate)
    {
        type(searchFormComponent.getCheckInInput(),checkInDate);
        return this;
    }

    public HotelsPage selectCheckOutDate (String checkOutDate)
    {
        type(searchFormComponent.getCheckOutInput(),checkOutDate);
        return this;
    }

    public  HotelsPage selectAdults (String adultsQuantity)
    {
        type(searchFormComponent.getAdultsSelect(),adultsQuantity);
        return this;
    }

    public  HotelsPage selectChildren (String childrenQuantity)
    {
        type(searchFormComponent.getChildrenSelect(),childrenQuantity);
        return this;
    }

    public  HotelsPage selectChildrenAge (String childrenAge)
    {
        type(searchFormComponent.getChildrenAgeSelect(),childrenAge);
        return this;
    }

    public SearchResultsPage clickOnSearchButton ()
    {
        Waits.isVisible(searchFormComponent.getSearchButton());
        click(searchFormComponent.getSearchButton());
        return new SearchResultsPage();
    }

}
