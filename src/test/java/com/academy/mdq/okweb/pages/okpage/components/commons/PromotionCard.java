package com.academy.mdq.okweb.pages.okpage.components.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PromotionCard extends WebComponent {

    @FindBy (className = "title")
    private WebElement cardTitle;


    public PromotionCard(WebElement container) {
        super(container);
    }


    public String getTitle(){
        return cardTitle.getText();
    }
}
