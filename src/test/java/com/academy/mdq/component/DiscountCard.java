package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class DiscountCard extends WebComponent {

  @FindBy(css = ".heading-2, h2.text-align-justify")
  private WebElement titleDiv;

  @FindBy(className = "description")
  private WebElement descriptionDiv;

  @FindBy(className = "cta-container")
  private WebElement ctaButton;

  public DiscountCard(WebElement webElement) {
    super(webElement);
  }

  public boolean isTitleDivVisible() {
    return isVisible(titleDiv).isDisplayed();
  }

  public boolean isDescriptionDivVisible() {
    return isVisible(descriptionDiv).isDisplayed();
  }

  public boolean isCtaButtonVisible() {
    return isVisible(ctaButton).isDisplayed();
  }

}
