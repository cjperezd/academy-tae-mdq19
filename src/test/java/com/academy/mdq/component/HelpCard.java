package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class HelpCard extends WebComponent {

  @FindBy(className = "box-grid__item__small-image")
  private WebElement iconDiv;

  @FindBy(css = ".box-grid__item__small-image img")
  private WebElement iconImg;

  @FindBy(className = "box-grid__item__title")
  private WebElement titleDiv;

  @FindBy(className = "box-grid__item__text")
  private WebElement textDiv;

  public HelpCard(WebElement webElement) {
    super(webElement);
  }

  public boolean isTitleVisible() {
    return isVisible(titleDiv).isDisplayed();
  }

  public boolean isIconVisible() {
    return isVisible(iconDiv).isDisplayed();
  }

  public boolean isTextVisible() {
    return isVisible(textDiv).isDisplayed();
  }

  public String getIconImg() {
    return iconImg.getAttribute("src");
  }

}
