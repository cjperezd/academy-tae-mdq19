package com.academy.mdq.web.pages.commons.ToolBarComponents;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.home.Home;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class TopBar extends WebComponent {

  @FindBy(css = ".openbank-topbar__utility__item:nth-child(1) a")
  private WebElement helpButton;

  @FindBy(css = ".openbank-topbar__utility__item:nth-child(2) a")
  private WebElement contactUsButton;

  @FindBy(css = ".openbank-topbar__utility__item:nth-child(3) a")
  private WebElement faqButton;

  @FindBy(css = ".openbank-topbar__utility__item:nth-child(4) a")
  private WebElement atmsButton;

  @FindBy(css = ".openbank-topbar__language button")
  private WebElement languageButton;

  @FindBy(css = ".language-switcher-language-url.dropdown-menu")
  private WebElement languageSubMenu;

  @FindBy(css = ".language-switcher-item  a[href=\"/es\"]")
  private WebElement esLanguageButton;

  @FindBy(css = ".language-switcher-item  a[href=\"/en\"]")
  private WebElement enLanguageButton;


  public TopBar(WebElement container) {
    super(container);
  }

  public TopBar clickLanguageButton() {
    click(languageButton);
    return this;
  }

  public Home clickENLanguageButton() {
    click(enLanguageButton);
    return new Home();
  }

  public boolean isHelpButtonVisible() { return isVisible(helpButton).isDisplayed(); }

  public boolean isContactUsButtonVisible() {
    return isVisible(contactUsButton).isDisplayed();
  }

  public boolean isFaqButtonVisible() {
    return isVisible(faqButton).isDisplayed();
  }

  public boolean isAtmsButtonVisible() {
    return isVisible(atmsButton).isDisplayed();
  }

  public boolean isLanguageButtonVisible() {
    return isVisible(languageButton).isDisplayed();
  }


  public boolean isHelpButtonEnabled() { return helpButton.isEnabled(); }

  public boolean isContactUsButtonEnabled() {
    return contactUsButton.isEnabled();
  }

  public boolean isFaqButtonEnabled() { return faqButton.isEnabled(); }

  public boolean isAtmsButtonEnabled( ) {
    return atmsButton.isEnabled();
  }

  public boolean isLanguageButtonEnabled() {
    return languageButton.isEnabled();
  }


  public String getHelpButtonUrl (){ return helpButton.getAttribute("href"); }

  public String getContactUsButtonUrl (){ return contactUsButton.getAttribute("href"); }

  public String getFaqButtonUrl (){ return faqButton.getAttribute("href"); }

  public String getAtmsButtonUrl() {
    return atmsButton.getAttribute("href");
  }

  public boolean isLanguageButtonExpandable() {
    click(languageButton);
    return languageSubMenu.isDisplayed();
  }

}
