package com.academy.mdq.okweb.pages.okpage.components;

import com.academy.mdq.okweb.pages.okpage.okpages.DepositOpenPage;
import com.academy.mdq.okweb.pages.okpage.okpages.HipotecaOpenPage;
import com.academy.mdq.okweb.pages.okpage.okpages.OpenSolidarioPage;
import com.academy.mdq.okweb.pages.okpage.okpages.PrestamosyCreditosPage;
import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationMenuRightContents extends WebComponent {

    @FindBy(className = "navigation-submenu__header")
    private WebElement menuHeader;

    @FindBy(css = "a.navigation-section__title")
    private List<WebElement> menuInternSections;

    @FindBy(css = "a.navigation-section__title[title=\"Open Solidario\"]")
    private WebElement openSolidarioSection;

    @FindBy(css = "a.navigation-section__title[title=\"Depósito Open 13 meses \"]")
    private WebElement depositOpenSection;

    @FindBy(css = "a.navigation-section__title[title=\"Hipotecas Open\"]")
    private WebElement hipotecasSection;

    @FindBy (css = "a.navigation-section__title[title=\"Préstamos y Créditos\"]")
    private WebElement prestamosyCreditosSection;




    public NavigationMenuRightContents(WebElement container) {
        super(container);
    }

    public String menuHeaderGetText() {
        return menuHeader.getText();
    }

    public boolean isopenSolidarioUrlRight(String url){
        return url.equals(openSolidarioSection.getAttribute("href"));
    }

    public boolean isDepositOpenUrlRight(String url){
        return url.equals(depositOpenSection.getAttribute("href"));
    }

    public boolean isHipotecaOpenUrlRight(String url){
        return url.equals(hipotecasSection.getAttribute("href"));
    }

    public boolean isPrestamosyCreditosUrlRight(String url){
        return url.equals(prestamosyCreditosSection.getAttribute("href"));
    }

    public OpenSolidarioPage clickOpenSolidario(){
        click(openSolidarioSection);
        return new OpenSolidarioPage();
    }

    public DepositOpenPage clickDepositOpenSection(){
        click(depositOpenSection);
        return new DepositOpenPage();
    }

    public HipotecaOpenPage clickHipotecasOpenSection(){
        click(hipotecasSection);
        return new HipotecaOpenPage();
    }

    public PrestamosyCreditosPage clickPrestamosyCreditosSection(){
        click(prestamosyCreditosSection);
        return new PrestamosyCreditosPage();
    }





}
