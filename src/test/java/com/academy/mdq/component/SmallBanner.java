package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isClickable;
import static com.academy.mdq.waits.Waits.isVisible;

public class SmallBanner extends WebComponent {

  @FindBy(className = "heading-4")
  private WebElement titleSpan;

  @FindBy(className = "button")
  private WebElement buttonLink;

  public SmallBanner(WebElement webElement) {
    super(webElement);
  }

  public boolean isTitleVisible() {
    return isVisible(titleSpan).isDisplayed();
  }

  public boolean isButtonEnable() {
    return isClickable(buttonLink).isEnabled();
  }

}
