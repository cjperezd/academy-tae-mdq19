package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isClickable;
import static com.academy.mdq.waits.Waits.isVisible;

public class SmallBanner extends WebComponent {

  @FindBy(css = ".small-banner__contents [class*=\"heading\"]")
  private WebElement titleSpan;

  @FindBy(css = ".small-banner__contents .button--primary")
  private WebElement buttonLink;

  public SmallBanner(WebElement webElement) {
    super(webElement);
  }

  public boolean isTitleVisible() {
    return isVisible(titleSpan).isDisplayed();
  }

  public boolean isButtonEnable() {
    try {
      return isClickable(buttonLink).isEnabled();
    } catch(TimeoutException e) {
      return true;
    }
  }

}
