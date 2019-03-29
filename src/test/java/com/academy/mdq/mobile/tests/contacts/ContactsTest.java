package com.academy.mdq.mobile.tests.contacts;

import com.academy.mdq.mobile.pages.contacts.AddContact;
import com.academy.mdq.mobile.pages.contacts.ContactInformation;
import com.academy.mdq.mobile.pages.contacts.Contacts;
import com.academy.mdq.mobile.pages.contacts.components.LocateContactMessage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;

public class ContactsTest extends BaseTestSuite {

  private String name = "Lucia Corrales";
  private String phone = "(223) 455-2613";
  private String email = "corraleslucia@gmail.com";

  @Test
  public void addContactTest() {
    Contacts contacts = new Contacts();

    LocateContactMessage locateMessage = contacts.clickAddContactsFloatingButton();

    AddContact addContact = locateMessage.clickKeepLocalButton()
        .typeName(name)
        .typePhone(phone)
        .typeEmail(email);

    ContactInformation contactCard = addContact.saveContact();

    Assert.assertEquals(name, contactCard.getContactName());
    Assert.assertEquals(phone, contactCard.getPhone());
    Assert.assertEquals(email, contactCard.getEmail());

    contactCard.deleteContact();


  }


}
