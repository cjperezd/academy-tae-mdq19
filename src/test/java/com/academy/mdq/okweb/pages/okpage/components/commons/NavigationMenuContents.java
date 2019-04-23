package com.academy.mdq.okweb.pages.okpage.components.commons;

import com.academy.mdq.okweb.pages.okpage.components.NavigationMenuLeftContents;
import com.academy.mdq.okweb.pages.okpage.components.NavigationMenuRightContents;
import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationMenuContents extends WebComponent {

    @FindBy(className = "navigation-submenu")
    private List<WebElement> navigationMenuContentLeft;

    @FindBy(className = "navigation-submenu__item-content")
    private List<WebElement> navigatonMenuContentRight;

    private NavigationMenuLeftContents navigationMenuLeftContents;
    private NavigationMenuRightContents navigationMenuRightContents;

    public NavigationMenuContents(WebElement container) {
        super(container);
        this.navigationMenuLeftContents = new NavigationMenuLeftContents(navigationMenuContentLeft.get(0));

        //TODO: Quitar el new de este lugar y hacerlo por cada vez que clickeo en la correspondiente seccion
        this.navigationMenuRightContents = new NavigationMenuRightContents(navigatonMenuContentRight.get(0));
    }


    public NavigationMenuLeftContents getNavigationMenuLeftContents(int idx) {
        setNavigationMenuRightContent(idx);
        return navigationMenuLeftContents;
    }

    public NavigationMenuLeftContents getNavigationMenuLeftContentsForSize(){
        return navigationMenuLeftContents;
    }

    public NavigationMenuRightContents getNavigationMenuRightContents() {
        return navigationMenuRightContents;
    }

    public boolean areTheSameTexts(int idx){
        return navigationMenuLeftContents.getSectionText(idx).equals(navigationMenuRightContents.menuHeaderGetText());
    }

    private NavigationMenuRightContents setNavigationMenuRightContent(int idx){
        return this.navigationMenuRightContents = new NavigationMenuRightContents(navigatonMenuContentRight.get(idx));
    }


}
