package com.academy.mdq.okweb.pages.okpage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpCards extends WebComponent {



    @FindBy (className = "box-grid__item__small-image")
    private WebElement smallImage;

    @FindBy (className = "box-grid__item__title")
    private WebElement title;

    @FindBy (className = "phone")
    private WebElement phone;

    public HelpCards (WebElement container){
        super(container);
    }

    public boolean areContentVisible(){
        return smallImage.isDisplayed() && title.isDisplayed() && phone.isDisplayed();
    }

    
}
