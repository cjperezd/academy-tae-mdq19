package com.academy.mdq.mobile.tests.contacts;

import com.academy.mdq.mobile.pages.contacts.ContactInformation;
import com.academy.mdq.mobile.pages.contacts.Contacts;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactsTest extends BaseTestSuite {

  private static final String NAME = "Lucia Corrales";
  private static final String PHONE = "(223) 455-2613";
  private static final String EMAIL = "corraleslucia@gmail.com";

  @Test
  public void addContactTest() {
    ContactInformation contactCard = new Contacts()
        .clickAddContactsFloatingButton()
        .clickKeepLocalButton()
        .typeName(NAME)
        .typePhone(PHONE)
        .typeEmail(EMAIL)
        .saveContact();

    assertEquals(NAME, contactCard.getContactName());
    assertEquals(PHONE, contactCard.getPhone());
    assertEquals(EMAIL, contactCard.getEmail());

    contactCard.deleteContact();
  }

}
