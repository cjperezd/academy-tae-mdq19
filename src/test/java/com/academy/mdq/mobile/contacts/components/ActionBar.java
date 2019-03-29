package com.academy.mdq.mobile.contacts.components;

import com.academy.mdq.mobile.contacts.application.Contacts;
import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ActionBar extends MobileComponent {

    public ActionBar(MobileElement container) {
        super(container);
    }

    @AndroidFindBy (id = "editor_menu_save_button")
        private  MobileElement saveContact;

    @AndroidFindBy  (accessibility = "Navigate Up")
        private  MobileElement moveBack;


    public ActionBar clickSave (){
        click(saveContact);
        return this;
    }


}
