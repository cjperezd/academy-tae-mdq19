package com.academy.mdq.mobile.pages.complements;

import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AllowMessage extends MobileComponent {

  @AndroidFindBy(id = "permission_deny_button")
  private MobileElement denyButton;

  @AndroidFindBy(id = "permission_allow_button")
  private MobileElement allowButton;

  public AllowMessage(MobileElement container) {
    super(container);
  }

  public void allow() {
    click(allowButton);
  }

  public void deny() {
    click(denyButton);
  }

}
