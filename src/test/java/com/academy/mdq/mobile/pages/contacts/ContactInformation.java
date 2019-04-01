package com.academy.mdq.mobile.pages.contacts;

import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.isVisible;

public class ContactInformation extends MobilePage {

  @AndroidFindBy(id = "photo_touch_intercept_overlay")
  private MobileElement name;

  @AndroidFindBy(id = "com.android.contacts:id/header")
  private List<MobileElement> information;

  @AndroidFindBy(id = "title")
  private List<MobileElement> moreOptions;

  @AndroidFindBy(id = "button1")
  private MobileElement confirmDeletebutton;

  @AndroidFindBy(id = "More options")
  private MobileElement moreOptionsbutton;

  private MobileElement email;

  private MobileElement phone;

  public String getContactName() {
    return name.getAttribute("contentDescription");
  }

  public String getPhone() {
    return information.get(0).getText();
  }

  public String getEmail() {
    return information.get(1).getText();
  }

  public ContactInformation deleteContact() {
    click(moreOptionsbutton);
    isVisible(moreOptions.get(1));
    click(moreOptions.get(1));
    isVisible(confirmDeletebutton);
    click(confirmDeletebutton);
    return this;
  }

}
