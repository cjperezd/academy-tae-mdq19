package com.academy.mdq.okweb.pages.okpage.components.commons;

import com.academy.mdq.okweb.pages.okpage.components.Login;
import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.driver.Drivers.getDriver;

public class SectionsBar extends WebComponent {


    @FindBy(className = "openbank-topbar__actions__become")
    private WebElement register;

    @FindBy(className = "openbank-topbar__actions__access")
    private WebElement login;

    @FindBy(css = ".navigation-menu__item.menu-item.menu-item")
    private List<WebElement> sections;

    @FindBy(css = "#ok-topbar-container > nav > div.openbank-topbar__layout > div.openbank-topbar__bottom > div > div.openbank-topbar__main-menu > ul > li:nth-child(3) > a")
    private WebElement whoWeAre;

    @FindBy(className = "navigation-menu__item-content")
    private List<WebElement> navigationMenuList;

    private MenuContents menuContents;
    private String whoWeAreUrl = "https://www.openbank.es/quienes-somos";
    private String registerUrl = "https://www.openbank.es/hazte-cliente";


    public SectionsBar(WebElement container) {
        super(container);
        this.menuContents = new MenuContents(navigationMenuList.get(0));
    }


    public int navigationMenuListSize() {
        return navigationMenuList.size();
    }

    public boolean isRegisterAttributeRight() {
        return registerUrl.equals(register.getAttribute("href"));
    }

//    public boolean isLoginContentDisplayed() {
//        click(login);
//        return getDriver().getWebDriver().findElement(By.id("secLog")).isDisplayed();
//    }


    public boolean isContentDisplayed(int idx) {
        click(sections.get(idx));
        return navigationMenuList.get(idx).isDisplayed();
    }

    public boolean isWhoWeAreAttributeRight() {
        return whoWeAreUrl.equals(whoWeAre.getAttribute("href"));
    }

    public String getSectionsTexts(int idx) {
        return sections.get(idx).getText();
    }

    public int getOptionsSize() {
        return sections.size();
    }

    public boolean isCorrectLoginName() {
        return getLoginText().contains("Área Clientes") || getLoginText().contains("Login");
    }

    public boolean isCorrectRegisterName() {
        return getRegisterText().contains("Hazte Cliente") || getRegisterText().contains("Register");
    }

    public boolean areButtonsDisplayed(int idx) {
        return sections.get(idx).isDisplayed();
    }

    public boolean areAccountBottonsDisplayed() {
        return register.isDisplayed() && login.isDisplayed();
    }

    public MenuContents getMenuContents(){
        return this.menuContents;
    }

    private String getRegisterText() {
        return register.getText();
    }

    private String getLoginText() {
        return login.getText();
    }



}
