package com.academy.mdq.web.pages.cheaptickets.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.cheaptickets.commons.CreditCardInfo;
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
