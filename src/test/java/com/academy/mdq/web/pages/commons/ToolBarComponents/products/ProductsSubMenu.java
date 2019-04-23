package com.academy.mdq.web.pages.commons.ToolBarComponents.products;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.products.pages.AccountsForYourAdmin;
import com.academy.mdq.web.pages.products.pages.LoansAndCredits;
import com.academy.mdq.web.pages.products.pages.MortgageOpen;
import com.academy.mdq.web.pages.products.pages.SavingAccounts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.isVisible;

public class ProductsSubMenu extends WebComponent {

  @FindBy(css = ".navigation-submenu__item--active .navigation-submenu__header")
  private WebElement titleText;

  @FindBy(css = ".navigation-submenu__item--active .navigation-section__title-text")
  private List<WebElement> subMenuTitlesLinks;

  public ProductsSubMenu(WebElement container) {
    super(container);
  }

  public String getSubMenuTitle() {
    isVisible(titleText);
    return titleText.getText();
  }

  public List<String> getLinksTitles(){
    List<String> titles = new ArrayList<>();
    subMenuTitlesLinks.forEach(link->titles.add(link.getText()));
    return titles;
  }

  public AccountsForYourAdmin clickAccountsForYourAdmin (){
    click(subMenuTitlesLinks.stream().filter(link->link.getText().contains("Cuentas para tus gestiones")).findFirst().get());
    return new AccountsForYourAdmin();
  }

  public SavingAccounts clickSavingAccounts(){
    click(subMenuTitlesLinks.stream().filter(link->link.getText().contains("Cuentas de Ahorro")).findFirst().get());
    return new SavingAccounts();
  }

  public MortgageOpen clickMortgageOpen(){
    click(subMenuTitlesLinks.stream().filter(link->link.getText().contains("Hipotecas Open")).findFirst().get());
    return new MortgageOpen();
  }

  public LoansAndCredits clickLoansAndCredits(){
    click (subMenuTitlesLinks.stream().filter(link->link.getText().contains("Préstamos y Créditos")).findFirst().get());
        return new LoansAndCredits();
  }

}
