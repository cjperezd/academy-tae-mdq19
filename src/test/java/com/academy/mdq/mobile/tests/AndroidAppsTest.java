package com.academy.mdq.mobile.tests;

import com.academy.mdq.mobile.pages.CalculatorPage;
import com.academy.mdq.mobile.pages.ClockPage;
import com.academy.mdq.mobile.pages.ContactInfoPage;
import com.academy.mdq.mobile.pages.ContactsHomePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;

public class AndroidAppsTest extends BaseTestSuite {

  @Test
  public void calculatorAdd() {

    float[] numbers = {10000, 5000, 100};
    String expectedResult = "15,100";
    String actualResult = new CalculatorPage().addition(numbers);

    Assert.assertEquals("the result is " + expectedResult, actualResult.equals(expectedResult), true);
  }

  @Test
  public void startChronometer() {

    int waitingSec = 21;
    int finalSec = new ClockPage().selectChrono().pressButton().setWaitingTime(waitingSec).pressButton().getWaitingSec();

    Assert.assertEquals("The time is less than 25 secs", finalSec < 25, true);
  }

  @Test
  public void createContact() {

    String name = "ariana";
    String lastName = "mazzini";
    String number = "1 234-567-89";
    String email = "email@email.com";

    ContactInfoPage info = new ContactsHomePage()
        .addNewContact()
        .keepLocal()
        .addFirstName(name)
        .addLastName(lastName)
        .addNumber(number)
        .addEmail(email)
        .save();

    String fullName = name + " " + lastName;

    Assert.assertEquals("All info of the contact is correct", info.getContactName().equals(fullName) && info.getContactNumber().equals(number) && info.getContactEmail().equals(email), true);

    String finalResult = info.deleteContact().getEntryText();

    Assert.assertEquals("The contact has been deleted" , finalResult.equals("Your contacts list is empty"), true);
  }

}
