package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.commons.CreditCardInfo;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelPayment extends WebPage {

    @FindBy(id = "payments")
    private WebElement cardPaymentContainer;

    private CreditCardInfo creditCardInfo = new CreditCardInfo(cardPaymentContainer);


    public CreditCardInfo getCreditCardInfo() {
        Waits.isVisible(cardPaymentContainer);
        return creditCardInfo;
    }
}
