package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelDetailsResult extends WebPage {

    public HotelDetailsResult() {
        super();
    }


    @FindBy(id = "payments")
    private WebElement paymentsWrap;

    @FindBy(css = ".text.billing-cardholder-name.cko-field.cardholder-above-cardname.gb-whitelist")
    private WebElement inputCreditCardName;

    @FindBy(id = "creditCardInput")
    private WebElement inputCreditCardNumber;

    @FindBy (css = ".cko-field.cc-expiry-month.gb-whitelist")
    private WebElement selectExpirationDateMonth;

    @FindBy (css = ".cko-field.cc-expiry-year.gb-whitelist")
    private WebElement selectExpirationDateYear;

    @FindBy (id = "new_cc_security_code")
    private WebElement inputSecurityCode;

    @FindBy(css = ".text.cko-field.pwp-insurance-zipcode.gb-whitelist")
    private WebElement billingZIPCode;



    public boolean isInputCardNameVisible(){
        Waits.isVisible(paymentsWrap);
        return inputCreditCardName.isDisplayed();
    }

    public boolean isInputCardNumberVisible(){
        return inputCreditCardNumber.isDisplayed();
    }

    public boolean isExpirationDateMonthVisible(){
        return selectExpirationDateMonth.isDisplayed();
    }

    public boolean isExpirationDateYearVisible(){
        return selectExpirationDateYear.isDisplayed();
    }

    public boolean isSecurityCodeVisible(){
        return inputSecurityCode.isDisplayed();
    }

    public boolean isBillingZipCodeVisible(){
        return billingZIPCode.isDisplayed();
    }
}
