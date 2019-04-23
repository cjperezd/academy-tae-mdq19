package com.academy.mdq.pages;

import com.academy.mdq.component.Header;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PromoPage extends WebPage {

  @FindBy(className = "header-page")
  private WebElement pageHeader;

  private final Header header = new Header(pageHeader);

  public Header getHeader() {
    return header;
  }

}
