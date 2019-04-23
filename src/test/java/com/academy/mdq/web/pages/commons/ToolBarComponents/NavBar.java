package com.academy.mdq.web.pages.commons.ToolBarComponents;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.commons.ToolBarComponents.products.ProductsMenu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class NavBar extends WebComponent {

  @FindBy(css = ".navigation-menu__item.menu-item:nth-child(1)")
  private WebElement productsButton;

  @FindBy(css = ".navigation-menu__item.menu-item:nth-child(1) .navigation-submenu")
  private WebElement productsSubMenu;

  @FindBy(css = ".navigation-menu__item.menu-item:nth-child(2)")
  private WebElement promAndDiscountsButton;

  @FindBy(css = ".navigation-menu__item.menu-item:nth-child(2) .navigation-submenu")
  private WebElement promAndDiscountsSubMenu;

  @FindBy(css = ".navigation-menu__item.menu-item:nth-child(3) a")
  private WebElement aboutUsButton;

  @FindBy(css = ".openbank-topbar__actions a:nth-child(1)")
  private WebElement registerButton;

  @FindBy(className = "openbank-topbar__actions__access")
  private WebElement loginButton;

  @FindBy(id = "frmLogin")
  private WebElement loginForm;

  public NavBar(WebElement container) {
    super(container);
  }

  public boolean isProductsButtonVisible() {
    return isVisible(productsButton).isDisplayed();
  }

  public boolean isPromAndDiscountsButtonVisible() {
    return isVisible(promAndDiscountsButton).isDisplayed();
  }

  public boolean isAboutUsButtonVisible() {
    return isVisible(aboutUsButton).isDisplayed();
  }

  public boolean isRegisterButtonVisible() {
    return isVisible(registerButton).isDisplayed();
  }

  public boolean isLoginButtonVisible() {
    return isVisible(loginButton).isDisplayed();
  }

  public boolean isProductsButtonEnabled() {
    return productsButton.isEnabled();
  }

  public boolean isPromAndDiscountsButtonEnabled() {
    return promAndDiscountsButton.isEnabled();
  }

  public boolean isAboutUsButtonEnabled() {
    return aboutUsButton.isEnabled();
  }

  public boolean isRegisterButtonEnabled() {
    return registerButton.isEnabled();
  }

  public boolean isLoginButtonEnabled() {
    return loginButton.isEnabled();
  }


  public String getAboutUsButtonUrl() {
    return aboutUsButton.getAttribute("href");
  }

  public String getRegisterButtonUrl() {
    return registerButton.getAttribute("href");
  }

  public boolean isProductsButtonExpandable() {
    click(productsButton);
    return productsSubMenu.isDisplayed();
  }

  public boolean isPromAndDiscountButtonExpandable() {
    click(promAndDiscountsButton);
    return promAndDiscountsSubMenu.isDisplayed();
  }

  public Login clickLoginButton() {
    click(loginButton);
    return new Login();
  }

  public ProductsMenu clickProducts (){
    click(productsButton);
    return new ProductsMenu();
  }


}
