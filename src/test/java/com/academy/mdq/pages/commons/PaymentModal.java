package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PaymentModal extends WebComponent {

    @FindBy (id="deposit-pay-now-button")
    private WebElement payTotalButton;

    public PaymentModal(WebElement container) {
        super(container);
    }

    public void clickPayTotal ()
    {
        click(payTotalButton);

    }
}
