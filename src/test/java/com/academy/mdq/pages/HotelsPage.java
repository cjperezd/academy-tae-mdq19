package com.academy.mdq.pages;

import com.academy.mdq.components.SearchHotelsForm;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isNotVisible;

public class HotelsPage extends WebPage
{
    @FindBy (id = "gcw-hotel-form-hlp")
    private WebElement searchContainer;

    @FindBy(id="modalInterstitial")
    private WebElement waitingSign;

    private SearchHotelsForm searchFormComponent;

    public HotelsPage ()
    {
        super();

        searchFormComponent = new SearchHotelsForm(searchContainer);

    }

    public HotelsPage typeDestination (String destination)
    {
        Waits.isClickable(searchFormComponent.getGoingToInput()).isEnabled();
        type(searchFormComponent.getGoingToInput(),destination);
        click(searchFormComponent.getFirstOption());
        return this;
    }

    public HotelsPage selectCheckInDate (String checkInDate)
    {
        type(searchFormComponent.getCheckInInput(),checkInDate);
        return this;
    }

    public HotelsPage selectCheckOutDate (String checkOutDate)
    {
        jsClear(searchFormComponent.getCheckOutInput());
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
        click(searchFormComponent.getSearchButton());
        isNotVisible(waitingSign);
        return new SearchResultsPage();
    }

}
