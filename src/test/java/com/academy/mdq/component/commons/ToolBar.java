package com.academy.mdq.component.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.OpenBankEnglishHomePage;
import com.academy.mdq.pages.OpenBankHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.isClickable;

public class ToolBar extends WebComponent {

  @FindBy(css = "li.openbank-topbar__utility__item a")
  private List<WebElement> topBarTopOptions;

  @FindBy(css = ".openbank-topbar__menu-container li.menu-item .navigation-menu__item-title")
  private List<WebElement> topBarBottomOptions;

  @FindBy(css = "div.openbank-topbar__actions a")
  private List<WebElement> topBarBottomActions;

  @FindBy(css = ".language-switcher button")
  private WebElement languageButton;

  @FindBy(css = "ul.language-switcher-language-url li")
  private List<WebElement> languagesOptionsLi;

  public ToolBar(WebElement container) {
    super(container);
  }

  public OpenBankHomePage selectLanguage(String lang) {
    click(languageButton);
    languagesOptionsLi.stream().filter(l -> l.getText().equals(lang.substring(0, 2))).findFirst().ifPresent(WebElement::click);
    if (lang.equals("english"))
      return new OpenBankEnglishHomePage();
    else
      return new OpenBankHomePage();
  }

  public boolean topButtonMatch(String buttonName) {
    return topBarTopOptions.stream().filter(op -> op.getAttribute("title").equals(buttonName)).findFirst().isPresent();
  }

  public boolean bottomButtonMatch(String buttonName) {
    return topBarBottomOptions.stream().filter(op -> op.getAttribute("title").equals(buttonName)).findFirst().isPresent();
  }

  public boolean topBarActionMatch(String actionName) {
    return topBarBottomActions.stream().filter(ac -> ac.getAttribute("title").equals(actionName)).findFirst().isPresent();
  }

  public boolean isTopButtonEnable(String buttonName) {
    return topBarTopOptions.stream().filter(op -> op.getAttribute("title").equals(buttonName)).findFirst().get().isEnabled();
  }

  public boolean isBottomButtonEnable(String buttonName) {
    return topBarBottomOptions.stream().filter(op -> op.getAttribute("title").equals(buttonName)).findFirst().get().isEnabled();
  }

  public boolean isTopBarActionEnable(String actionName) {
    return topBarBottomActions.stream().filter(ac -> ac.getAttribute("title").equals(actionName)).findFirst().get().isEnabled();
  }

  public boolean isTopButtonClickable(String buttonName) {
    return isClickable(topBarTopOptions.stream().filter(op -> op.getAttribute("title").equals(buttonName)).findFirst().get()).isDisplayed();
  }

  public boolean isBottomButtonClickable(String buttonName) {
    return isClickable(topBarBottomOptions.stream().filter(op -> op.getAttribute("title").equals(buttonName)).findFirst().get()).isDisplayed();
  }

  public boolean isTopBarActionClickable(String actionName) {
    return isClickable(topBarBottomActions.stream().filter(ac -> ac.getAttribute("title").equals(actionName)).findFirst().get()).isDisplayed();
  }

}
