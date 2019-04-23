package com.academy.mdq.web.scripts.ok.home;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.commons.ToolBarComponents.Login;
import com.academy.mdq.web.pages.commons.ToolBarComponents.NavBar;
import com.academy.mdq.web.pages.commons.ToolBarComponents.TopBar;
import com.academy.mdq.web.pages.commons.ToolBarComponents.products.ProductsMenu;
import com.academy.mdq.web.pages.commons.ToolBarComponents.products.ProductsSubMenu;
import com.academy.mdq.web.pages.home.Home;
import com.academy.mdq.web.pages.commons.Banner;
import com.academy.mdq.web.pages.products.pages.AccountsForYourAdmin;
import com.academy.mdq.web.pages.products.pages.LoansAndCredits;
import com.academy.mdq.web.pages.products.pages.MortgageOpen;
import com.academy.mdq.web.pages.products.pages.SavingAccounts;
import com.academy.mdq.web.pages.promotionsanddiscounts.PromotionPage;
import com.academy.mdq.web.pages.promotionsanddiscounts.Promotions;
import com.academy.mdq.web.pages.promotionsanddiscounts.components.PreviewPromotionCard;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

}
