package com.academy.mdq.web.pages.contactus.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhoneOption extends WebComponent {

  @FindBy(css=".card-info img")
  private WebElement icon;

  public PhoneOption(WebElement container) {
    super(container);
  }

  public boolean isIconVisible(){
    return icon.isDisplayed();
  }

}
