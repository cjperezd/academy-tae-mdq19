package com.academy.mdq.pages;

import com.academy.mdq.components.PopUp;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends WebPage {

    @FindBy(className = "modal-body")
    private WebElement popUpContainer;

    private PopUp popUpComponent;


    public SearchResultsPage (){
        super();

        popUpComponent = new PopUp(popUpContainer);
    }

    public SearchResultsPage closePopUp ()
    {
        Waits.isVisible(popUpContainer);
        if (popUpContainer.isDisplayed())
        {
            click(popUpComponent.getCloseButton());
        }
        return this;
    }
}
