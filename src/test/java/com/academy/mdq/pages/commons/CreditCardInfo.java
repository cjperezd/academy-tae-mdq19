package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.*;

public class CreditCardInfo extends WebComponent {

    @FindBy(css = ".text.billing-cardholder-name")
    private WebElement cardholderNameInput;

    @FindBy(id = "creditCardInput")
    private WebElement cardNumberInput;

    @FindBy(css = ".cko-field.cc-expiry-month.gb-whitelist")
    private WebElement expirationMonthSelect;

    @FindBy(css = ".cko-field.cc-expiry-year.gb-whitelist")
    private WebElement expirationYearSelect;

    @FindBy(id = "new_cc_security_code")
    private WebElement securityCodeInput;

    @FindBy(css = ".text.cko-field.pwp-insurance-zipcode.gb-whitelist")
    private WebElement zipCodeInput;


    public CreditCardInfo(WebElement container) {
        super(container);
    }

    public boolean isDisplayedCardholderName() {
        return cardholderNameInput.isDisplayed();
    }

    public boolean isEnabledCardholderName() {
        return cardholderNameInput.isEnabled();
    }

    public boolean isDisplayedcardNumberInput() {
        return cardNumberInput.isDisplayed();
    }

    public boolean isEnabledcardNumberInput() {
        return cardNumberInput.isEnabled();
    }

    public boolean isDisplayedexpirationMonthSelect() {
        return expirationMonthSelect.isDisplayed();
    }

    public boolean isEnabledexpirationMonthSelect() {
        return expirationMonthSelect.isEnabled();
    }

    public boolean isDisplayedexpirationYearSelect() {
        return expirationYearSelect.isDisplayed();
    }

    public boolean isEnabledexpirationYearSelect() {
        return expirationYearSelect.isEnabled();
    }

    public boolean isDisplayedsecurityCodeInput() {
        return securityCodeInput.isDisplayed();
    }

    public boolean isEnabledsecurityCodeInput() {
        return securityCodeInput.isEnabled();
    }

    public boolean isDisplayedzipCodeInput() {
        return zipCodeInput.isDisplayed();
    }

    public boolean isEnabledZipCodeInput() {
        return zipCodeInput.isEnabled();
    }


}
