package com.academy.mdq.mobile.contacts.components;

import com.academy.mdq.mobile.contacts.application.Contacts;
import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactEditorView extends MobilePage {

    @AndroidFindBy(className = "android.widget.EditText")
    private List<MobileElement> editors;

    @AndroidFindBy (id = "content")
    private MobileElement contactContent;

    @AndroidFindBy (id = "action_bar")
    private MobileElement actionBarComp;

    @AndroidFindBy (id = "toolbar")
        private MobileElement toolbar;

    private MobileElement name;
    private MobileElement lastName;
    private MobileElement phone;
    private MobileElement email;


    ActionBar actionBar = new ActionBar(actionBarComp);
    ContactCustomPanel contactCustomPanel = new ContactCustomPanel(contactContent);


    public void putInElements(){
        name = editors.get(0);
        lastName = editors.get(1);
        phone = editors.get(2);
        name.sendKeys("Juan Cruz");
        lastName.sendKeys("Poli");
        phone.sendKeys("2236098097");
        email = editors.get(4);
        email.sendKeys("juancruzpoli@gmail.com");
    }

    public ContactEditorView clickOnLocal(){
        contactCustomPanel.clickOnKeepLocalButton();
        return this;
    }

    public Contacts clickOnSaveContactButton (){
        getActionBar().clickSave();
        return new Contacts();
    }

    public ActionBar getActionBar(){
        return new ActionBar(toolbar);
    }
}
