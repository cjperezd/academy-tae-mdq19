package com.academy.mdq.web.pages.urgenthelp.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactOption extends WebComponent {

  @FindBy(className = "box-grid__item__small-image")
  private WebElement contactIcon;

  @FindBy(className = "box-grid__item__title")
  private WebElement contactName;

  @FindBy(className = "box-grid__item__text")
  private WebElement contactNumber;

  public ContactOption(WebElement container) {
    super(container);
  }

  public boolean isVisibleIcon(){
    return contactIcon.isDisplayed();
  }

  public boolean isVisibleName(){
    return contactName.isDisplayed();
  }

  public boolean isVisibleNumber(){
    return contactNumber.isDisplayed();
  }
}
