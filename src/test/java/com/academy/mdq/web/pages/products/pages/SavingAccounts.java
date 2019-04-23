package com.academy.mdq.web.pages.products.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.products.components.Banner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavingAccounts extends WebPage {

  @FindBy(css = ".header-page")
  private WebElement bannerContainer;

  @FindBy(css = ".risk__bde")
  private WebElement riskBox;

  public boolean isPresentRiskBox(){
    return riskBox.isDisplayed();
  }

  public Banner getBanner (){
    return new Banner(bannerContainer);
  }


}
