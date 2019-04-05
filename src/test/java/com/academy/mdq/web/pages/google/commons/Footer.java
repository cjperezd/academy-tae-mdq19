package com.academy.mdq.web.pages.google.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.google.About;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer extends WebComponent {

  @FindBy(className = "Q8LRLc")
  private WebElement country;

  @FindBy(className = "Fx4vi")
  private List<WebElement> redirectButtons;

  private WebElement advertisingButton;

  private WebElement businessButton;

  private WebElement aboutButton;

  private WebElement privacyButton;

  private WebElement termsButton;

  private WebElement settingsButton;


  public Footer(WebElement container) {
    super(container);
    privacyButton = redirectButtons.get(0);
    termsButton = redirectButtons.get(1);
    settingsButton = redirectButtons.get(2);
    advertisingButton = redirectButtons.get(3);
    businessButton = redirectButtons.get(4);
    aboutButton = redirectButtons.get(5);
  }

  public About clickAboutButton (){
    click(aboutButton);
    return new About();
  }


}
