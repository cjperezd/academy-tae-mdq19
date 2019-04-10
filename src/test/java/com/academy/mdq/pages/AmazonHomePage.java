package com.academy.mdq.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.commons.Header;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends WebPage {

  @FindBy(id = "navbar")
  private WebElement navegationBar;

  private final Header navBar = new Header(navegationBar);

  public AmazonHomePage setFilter(String filter) {
    navBar.selectFilter(filter);
    return this;
  }

  public SearchResultPage search(String search) {
    return navBar.enterSearch(search);
  }

}
