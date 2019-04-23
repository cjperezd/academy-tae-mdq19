package com.academy.mdq.okweb.pages.okpage.components.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuContents extends WebComponent {

    @FindBy (className = "navigation-submenu__option-title")
    private List<WebElement> submenuTitles;

    //navigation-submenu__item-content

    public MenuContents(WebElement container) {
        super(container);
    }


    public int getSubmenuListSize(){
        return submenuTitles.size();
    }



}
