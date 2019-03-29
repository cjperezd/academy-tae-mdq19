package com.academy.mdq.mobile.pages;

import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.isVisible;

public class ContactInfoPage extends MobilePage {

  @AndroidFindBy(id = "photo_touch_intercept_overlay")
  private MobileElement titleFrame;

  @AndroidFindBy(id = "header")
  private List<MobileElement> infoTitles;

  @AndroidFindBy(id = "More options")
  private MobileElement optionsButton;

  @AndroidFindBy(id = "title")
  private List<MobileElement> listOfOptions;

  @AndroidFindBy(id = "button1")
  private MobileElement deleteButton;

  public String getContactName() {
    return titleFrame.getAttribute("contentDescription");
  }

  public String getContactNumber() {
    return infoTitles.get(0).getText();
  }

  public String getContactEmail() {
    return infoTitles.get(1).getText();
  }

  public ContactsHomePage deleteContact() {
    click(optionsButton);
    click(listOfOptions.get(1));
    click(isVisible(deleteButton));
    return new ContactsHomePage();
  }

}
