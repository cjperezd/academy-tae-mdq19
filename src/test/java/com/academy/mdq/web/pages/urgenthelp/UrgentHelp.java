package com.academy.mdq.web.pages.urgenthelp;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.urgenthelp.components.ContactOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UrgentHelp extends WebPage {
  @FindBy(className = "heading-1--content")
  private WebElement pageTitle;

  @FindBy(className = "contact__communications__title")
  private WebElement contactTitle;

  @FindBy(className = "box-grid__item--rounded")
  List<WebElement> contactOptionsContainers;

  private final List<ContactOption> contactOptions = new ArrayList<>();

  public UrgentHelp() {
    contactOptionsContainers.forEach(cont -> contactOptions.add(new ContactOption(cont)));
  }

  public boolean isVisiblePageTitle() {
    return pageTitle.isDisplayed();
  }

  public boolean isVisibleContactTitle() {
    return contactTitle.isDisplayed();
  }

  public String getPageTitle(){
    return pageTitle.getText().toLowerCase();
  }

  public List<ContactOption> getContactOptions(){
    return contactOptions;
  }


}
