package com.academy.mdq.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public WebElement getCopyTextButton() {
        return copyTextButton;
    }

    public WebElement getClickTermsButton() {
        return clickTermsButton;
    }

    public WebElement getCloseButton() {
        return closeButton;
    }
}
