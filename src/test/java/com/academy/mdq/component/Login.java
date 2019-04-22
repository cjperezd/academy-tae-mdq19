package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

@FindBy(id = "secLog")
public class Login extends WebComponent {

  @FindBy(id = "btnAccess")
  private WebElement accessButton;

  @FindBy(id = "loginComponentTypeSelect")
  private WebElement documentSelect;

  @FindBy(id = "loginComponentUserNumberInput")
  private WebElement documentInput;

  public boolean isAccessButtonVisible(){
    return isVisible(accessButton).isDisplayed();
  }

  public boolean isDocumentSelectEnable(){
    return documentSelect.isEnabled();
  }

  public boolean isDocumentInputEnable(){
    return documentInput.isEnabled();
  }

}
