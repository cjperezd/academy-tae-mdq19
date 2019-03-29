package com.academy.mdq.mobile.pages;

import com.academy.mdq.page.mobile.MobilePage;
import com.academy.mdq.waits.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class EditContactPage extends MobilePage {

  @AndroidFindBy(id = "raw_contacts_editor_view")
  private MobileElement inputsConteiner;

  @AndroidFindBy(className = "android.widget.EditText")
  private List<MobileElement> inputs;

  @AndroidFindBy(id = "editor_menu_save_button")
  private MobileElement saveButton;

  @AndroidFindBy(id = "dialog_container")
  private MobileElement allowContainer;

  @AndroidFindBy(id = "content")
  private MobileElement messagePopUp;

  @AndroidFindBy(id = "left_button")
  private MobileElement cancelButton;

  public EditContactPage keepLocal() {
    Waits.isVisible(messagePopUp);
    click(cancelButton);
    Waits.isVisible(inputsConteiner);
    return this;
  }

  public EditContactPage addFirstName(String name) {
    if(inputs.size()>0) {
      click(inputs.get(0));
      inputs.get(0).sendKeys(name);
    }
    return this;
  }

  public EditContactPage addLastName(String lastName) {
    if(inputs.size()>0) {
      click(inputs.get(1));
      inputs.get(1).sendKeys(lastName);
    }
    return this;
  }

  public EditContactPage addNumber(String number) {
    if(inputs.size()>0) {
        click(inputs.get(2));
        inputs.get(2).sendKeys(number);
    }
    return this;
  }

  public EditContactPage addEmail(String email) {
    if(inputs.size()>0) {
      click(inputs.get(4));
      inputs.get(4).sendKeys(email);
    }
    return this;
  }

  public ContactInfoPage save() {
    click(saveButton);
    return  new ContactInfoPage();
  }

}
