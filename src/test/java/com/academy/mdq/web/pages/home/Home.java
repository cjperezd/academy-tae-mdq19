package com.academy.mdq.web.pages.home;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.commons.Footer;
import com.academy.mdq.web.pages.commons.ToolBarComponents.NavBar;
import com.academy.mdq.web.pages.commons.ToolBarComponents.TopBar;
import com.academy.mdq.web.pages.home.components.ProductSearchComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class Home extends WebPage {
  @FindBy(className = "openbank-topbar__top")
  private WebElement topBarContainer;

  @FindBy(className = "openbank-topbar__bottom")
  private WebElement navBarContainer;

  @FindBy(css = "#product-search .container")
  private WebElement searchContainer;

  @FindBy(className = "footer-menu__top")
  private WebElement footerContainer;

  public TopBar getTopBar() {
    isVisible(topBarContainer);
    return new TopBar(topBarContainer);
  }

  public NavBar getNavBar() {
    isVisible(navBarContainer);
    return new NavBar(navBarContainer);
  }

  public ProductSearchComponent getProductSearchComponent() {
    isVisible(searchContainer);
    return new ProductSearchComponent(searchContainer);
  }

  public Footer getFooter(){
    return new Footer(footerContainer);
  }

}
