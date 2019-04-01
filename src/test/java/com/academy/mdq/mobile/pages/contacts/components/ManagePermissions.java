package com.academy.mdq.mobile.pages.contacts.components;

import com.academy.mdq.mobile.pages.contacts.ContactInformation;
import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ManagePermissions extends MobileComponent {

  @AndroidFindBy(id = "permission_deny_button")
  private MobileElement denyButton;

  @AndroidFindBy(id = "permission_allow_button")
  private MobileElement allowButton;

  @AndroidFindBy(id = "current_page_text")
  private MobileElement quantityTexts;

  public ManagePermissions(MobileElement container) {
    super(container);
  }

  public ContactInformation acceptPermissions() {
    String[] permissionsText = quantityTexts.getText().split(" ");
    int maxPages = Integer.parseInt(permissionsText[2]);
    for (int i = 0; i < maxPages; i++) {
      click(allowButton);
    }
    return new ContactInformation();
  }

}
