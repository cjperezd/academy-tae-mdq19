package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopBar extends WebComponent {

  @FindBy(className = "openbank-topbar__utility__item")
  private List<WebElement> buttons;

  private WebElement helpButton;

  private WebElement contactUsButton;

  private WebElement faqButton;

  private WebElement atmsButton;

  private WebElement languageButton;

  @FindBy(css = ".language-switcher-item  a[href=\"/es\"]")
  private WebElement esLanguageButton;

  @FindBy(css = ".language-switcher-item  a[href=\"/en\"]")
  private WebElement enLanguageButton;


  public TopBar(WebElement container) {
    super(container);
    helpButton = buttons.get(0);
    contactUsButton = buttons.get(1);
    faqButton = buttons.get(2);
    atmsButton = buttons.get(3);
    languageButton = buttons.get(4);
  }

  public TopBar clickLanguageButton(){
    click(languageButton);
    return this;
  }

  public TopBar clickENLanguegeButton(){
    click(enLanguageButton);
    return this;
  }
}
