package com.academy.mdq.web.pages.home;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.commons.TopBar;
import com.academy.mdq.web.pages.home.components.ProductSearchComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class Home extends WebPage {
  @FindBy(id = "block-openbank-topbar")
  private WebElement topBarContainer;

  @FindBy(css = "#product-search .container")
  private WebElement searchContainer;

  public TopBar getTopBar() {
    isVisible(topBarContainer);
    return new TopBar(topBarContainer);
  }

  public ProductSearchComponent getProductSearchComponent() {
    isVisible(searchContainer);
    return new ProductSearchComponent(searchContainer);
  }

}
