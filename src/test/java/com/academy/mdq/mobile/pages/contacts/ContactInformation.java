package com.academy.mdq.mobile.pages.contacts;

import com.academy.mdq.page.mobile.MobilePage;
import com.academy.mdq.waits.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;

public class ContactInformation extends MobilePage {

  @AndroidFindBy(id = "photo_touch_intercept_overlay")
  private MobileElement name;

  @AndroidFindBy(id = "com.android.contacts:id/header")
  private List<MobileElement> information;

  @AndroidFindBy(id="title")
  private List<MobileElement> moreOptions;

  @AndroidFindBy(id="button1")
  private MobileElement confirmDeletebutton;

  private MobileElement email;
  private MobileElement phone;

  @AndroidFindBy(id="More options")
  private MobileElement moreOptionsbutton;


  public String getContactName() {
    return name.getAttribute("contentDescription");
  }

  public String getPhone() {
    return information.get(0).getText();
  }

  public String getEmail() {
    return information.get(1).getText();
  }

  public ContactInformation deleteContact ()
  {
    click(moreOptionsbutton);
    Waits.isVisible(moreOptions.get(1));
    click(moreOptions.get(1));
    Waits.isVisible(confirmDeletebutton);
    click(confirmDeletebutton);
    return this;
  }

}
