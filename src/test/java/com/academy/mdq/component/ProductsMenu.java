package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.isVisible;

public class ProductsMenu extends WebComponent {

  @FindBy(css = ".navigation-menu__item--product .navigation-submenu__option-title")
  private List<WebElement> menuItemsLi;

  @FindBy(css = ".navigation-submenu__item--active .navigation-submenu__option-title")
  private WebElement selectedItem;

  @FindBy(css = ".navigation-submenu__item--active .navigation-submenu__item-content")
  private WebElement navegationDiv;

  public ProductsMenu(WebElement webElement) {
    super(webElement);
  }

  public boolean areItemsVisible() {
    return menuItemsLi.stream().allMatch(item -> isVisible(item).isDisplayed());
  }

  public boolean areItemsEnable() {
    return menuItemsLi.stream().allMatch(item -> item.isEnabled());
  }

  public NavegationContainer selectAnItem(Items item) {
    if (menuItemsLi.size() > item.ordinal()) {
      click(menuItemsLi.get(item.ordinal()));
    }
    return new NavegationContainer(navegationDiv);
  }

  public String getSelectedItem() {
    return selectedItem.getText();
  }

  public enum Items {
    CUENTAS,
    TARJETAS,
    FINANCIACION,
    DEPOSITOS,
    SERVICIOS,
    WEALTH
  }
}
