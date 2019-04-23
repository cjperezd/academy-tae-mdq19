package com.academy.mdq.okweb.pages.okpage.components;


import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationMenuLeftContents extends WebComponent {

    @FindBy(css = ".navigation-submenu__option-title")
    private List<WebElement> sections;


    public NavigationMenuLeftContents(WebElement container) {
        super(container);
    }

    public String getSectionText(int idx) {
        return sections.get(idx).getText();
    }

    public NavigationMenuLeftContents clickSection(int idx) {
        clickList(sections,idx);
        return this;
    }

    public int getSectionsSize() {
        return sections.size();
    }

}
