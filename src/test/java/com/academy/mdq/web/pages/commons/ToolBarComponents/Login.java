package com.academy.mdq.web.pages.commons.ToolBarComponents;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(id = "secLog")
public class Login extends WebComponent {

  @FindBy(id = "frmLogin")
  private WebElement loginForm;


  public boolean isLoginFormVisible() {
    return loginForm.isDisplayed();
  }

  public boolean isLoginFormEnabled() {
    return loginForm.isEnabled();
  }


}
