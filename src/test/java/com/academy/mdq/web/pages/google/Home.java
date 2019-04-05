package com.academy.mdq.web.pages.google;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.google.commons.Footer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends WebPage {

  @FindBy(className = "fbar")
  private WebElement footerContainer;

  public Footer getFooter(){
    return new Footer(footerContainer);
  }
}
