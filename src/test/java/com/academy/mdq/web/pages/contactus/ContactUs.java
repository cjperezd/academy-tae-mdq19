package com.academy.mdq.web.pages.contactus;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.contactus.components.PhoneOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ContactUs extends WebPage {

  @FindBy(className = "featured-information--white ")
  private List<WebElement> phoneOptionsContainers;

  private final List<PhoneOption> phoneOptions = new ArrayList<>();

  public ContactUs() {
    phoneOptionsContainers.forEach(cont->phoneOptions.add(new PhoneOption(cont)));
  }

  public List<PhoneOption> getPhoneOptions(){
    return phoneOptions;
  }
}
