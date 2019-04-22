package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class RiskSidebar extends WebComponent {

  @FindBy(css = ".risk__bde__level .risk__bde__description")
  private WebElement riskDescriptionDiv;

  @FindBy(className = "risk__bde__description--legal")
  private WebElement descriptionDiv;

  public RiskSidebar(WebElement webElement) {
    super(webElement);
  }

  public boolean isTextVisible() {
    return isVisible(riskDescriptionDiv).isDisplayed() && isVisible(descriptionDiv).isDisplayed();
  }

}
