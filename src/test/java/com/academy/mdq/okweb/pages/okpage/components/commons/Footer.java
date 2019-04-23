package com.academy.mdq.okweb.pages.okpage.components.commons;

import com.academy.mdq.okweb.pages.okpage.okpages.PrensaPage;
import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends WebComponent {

    @FindBy(className = "footer-menu__top__logo")
    private WebElement footerLogo;

    @FindBy(css = "a[title=\"Trabaja con nosotros\"]")
    private WebElement workWithUs;

    @FindBy(css = "a[title=\"Prensa\"]")
    private WebElement prensa;

    @FindBy(css = "a[title=\"Aviso Legal\"]")
    private WebElement avisoLegal;

    @FindBy(css = "a[title=\"Politica de Privacidad / Cookies\"]")
    private WebElement cookiesAndPrivacity;

    @FindBy(css = "a[data-drupal-link-system-path=\"node/147\"]")
    private WebElement legal;

    @FindBy(css = "a[data-drupal-link-system-path=\"node/146\"]")
    private WebElement security;

    public Footer(WebElement container) {
        super(container);
    }


    public boolean areElementsVisible(){
        return footerLogo.isDisplayed() && workWithUs.isDisplayed() && prensa.isDisplayed() && avisoLegal.isDisplayed() && cookiesAndPrivacity.isDisplayed() &&
                legal.isDisplayed() && security.isDisplayed();
    }

    public PrensaPage clickPrensa(){
        click(prensa);
        return new PrensaPage();
    }


}
