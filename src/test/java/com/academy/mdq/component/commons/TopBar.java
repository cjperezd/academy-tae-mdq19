package com.academy.mdq.component.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.AyudaUrgentePage;
import com.academy.mdq.pages.OpenBankHomePage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.isVisible;

public class TopBar extends WebComponent {

  @FindBy(css = ".openbank-topbar__utility__item a[title=\"Ayuda Urgente\"]")
  private WebElement ayudaUrgenteButton;

  @FindBy(css = ".openbank-topbar__utility__item a[title=\"Ayuda Urgente\"] i")
  private WebElement ayudaUrgenteIcon;

  @FindBy(css = ".openbank-topbar__utility__item a[title=\"Contáctanos\"]")
  private WebElement contactanosButton;

  @FindBy(css = ".openbank-topbar__utility__item a[title=\"Contáctanos\"] i")
  private WebElement contactanosIcon;

  @FindBy(css = ".openbank-topbar__utility__item a[title=\"Preguntas Frecuentes\"]")
  private WebElement preguntasButton;

  @FindBy(css = ".openbank-topbar__utility__item a[title=\"Preguntas Frecuentes\"] i")
  private WebElement preguntasIcon;

  @FindBy(css = ".openbank-topbar__utility__item a[title=\"Cajeros\"]")
  private WebElement cajerosButton;

  @FindBy(css = ".openbank-topbar__utility__item a[title=\"Cajeros\"] i")
  private WebElement cajerosIcon;

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

  public boolean isLanguageButtonVisible() {
    return isVisible(languageButton).isDisplayed();
  }

  public boolean isLanguageButtonEnable() {
    return languageButton.isEnabled();
  }

  public boolean areLanguagesVisible() {
    click(languageButton);
    return Waits.isVisible(languageButton).isDisplayed();
  }

  public boolean isAyudaUrgenteButtonVisible() {
    return isVisible(ayudaUrgenteButton).isDisplayed();
  }

  public boolean isAyudaUrgenteButtonEnable() {
    return ayudaUrgenteButton.isEnabled();
  }

  public boolean isAyudaUrgenteIconVisible() {
    return isVisible(ayudaUrgenteIcon).isDisplayed();
  }

  public String getAyudaUrgenteURL() {
    return ayudaUrgenteButton.getAttribute("href");
  }

  public boolean isContactanosButtonEnable() {
    return contactanosButton.isEnabled();
  }

  public boolean isContactanosButtonVisible() {
    return isVisible(contactanosButton).isDisplayed();
  }

  public String getContactanosURL() {
    return contactanosButton.getAttribute("href");
  }

  public boolean isPreguntasFrecuentesButtonVisible() {
    return isVisible(preguntasButton).isDisplayed();
  }

  public boolean isPreguntasFrecuentesButtonEnable() {
    return preguntasButton.isEnabled();
  }

  public String getPreguntasFrecuentesURL() {
    return preguntasButton.getAttribute("href");
  }

  public boolean isCajerosButtonVisible() {
    return isVisible(cajerosButton).isDisplayed();
  }

  public boolean isCajerosButtonEnable() {
    return cajerosButton.isEnabled();
  }

  public String getCajerosURL() {
    return cajerosButton.getAttribute("href");
  }

  public AyudaUrgentePage selectAyudaUrgente() {
    click(ayudaUrgenteButton);
    return new AyudaUrgentePage();
  }

}
