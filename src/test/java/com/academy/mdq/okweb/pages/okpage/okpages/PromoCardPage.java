package com.academy.mdq.okweb.pages.okpage.okpages;

import com.academy.mdq.okweb.pages.okpage.components.commons.SectionsBar;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PromoCardPage extends WebPage {

    @FindBy(className = "openbank-topbar__bottom")
    private WebElement sectionsBarContainer;

    @FindBy(id = "block-contenidodelapaginaprincipal")
    private WebElement bigBanner;

    @FindBy(className = "small-banner--center")
    private WebElement smallBanner;

    @FindBy(className = "button")
    private List<WebElement> minibannerButton;

    public PromoCardPage (){

    }

    public boolean areElementsVisible(int idx){
        return bigBanner.isDisplayed() && smallBanner.isDisplayed() && minibannerButton.get(idx).isDisplayed();
    }

    public SectionsBar getSectionBar(){
        return new SectionsBar(sectionsBarContainer);
    }
}
