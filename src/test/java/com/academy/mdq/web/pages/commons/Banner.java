package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Banner extends WebComponent {

  @FindBy(className = "header-page__image")
  private WebElement bannerImage;

  @FindBy(className = "header-page__title")
  private WebElement bannerText;

  @FindBy(className = "small-banner---wrapper")
  private WebElement boxImage;

  @FindBy(css = ".heading-4, .heading-1--content")
  private WebElement boxText;

  @FindBy(css = ".small-banner---wrapper .button")
  private WebElement boxButton;

  public Banner(WebElement container) {
    super(container);
  }

  public boolean isBannerImgVisible (){
    return bannerImage.isDisplayed();
  }

  public boolean isBannerTextVisible (){
    return bannerText.isDisplayed();
  }

  public String getBannerText (){
    return bannerText.getText();
  }

  public boolean isBoxImgVisible (){
    return boxImage.isDisplayed();
  }

  public boolean isBoxTextVisible (){
    return boxText.isDisplayed();
  }

  public boolean isBoxButtonVisible (){
    boolean bool = false;
    try{
      bool = boxButton.isDisplayed();
    }catch (Exception e1) {
    bool = false;
  }
    finally {
      return bool;
    }
  }

  public boolean isBoxButtonEnabled (){
    boolean bool = false;
    try{
      bool = boxButton.isEnabled();
    }catch (Exception e1) {
      bool = false;
    }
    finally {
      return bool;
    }
  }

}
