package com.academy.mdq.component;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.DepositoPage;
import com.academy.mdq.pages.HipotecasOpenPage;
import com.academy.mdq.pages.PrestamosYCreditosPage;
import com.academy.mdq.pages.ProteccionDeDescubiertoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavegationContainer extends WebComponent {

  @FindBy(css = ".navigation-submenu__item--active .navigation-submenu__header")
  private WebElement menuItemHeader;

  @FindBy(css = ".navigation-submenu__item--active .navigation-submenu__item-content a")
  private List<WebElement> itemLinks;

  public NavegationContainer(WebElement webElement) {
    super(webElement);
  }

  public String getItemHeader() {
    return menuItemHeader.getText();
  }

  public HipotecasOpenPage selectHipotecasOpen() {
    if (menuItemHeader.getText().equals("Financiación")) {
      itemLinks.stream().filter(i -> i.getAttribute("href").contains("hipoteca-open")).findFirst().ifPresent(WebElement::click);
      return new HipotecasOpenPage();
    } else
      return null;
  }

  public PrestamosYCreditosPage selectPrestamosYCreditos() {
    if (menuItemHeader.getText().equals("Financiación")) {
      itemLinks.stream().filter(i -> i.getAttribute("href").contains("comparador-prestamos-creditos")).findFirst().ifPresent(WebElement::click);
      return new PrestamosYCreditosPage();
    } else
      return null;
  }

  public ProteccionDeDescubiertoPage selectProteccionDeDescubierto() {
    if (menuItemHeader.getText().equals("Financiación")) {
      itemLinks.stream().filter(i -> i.getAttribute("href").contains("credito-inmediato-proteccion-descubierto")).findFirst().ifPresent(WebElement::click);
      return new ProteccionDeDescubiertoPage();
    } else
      return null;
  }

  public DepositoPage selectDeposito() {
    if (menuItemHeader.getText().equals("Depósitos")) {
      itemLinks.stream().filter(i -> i.getAttribute("href").contains("deposito-plazo-fijo-13-meses")).findFirst().ifPresent(WebElement::click);
      return new DepositoPage();
    } else
      return null;
  }

}
