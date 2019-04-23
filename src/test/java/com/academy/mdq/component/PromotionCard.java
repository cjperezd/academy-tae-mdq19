package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.PromoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class PromotionCard extends WebComponent {

  @FindBy(css = ".promotion-grid__item a")
  private WebElement linkA;

  @FindBy(className = "image")
  private WebElement imgPicture;

  @FindBy(className = "title")
  private WebElement titleDiv;

  @FindBy(className = "description")
  private WebElement descriptionDiv;

  @FindBy(className = "cta-container")
  private WebElement ctaDiv;

  public PromotionCard(WebElement webElement) {
    super(webElement);
  }

  public boolean isImgPictureVisible() {
    return isVisible(imgPicture).isDisplayed();
  }

  public boolean isTitleDivVisible() {
    return isVisible(titleDiv).isDisplayed();
  }

  public boolean isDescriptionDivVisible() {
    return isVisible(descriptionDiv).isDisplayed();
  }

  public boolean isCtaDivEnable() {
    return isVisible(ctaDiv).isEnabled();
  }

  public String getLink() {
    return linkA.getAttribute("href");
  }

  public PromoPage select() {
    click(linkA);
    return new PromoPage();
  }

}
