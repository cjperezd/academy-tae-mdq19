package com.academy.mdq.component.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.OpenBankHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ToolBar extends WebComponent {

  @FindBy(css = "li.openbank-topbar__utility__item a")
  private List<WebElement> topOptions;

  @FindBy(css = ".openbank-topbar__menu-container li.menu-item .navigation-menu__item-title")
  private List<WebElement> bottomOptions;

  @FindBy(css = "div.openbank-topbar__actions a")
  private List<WebElement> bottomActions;

  @FindBy(css = ".language-switcher button")
  private WebElement languageButton;

  @FindBy(css = "ul.language-switcher-language-url li")
  private List<WebElement> languagesOptionsLi;

  public ToolBar(WebElement container) {
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

  public WebElement getButton(String name, String type) {
    List<WebElement> list = new ArrayList<>();
    switch(type) {
      case "topButton":  list = topOptions; break;
      case "bottomButton": list = bottomOptions; break;
      case "buttonActions": list = bottomActions; break;
    }
    return list.stream().filter(b -> name.equals(b.getAttribute("title"))).findFirst().get();
  }

}
