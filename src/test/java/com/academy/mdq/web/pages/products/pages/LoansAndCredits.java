package com.academy.mdq.web.pages.products.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.commons.Banner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoansAndCredits extends WebPage {
  @FindBy(css = ".header-page")
  private WebElement bannerContainer;

  public Banner getBanner (){
    return new Banner(bannerContainer);
  }
}
