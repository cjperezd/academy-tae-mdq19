package com.academy.mdq.web.pages.promotionsanddiscounts.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.promotionsanddiscounts.PromotionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewPromotionCard extends WebComponent {

  @FindBy(css=".promotion-grid__item a")
  private WebElement link;

  @FindBy(className = "image")
  private WebElement backgroundImage;

  @FindBy(className = "title")
  private WebElement titleText;

  @FindBy(className = "description")
  private WebElement description;

  @FindBy(className = "button")
  private WebElement ctaButton;


  public PreviewPromotionCard(WebElement container) {
    super(container);
  }

  public boolean isVisibleImage (){
    return backgroundImage.isDisplayed();
  }

  public boolean isVisibleTitle (){
    return titleText.isDisplayed();
  }

  public boolean isVisibleDescription (){
    return description.isDisplayed();
  }

  public boolean isVisibleButton (){
    return ctaButton.isDisplayed();
  }

  public String getHref (){
    return link.getAttribute("href");
  }

  public PromotionPage clickCard (){
    click(link);
    return new PromotionPage();
  }


}
