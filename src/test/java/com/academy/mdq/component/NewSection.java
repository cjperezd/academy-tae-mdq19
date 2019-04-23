package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class NewSection extends WebComponent {

  @FindBy(className = "paragraph--small")
  private WebElement dateSpan;

  @FindBy(css = ".heading-2, h2.text-align-justify")
  private WebElement titleH2;

  @FindBy(css = ".whynot__block__half__rich-text p:nth-child(3)")
  private WebElement firstDescriptionP;

  @FindBy(className = "whynot__block__image")
  private WebElement imgPicture;

  public NewSection(WebElement container) {
    super(container);
  }

  public boolean isDateVisible() {
    return isVisible(dateSpan).isDisplayed();
  }

  public boolean isTitleVisible() {
    return isVisible(titleH2).isDisplayed();
  }

  public boolean isDescriptionVisible() {
    return isVisible(firstDescriptionP).isDisplayed();
  }

  public boolean isImgVisible() {
    return isVisible(imgPicture).isDisplayed();
  }

}
