package com.academy.mdq.component.commons;

import com.academy.mdq.component.Login;
import com.academy.mdq.component.ProductsMenu;
import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.DescuentosOpenPage;
import com.academy.mdq.pages.PromocionesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.isVisible;

public class MenuBar extends WebComponent {

  @FindBy(className = "navigation-menu__item--product")
  private WebElement productsButton;

  @FindBy(css = ".navigation-menu__item--product .navigation-submenu")
  private WebElement productsContainer;

  @FindBy(css = ".navigation-menu__item--discounts:nth-child(2)")
  private WebElement promButton;

  @FindBy(css = ".navigation-menu__item--discounts:nth-child(2) .navigation-submenu")
  private WebElement promContainer;

  @FindBy(css = ".navigation-menu__item--discounts li a")
  private List<WebElement> promOptions;

  @FindBy(css = ".navigation-menu__item--discounts:nth-child(3) a")
  private WebElement aboutButton;

  @FindBy(className = "openbank-topbar__actions__become")
  private WebElement registerButton;

  @FindBy(className = "openbank-topbar__actions__access")
  private WebElement loginButton;

  public MenuBar(WebElement container) {
    super(container);
  }

  public boolean isProductButtonVisible() {
    return isVisible(productsButton).isDisplayed();
  }

  public boolean isProductButtonEnable() {
    return productsButton.isEnabled();
  }

  public boolean isPromButtonVisible() {
    return isVisible(promButton).isDisplayed();
  }

  public boolean isPromButtonEnable() {
    return promButton.isEnabled();
  }

  public boolean isAboutButtonVisible() {
    return isVisible(aboutButton).isDisplayed();
  }

  public boolean isAboutButtonEnable() {
    return aboutButton.isEnabled();
  }

  public boolean isRegisterButtonVisible() {
    return isVisible(registerButton).isDisplayed();
  }

  public boolean isRegisterButtonEnable() {
    return registerButton.isEnabled();
  }

  public boolean isLoginButtonVisible() {
    return isVisible(loginButton).isDisplayed();
  }

  public boolean isLoginButtonEnable() {
    return loginButton.isEnabled();
  }

  public ProductsMenu selectProductsMenu() {
    click(productsButton);
    return new ProductsMenu(productsContainer);
  }

  public PromocionesPage selectPromociones() {
    click(promButton);
    promOptions.stream().filter(o -> o.getText().equals("Promociones")).findFirst().ifPresent(WebElement::click);
    return new PromocionesPage();
  }

  public DescuentosOpenPage selectDescuentosOpen() {
    click(promButton);
    promOptions.stream().filter(o -> o.getText().equals("Descuentos Open")).findFirst().ifPresent(WebElement::click);
    return new DescuentosOpenPage();
  }

  public boolean isPromContainerVisible() {
    click(promButton);
    return isVisible(promContainer).isDisplayed();
  }

  public String getAboutButtonURL() {
    return aboutButton.getAttribute("href");
  }

  public String getRegisterButtonURL() {
    return registerButton.getAttribute("href");
  }

  public Login selectLogin() {
    click(loginButton);
    return new Login();
  }

}
