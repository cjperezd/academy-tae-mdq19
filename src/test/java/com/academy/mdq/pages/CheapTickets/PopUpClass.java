package com.academy.mdq.pages.CheapTickets;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpClass extends WebComponent {
    protected PopUpClass(WebElement container) {
        super(container);
    }

    @FindBy(id = "modalCloseButton")
    private WebElement closePopUp;

    @FindBy (id = "copyCouponButton")
    private WebElement copyPopUp;

    @FindBy (linkText = "Click here")
    private WebElement clickTermsPopUp;

    public WebElement getClosePopUp() {
        return closePopUp;
    }

    public WebElement getCopyPopUp() {
        return copyPopUp;
    }

    public WebElement getClickTermsPopUp() {
        return clickTermsPopUp;
    }
}
