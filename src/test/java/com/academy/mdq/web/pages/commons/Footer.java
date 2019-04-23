package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.footer.Press;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends WebComponent {

  @FindBy(css=".footer-menu__top .menu-item [data-drupal-link-system-path='node/1241']")
  private WebElement workWithUsButton;

  @FindBy(css=".footer-menu__top .menu-item [data-drupal-link-system-path='node/837']")
  private WebElement pressButton;

  @FindBy(css=".footer-menu__top .menu-item [data-drupal-link-system-path='node/142']")
  private WebElement legalNoticeButton;

  @FindBy(css=".footer-menu__top .menu-item [data-drupal-link-system-path='node/143']")
  private WebElement privacyButton;

  @FindBy(css=".footer-menu__top .menu-item [data-drupal-link-system-path='node/147']")
  private WebElement legalInfoButton;

  @FindBy(css=".footer-menu__top .menu-item [data-drupal-link-system-path='node/146']")
  private WebElement SecurityButton;

  public Footer(WebElement container) {
    super(container);
  }

  public Press clickPress(){
    click(pressButton);
    return new Press();
  }
}
