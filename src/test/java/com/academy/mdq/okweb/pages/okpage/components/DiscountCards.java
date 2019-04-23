package com.academy.mdq.okweb.pages.okpage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscountCards extends WebComponent {

    @FindBy (className = "title")
    private WebElement title;

    @FindBy (className = "description")
    private WebElement description;

    @FindBy (className = "discount_category__button")
    private WebElement categoryButton;

    public DiscountCards (WebElement container){
        super(container);
    }


    public boolean areCardElementsVisible(){
        return title.isDisplayed() && description.isDisplayed() && categoryButton.isDisplayed();
    }






}
