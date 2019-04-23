package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class Header extends WebComponent {

  @FindBy(className = "header-page__title")
  private WebElement headerTitle;

  @FindBy(className = "header-page__image")
  private WebElement headerImg;

  @FindBy(className = "small-banner")
  private WebElement bannerDiv;

  private final SmallBanner smallBanner = new SmallBanner(bannerDiv);

  public Header(WebElement webElement) {
    super(webElement);
  }

  public SmallBanner getSmallBanner() {
    isVisible(bannerDiv);
    return smallBanner;
  }

  public String getHeaderTitle() {
    return headerTitle.getText();
  }

  public boolean isTitleVisible() {
    return isVisible(headerTitle).isDisplayed();
  }

  public boolean isImgVisible() {
    return isVisible(headerImg).isDisplayed();
  }

}
