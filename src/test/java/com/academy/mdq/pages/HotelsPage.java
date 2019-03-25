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
        return searchFormComponent.typeDestination(destination,this);
    }

    public HotelsPage selectCheckInDate (String date)
    {
        return searchFormComponent.selectCheckInDate(date, this);
    }

    public HotelsPage selectCheckOutDate (String date)
    {
        return searchFormComponent.selectCheckOutDate(date, this);
    }


    public  HotelsPage selectAdults (String adultsQuantity)
    {
        return searchFormComponent.selectAdults(adultsQuantity,this);

    }

    public  HotelsPage selectChildren (String childrenQuantity)
    {
        return searchFormComponent.selectChildren(childrenQuantity, this);
    }

    public  HotelsPage selectChildrenAge (String childrenAge)
    {
        return searchFormComponent.selectChildrenAge(childrenAge,this);
    }

    public SearchResultsPage clickOnSearchButton ()
    {
        return searchFormComponent.clickSearchButton(waitingSign);
    }

}
