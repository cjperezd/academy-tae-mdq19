package com.academy.mdq.mobile.pages.contacts;

import com.academy.mdq.mobile.pages.contacts.components.LocateContactMessage;
import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Contacts extends MobilePage {

  @AndroidFindBy(id = "floating_action_button")
  private MobileElement addContactsFloatingButton;

  @AndroidFindBy(id = "content")
  private MobileElement selectLocationContactSign;

  public LocateContactMessage clickAddContactsFloatingButton() {
    click(addContactsFloatingButton);
    return new LocateContactMessage(selectLocationContactSign);
  }

}
