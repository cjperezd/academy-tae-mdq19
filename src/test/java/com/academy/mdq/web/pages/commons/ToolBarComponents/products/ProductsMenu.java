package com.academy.mdq.web.pages.commons.ToolBarComponents.products;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@FindBy(css = ".navigation-menu__item.menu-item.navigation-menu__item--product .navigation-menu__item-content")
public class ProductsMenu extends WebComponent {

  @FindBy(className = "navigation-submenu__item-title")
  private List<WebElement> titlesButtons;

  @FindBy(css = ".navigation-submenu__item--active .navigation-submenu__item-content")
  private WebElement subMenuContainer;

  public ProductsMenu() {
  }

  public String getAccountsButtonTitle() {
    return titlesButtons.get(0).getText();
  }

  public String getCardsButtonTitle() {
    return titlesButtons.get(1).getText();
  }

  public String getFinancingButtonTitle() {
    return titlesButtons.get(2).getText();
  }

  public String getDepositsButtonTitle() {
    return titlesButtons.get(3).getText();
  }

  public String getServicesButtonTitle() {
    return titlesButtons.get(4).getText();
  }

  public String getWealthButtonTitle() {
    return titlesButtons.get(5).getText();
  }

  public ProductsSubMenu clickAccountsButton() {
    click(titlesButtons.get(0));
    return new ProductsSubMenu(subMenuContainer);
  }

  public ProductsSubMenu clickCardsButton() {
    click(titlesButtons.get(1));
    return new ProductsSubMenu(subMenuContainer);
  }

  public ProductsSubMenu clickFinancingButton() {
    click(titlesButtons.get(2));
    return new ProductsSubMenu(subMenuContainer);
  }

  public ProductsSubMenu clickDepositsButton() {
    click(titlesButtons.get(3));
    return new ProductsSubMenu(subMenuContainer);
  }

  public ProductsSubMenu clickServicesButton() {
    click(titlesButtons.get(4));
    return new ProductsSubMenu(subMenuContainer);
  }

  public ProductsSubMenu clickWealthButton() {
    click(titlesButtons.get(5));
    return new ProductsSubMenu(subMenuContainer);
  }


}
