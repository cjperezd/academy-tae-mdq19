package com.academy.mdq.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.SearchResultsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class PopUp extends WebComponent {
    public PopUp(WebElement container) {
        super(container);
    }

    @FindBy (id ="copyCouponButton")
    private WebElement copyTextButton;

    @FindBy (linkText = "Click here")
    private WebElement clickTermsButton;

    @FindBy (id="modalCloseButton")
    private WebElement closeButton;


    public SearchResultsPage closePopUp(SearchResultsPage searchResultsPage, WebElement popUpContainer) {
        if (isVisible(popUpContainer).isDisplayed()) {
            click(closeButton);
        }
        return searchResultsPage;
    }
}
