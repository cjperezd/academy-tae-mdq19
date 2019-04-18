package com.academy.mdq.okweb.pages.okpage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@FindBy(id = "secLog")
public class Login extends WebComponent {

    @FindBy (className = "ok-login__background")
    private WebElement loginBackground;

    public boolean isBackgroundVisible(){
        return loginBackground.isDisplayed();
    }

}
