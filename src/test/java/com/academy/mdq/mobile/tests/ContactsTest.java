package com.academy.mdq.mobile.tests;

import com.academy.mdq.mobile.contacts.application.Contacts;
import com.academy.mdq.mobile.contacts.components.ContactEditorView;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;

public class ContactsTest extends BaseTestSuite {

    private static final String name = "Juan Cruz Poli";
    private static final String number = "(223) 609-8097";
    private static final String email = "juancruzpoli@gmail.com";

    @Test
    public void myTest() throws InterruptedException {


        Contacts contacts = new Contacts();

        ContactEditorView contactEditorView = contacts.clickOnAddContact();
        contactEditorView.clickOnLocal();
        contactEditorView.putInElements();
        Contacts contactSecondPage = contactEditorView.clickOnSaveContactButton();
        //System.out.println("Name: " +contactSecondPage.getName());
        Assert.assertTrue(contactSecondPage.isTheSameName(name));
        Assert.assertTrue(contactSecondPage.isTheSameNumber(number));
        Assert.assertTrue(contactSecondPage.isTheSameEmail(email));
    }
}
