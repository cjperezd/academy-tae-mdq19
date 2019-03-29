package com.academy.mdq.mobile.contacts.components;

import com.academy.mdq.mobile.contacts.application.Contacts;
import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ContactCustomPanel extends MobileComponent {

    public ContactCustomPanel(MobileElement container) {
        super(container);
    }

    @AndroidFindBy (id = "left_button")
        private MobileElement keepLocalButton;

    @AndroidFindBy (id = "right_button")
        private MobileElement addAccountButton;




    public void clickOnKeepLocalButton(){
        click(keepLocalButton);
    }
}
