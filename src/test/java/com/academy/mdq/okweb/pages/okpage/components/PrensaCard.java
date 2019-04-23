package com.academy.mdq.okweb.pages.okpage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrensaCard extends WebComponent {

    @FindBy (className = "paragraph--small")
    private WebElement date;

    @FindBy (className = ".heading-2,h2.text-align-justify")
    private WebElement title;

    @FindBy (className = ".whynot__block__half__rich-text p:nth-child(3)")
    private WebElement description;

    @FindBy (className = "whynot__block__image")
    private WebElement image;



    public PrensaCard (WebElement container){
        super(container);
    }

    public boolean areElementsVisible(){
        return date.isDisplayed() && title.isDisplayed() && image.isDisplayed() && description.isDisplayed();
    }
}
