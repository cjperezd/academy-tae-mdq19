package com.academy.mdq.mobile.pages.contacts;

import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class AddContact extends MobilePage {
  @AndroidFindBy(className = "android.widget.EditText")
  private List<MobileElement> listInputs;

  @AndroidFindBy(id = "more_fields")
  private MobileElement moreFieldsButton;

  @AndroidFindBy(id = "editor_menu_save_button")
  private MobileElement saveContact;

  @AndroidFindBy(id = "dialog_container")
  private MobileElement allowPermissionsContainer;

  private MobileElement nameInput;

  private MobileElement phoneInput;

  private MobileElement emailInput;

  public AddContact() {
    super();
    nameInput = listInputs.get(0);
    phoneInput = listInputs.get(2);
  }

  public AddContact typeName(String name) {
    nameInput.sendKeys(name);
    return this;
  }

  public AddContact typePhone(String phone) {
    phoneInput.sendKeys(phone);
    return this;
  }

  public AddContact typeEmail(String email) {
    emailInput = listInputs.get(4);
    emailInput.sendKeys(email);
    return this;
  }

  public ContactInformation saveContact() {
    click(saveContact);
    return new ContactInformation();
  }

}
