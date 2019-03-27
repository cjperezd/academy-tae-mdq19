package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.complements.CreditCardForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class PaymentPage extends WebPage {

  @FindBy(id = "payments")
  private WebElement cardArticle;

  CreditCardForm cardForm = new CreditCardForm(cardArticle);

  public boolean isCardFormVisible() {
    return isVisible(cardArticle).isDisplayed();
  }

  public boolean areAllElementsEnable() {
    return cardForm.isNameInputEnable() && cardForm.isNumberInputEnable() && cardForm.isMonthSelectEnable() && cardForm.isYearSelectEnable() && cardForm.isSecurityCodeInputEnable() && cardForm.isBillingCodeInputEnable();
  }

}
