package com.academy.mdq.web.scripts.ok.home;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.commons.ToolBarComponents.Login;
import com.academy.mdq.web.pages.commons.ToolBarComponents.NavBar;
import com.academy.mdq.web.pages.commons.ToolBarComponents.TopBar;
import com.academy.mdq.web.pages.commons.ToolBarComponents.products.ProductsMenu;
import com.academy.mdq.web.pages.commons.ToolBarComponents.products.ProductsSubMenu;
import com.academy.mdq.web.pages.home.Home;
import com.academy.mdq.web.pages.products.components.Banner;
import com.academy.mdq.web.pages.products.pages.AccountsForYourAdmin;
import com.academy.mdq.web.pages.products.pages.LoansAndCredits;
import com.academy.mdq.web.pages.products.pages.MortgageOpen;
import com.academy.mdq.web.pages.products.pages.SavingAccounts;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class ToolBarTest extends BaseTestSuite {

  @Test
  public void toolBarButtonsTest() {
    Home home = new Home();
    TopBar topBar = home.getTopBar();

    checkThat("The HELP button is visible", topBar.isHelpButtonVisible(), is(true));
    checkThat("The HELP button is enabled", topBar.isHelpButtonEnabled(), is(true));
    checkThat("The HELP button redirects to the help page", topBar.getHelpButtonUrl(), equalTo("https://www.openbank.es/ayuda-urgente"));

    checkThat("The CONTACT US button is visible", topBar.isContactUsButtonVisible(), is(true));
    checkThat("The CONTACT US button is enabled", topBar.isContactUsButtonEnabled(), is(true));
    checkThat("The CONTACT US button redirects to the contact us page", topBar.getContactUsButtonUrl(), equalTo("https://www.openbank.es/contacto"));

    checkThat("The FAQ button is visible", topBar.isFaqButtonVisible(), is(true));
    checkThat("The FAQ button is enabled", topBar.isFaqButtonEnabled(), is(true));
    checkThat("The FAQ button redirects to the faq page", topBar.getFaqButtonUrl(), equalTo("https://www.openbank.es/ayuda"));

    checkThat("The ATM button is visible", topBar.isAtmsButtonVisible(), is(true));
    checkThat("The ATM button is enabled", topBar.isAtmsButtonEnabled(), is(true));
    checkThat("The ATM button redirects to the atms page", topBar.getAtmsButtonUrl(), equalTo("https://www.openbank.es/cajeros-oficinas"));

    checkThat("The LANGUAGE button is visible", topBar.isLanguageButtonVisible(), is(true));
    checkThat("The LANGUAGE button is enabled", topBar.isLanguageButtonEnabled(), is(true));
    checkThat("The LANGUAGE button is expandable", topBar.isLanguageButtonExpandable(), is(true));

    NavBar navBar = home.getNavBar();

    checkThat("The PRODUCTS button is visible", navBar.isProductsButtonVisible(), is(true));
    checkThat("The PRODUCTS button is enabled", navBar.isProductsButtonEnabled(), is(true));
    checkThat("The PRODUCTS button is expandable", navBar.isProductsButtonExpandable(), is(true));

    checkThat("The PROM AND DISCOUNTS button is visible", navBar.isPromAndDiscountsButtonVisible(), is(true));
    checkThat("The PROM AND DISCOUNTS button is enabled", navBar.isPromAndDiscountsButtonEnabled(), is(true));
    checkThat("The PROM AND DISCOUNTS button is expandable", navBar.isPromAndDiscountButtonExpandable(), is(true));

    checkThat("The ABOUT US button is visible", navBar.isAboutUsButtonVisible(), is(true));
    checkThat("The ABOUT US button is enabled", navBar.isAboutUsButtonEnabled(), is(true));
    checkThat("The ABOUT US button redirects to the about us page", navBar.getAboutUsButtonUrl(), equalTo("https://www.openbank.es/quienes-somos"));

    checkThat("The REGISTER button is visible", navBar.isRegisterButtonVisible(), is(true));
    checkThat("The REGISTER button is enabled", navBar.isRegisterButtonEnabled(), is(true));
    checkThat("The REGISTER button redirects to the register page", navBar.getRegisterButtonUrl(), equalTo("https://www.openbank.es/hazte-cliente"));

    checkThat("The LOGIN button is visible", navBar.isLoginButtonVisible(), is(true));
    checkThat("The LOGIN button is enabled", navBar.isLoginButtonEnabled(), is(true));

    Login login = navBar.clickLoginButton();

    checkThat("The LOGIN FORM is visible", login.isLoginFormVisible(), is(true));
    checkThat("The LOGIN FORM is enabled", login.isLoginFormEnabled(), is(true));
  }

  @Test
  public void productsMenuTest() {
    NavBar navBar = new Home().getNavBar();
    ProductsMenu productsMenu = navBar.clickProducts();

    checkThat("The Accounts Button says 'Cuentas'", productsMenu.getAccountsButtonTitle(), is("Cuentas"));
    checkThat("The Accounts Button shows the accounts subMenu", productsMenu.getAccountsButtonTitle(), equalTo(productsMenu.clickAccountsButton().getSubMenuTitle()));

    checkThat("The Cards Button says 'Tarjetas'", productsMenu.getCardsButtonTitle(), is("Tarjetas"));
    checkThat("The Cards Button shows the cards subMenu", productsMenu.getCardsButtonTitle(), equalTo(productsMenu.clickCardsButton().getSubMenuTitle()));

    checkThat("The Financing Button says 'Financiacion'", productsMenu.getFinancingButtonTitle(), is("Financiación"));
    checkThat("The Financing Button shows the Financing subMenu", productsMenu.getFinancingButtonTitle(), equalTo(productsMenu.clickFinancingButton().getSubMenuTitle()));

    checkThat("The Deposits Button says 'Depositos'", productsMenu.getDepositsButtonTitle(), is("Depósitos"));
    checkThat("The Deposits Button shows the deposits subMenu", productsMenu.getDepositsButtonTitle(), equalTo(productsMenu.clickDepositsButton().getSubMenuTitle()));

    checkThat("The Services Button says 'Servicios y Herramientas'", productsMenu.getServicesButtonTitle(), is("Servicios y Herramientas"));
    checkThat("The Services Button shows the services subMenu", productsMenu.getServicesButtonTitle(), equalTo(productsMenu.clickServicesButton().getSubMenuTitle()));

    checkThat("The Wealth Button says 'Openbank Wealth'", productsMenu.getWealthButtonTitle(), is("Openbank Wealth"));
    checkThat("The Wealth Button shows the wealth subMenu", productsMenu.getWealthButtonTitle(), equalTo(productsMenu.clickWealthButton().getSubMenuTitle()));

    ProductsSubMenu accountsSubMenu = productsMenu.clickAccountsButton();

    for (String title : accountsSubMenu.getLinksTitles()) {
      checkThat("The title link contains the word 'cuentas'", title.toLowerCase(), containsString("cuentas"));
    }

    AccountsForYourAdmin accountsForYourAdmin = accountsSubMenu.clickAccountsForYourAdmin();

    checkThat("The risk box is displayed", accountsForYourAdmin.isPresentRiskBox(), is(true));

    Banner accountsForYourAdminBanner = accountsForYourAdmin.getBanner();

    checkThat("The title is 'Cuentas para tus gestiones'", accountsForYourAdminBanner.getBannerText(), containsString("Cuentas para tus gestiones"));
    checkThat("The banner text is visible", accountsForYourAdminBanner.isBannerTextVisible(), is(true));
    checkThat("The banner image is visible", accountsForYourAdminBanner.isBannerImgVisible(), is(true));
    checkThat("The miniBanner is visible", accountsForYourAdminBanner.isBoxImgVisible(), is(true));
    checkThat("The miniBanner Text is visible", accountsForYourAdminBanner.isBoxTextVisible(), is(true));
    checkThat("The miniBanner button is visible", accountsForYourAdminBanner.isBoxButtonVisible(), is(true));
    checkThat("The miniBanner button is enabled", accountsForYourAdminBanner.isBoxButtonEnabled(), is(true));

    SavingAccounts savingAccounts = navBar.clickProducts().clickAccountsButton().clickSavingAccounts();

    checkThat("The risk box is displayed", savingAccounts.isPresentRiskBox(), is(true));

    Banner savingAccountsBanner = savingAccounts.getBanner();

    checkThat("The title is 'Cuentas de Ahorro'", savingAccountsBanner.getBannerText(), containsString("Cuentas de Ahorro"));
    checkThat("The banner text is visible", savingAccountsBanner.isBannerTextVisible(), is(true));
    checkThat("The banner image is visible", savingAccountsBanner.isBannerImgVisible(), is(true));
    checkThat("The miniBanner is visible", savingAccountsBanner.isBoxImgVisible(), is(true));
    checkThat("The miniBanner Text is visible", savingAccountsBanner.isBoxTextVisible(), is(true));
    checkThat("The miniBanner button is visible", savingAccountsBanner.isBoxButtonVisible(), is(true));
    checkThat("The miniBanner button is enabled", savingAccountsBanner.isBoxButtonEnabled(), is(true));

    MortgageOpen mortgageOpen = navBar.clickProducts().clickFinancingButton().clickMortgageOpen();

    Banner mortgageOpenBanner = mortgageOpen.getBanner();

    checkThat("The title is 'Hipotecas Open'", mortgageOpenBanner.getBannerText(), containsString("Hipotecas Open"));
    checkThat("The banner text is visible", mortgageOpenBanner.isBannerTextVisible(), is(true));
    checkThat("The banner image is visible", mortgageOpenBanner.isBannerImgVisible(), is(true));
    checkThat("The miniBanner is visible", mortgageOpenBanner.isBoxImgVisible(), is(true));
    checkThat("The miniBanner Text is visible", mortgageOpenBanner.isBoxTextVisible(), is(true));
    checkThat("The miniBanner button is visible", mortgageOpenBanner.isBoxButtonVisible(), is(true));
    checkThat("The miniBanner button is enabled", mortgageOpenBanner.isBoxButtonEnabled(), is(true));

    LoansAndCredits loansAndCredits = navBar.clickProducts().clickFinancingButton().clickLoansAndCredits();

    Banner loansAndCreditsBanner = loansAndCredits.getBanner();

    checkThat("The title is 'Préstamos y Créditos'", loansAndCreditsBanner.getBannerText(), containsString("Préstamos y Créditos"));
    checkThat("The banner text is visible", loansAndCreditsBanner.isBannerTextVisible(), is(true));
    checkThat("The banner image is visible", loansAndCreditsBanner.isBannerImgVisible(), is(true));
    checkThat("The miniBanner is visible", loansAndCreditsBanner.isBoxImgVisible(), is(true));
    checkThat("The miniBanner Text is visible", loansAndCreditsBanner.isBoxTextVisible(), is(true));
    checkThat("The miniBanner button is visible", loansAndCreditsBanner.isBoxButtonVisible(), is(true));
    checkThat("The miniBanner button is enabled", loansAndCreditsBanner.isBoxButtonEnabled(), is(true));


  }

}
