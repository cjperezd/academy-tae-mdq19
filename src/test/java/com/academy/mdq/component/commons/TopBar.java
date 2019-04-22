package com.academy.mdq.component.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.OpenBankHomePage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.isVisible;

public class TopBar extends WebComponent {

  @FindBy(css = "li.openbank-topbar__utility__item:not(.language-toggle) a")
  private List<WebElement> topOptions;

  @FindBy(className = "language-switcher")
  private WebElement languageButton;

  @FindBy(css = "ul.language-switcher-language-url li")
  private List<WebElement> languagesOptionsLi;

  @FindBy(className = "language-switcher-language-url")
  private  WebElement languageBoxUl;

  public TopBar(WebElement container) {
    super(container);
  }

  public OpenBankHomePage selectLanguage(String lang) {
    click(languageButton);
    languagesOptionsLi.stream()
        .filter(l -> l.getText().equals(lang.substring(0, 2)))
        .findFirst()
        .ifPresent(WebElement::click);
    return new OpenBankHomePage();
  }

  public WebElement getButton(String name) {
    return topOptions.stream().filter(b -> b.getText().contains(name)).findFirst().get();
  }

  public boolean isButtonVisible(String name) {
    return isVisible(getButton(name)).isDisplayed();
  }

  public boolean isButtonEnable(String name) {
    return getButton(name).isEnabled();
  }

  public boolean isLanguageButtonVisible() {
    return isVisible(languageButton).isDisplayed();
  }

  public boolean isLanguageButtonEnable() {
    return languageButton.isEnabled();
  }

  public String getButtonURL(String name) {
    return getButton(name).getAttribute("href");
  }

  public boolean areLanguagesVisible() {
    click(languageButton);
    return Waits.isVisible(languageButton).isDisplayed();
  }

}
