package com.academy.mdq.pages;

import com.academy.mdq.component.Header;
import com.academy.mdq.component.commons.MenuBar;
import com.academy.mdq.component.commons.TopBar;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class ProteccionDeDescubiertoPage extends WebPage {

  @FindBy(className = "openbank-topbar__top")
  private WebElement topBarDiv;

  @FindBy(className = "openbank-topbar__bottom")
  private WebElement menuBarDiv;

  @FindBy(className = "header-page")
  private WebElement pageHeader;

  private final TopBar topBar = new TopBar(topBarDiv);
  private final MenuBar menuBar = new MenuBar(menuBarDiv);

  private final Header header = new Header(pageHeader);

  public Header getHeader() {
    isVisible(pageHeader);
    return header;
  }

  public TopBar getTopBar() {
    return topBar;
  }

  public MenuBar getMenuBar() {
    return menuBar;
  }

}