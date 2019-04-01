package com.academy.mdq.mobile.pages.contacts.components;

import com.academy.mdq.mobile.pages.contacts.AddContact;
import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LocateContactMessage extends MobileComponent {

  @AndroidFindBy(id = "left_button")
  private MobileElement keepLocalButton;

  @AndroidFindBy(id = "right_button")
  private MobileElement addAccount;

  @AndroidFindBy(id = "content")
  private MobileElement messageContainer;

  public LocateContactMessage(MobileElement container) {
    super(container);
  }

  public AddContact clickKeepLocalButton() {
    click(keepLocalButton);
    return new AddContact();
  }
}
