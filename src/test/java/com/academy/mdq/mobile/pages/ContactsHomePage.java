package com.academy.mdq.mobile.pages;

import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class ContactsHomePage extends MobilePage {

  @AndroidFindBy(id = "floating_action_button_container")
  private MobileElement newContactButton;

  @AndroidFindBy(id = "message")
  private MobileElement entryTitle;

  public EditContactPage addNewContact() {
    click(newContactButton);
    return new EditContactPage();
  }

  public String getEntryText() {
    return isVisible(entryTitle).getText();
  }

}
