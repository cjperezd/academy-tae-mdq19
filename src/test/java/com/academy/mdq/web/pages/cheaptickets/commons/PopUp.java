package com.academy.mdq.web.pages.cheaptickets.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.cheaptickets.hotel.HotelSearchResults;
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


    public HotelSearchResults closePopUp(HotelSearchResults hotelSearchResults, WebElement popUpContainer) {
        if (isVisible(popUpContainer).isDisplayed()) {
            click(closeButton);
        }
        return hotelSearchResults;
    }
}
