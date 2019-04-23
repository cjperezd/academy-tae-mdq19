package com.academy.mdq.okweb.pages.okpage.okpages;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HipotecaOpenPage extends WebPage {

    @FindBy(id = "block-contenidodelapaginaprincipal")
    private WebElement bigBanner;

    @FindBy(className = "small-banner--center")
    private WebElement smallBanner;

    @FindBy(className = "button")
    private List<WebElement> minibannerButton;

    @FindBy(id = "advantages-and-risk-149")
    private WebElement riskContainer;

    HomePage homePage;

    public HipotecaOpenPage() {
        this.homePage = new HomePage();

    }

    public boolean areBannersVisible() {
        return bigBanner.isDisplayed() && smallBanner.isDisplayed();
    }

    public boolean isMinibannerButtonVisible(int idx) {
        return minibannerButton.get(idx).isDisplayed();
    }

    public HomePage getHomePage() {
        return this.homePage;
    }
}