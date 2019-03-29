package com.academy.mdq.web.pages.complements;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCardForm extends WebComponent {

  @FindBy(className = "billing-cardholder-name")
  private WebElement nameInput;

  @FindBy(id = "creditCardInput")
  private WebElement numberInput;

  @FindBy(className = "cc-expiry-month")
  private WebElement monthSelect;

  @FindBy(className = "cc-expiry-year")
  private WebElement yearSelect;

  @FindBy(id = "new_cc_security_code")
  private WebElement securityCodeInput;

  @FindBy(className = "pwp-insurance-zipcode")
  private WebElement billingCodeInput;

  public CreditCardForm(WebElement container) {
    super(container);
  }

  public boolean isNameInputEnable() {
    return nameInput.isEnabled();
  }

  public boolean isNumberInputEnable() {
    return numberInput.isEnabled();
  }

  public boolean isMonthSelectEnable() {
    return monthSelect.isEnabled();
  }

  public boolean isYearSelectEnable() {
    return yearSelect.isEnabled();
  }

  public boolean isSecurityCodeInputEnable() {
    return securityCodeInput.isEnabled();
  }

  public boolean isBillingCodeInputEnable() {
    return billingCodeInput.isEnabled();
  }

}
