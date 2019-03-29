package com.academy.mdq.mobile.contacts.application;

import com.academy.mdq.mobile.contacts.components.AddNewContact;
import com.academy.mdq.mobile.contacts.components.ContactEditorView;
import com.academy.mdq.page.mobile.MobilePage;
import com.academy.mdq.waits.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class Contacts extends MobilePage {

    @AndroidFindBy (id = "floating_action_button")
        private MobileElement addContactButton;

    @AndroidFindBy (id = "raw_contacts_editor_view")
        private MobileElement contactEditorViewContainer;

    @AndroidFindBy (accessibility = "Name")
        private  MobileElement photoNameIcon;

    @AndroidFindBy (id = "photo_touch_intercept_overlay")
            private MobileElement contactName;

    @AndroidFindBy (id = "icon_alternate")
            private MobileElement numberExtract;

    @AndroidFindBy (className = "android.widget.TextView")
            private List<MobileElement> listOfViews;

    AddNewContact addNewContact = new AddNewContact(addContactButton);


    public ContactEditorView clickOnAddContact(){
        click(addContactButton);
        return new ContactEditorView();
    }


    public boolean isTheSameName(String name){
        Waits.isVisible(contactName);
        return contactName.getAttribute("contentDescription").equals(name);
    }


    public boolean isTheSameNumber (String number){
        String numberView = listOfViews.get(2).getAttribute("text");
        return numberView.equals(number);
    }


    public boolean isTheSameEmail (String email){
        String emailView = listOfViews.get(4).getText();
        return emailView.equals(email);
    }

    public String getName(){
        Waits.isVisible(contactName);
        return contactName.getAttribute("contentDescription");
    }
}
