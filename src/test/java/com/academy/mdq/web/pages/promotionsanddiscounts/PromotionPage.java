package com.academy.mdq.web.pages.promotionsanddiscounts;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.commons.Banner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromotionPage extends WebPage {

  @FindBy(css = ".header-page")
  private WebElement bannerContainer;

  public Banner getBanner (){
    return new Banner(bannerContainer);
  }

  public Promotions getBack(){
    back();
    return new Promotions();
  }
}
