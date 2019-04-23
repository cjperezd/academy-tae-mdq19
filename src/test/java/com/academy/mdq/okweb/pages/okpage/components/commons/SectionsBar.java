package com.academy.mdq.okweb.pages.okpage.components.commons;

import com.academy.mdq.okweb.pages.okpage.okpages.PromotionAndDiscountsPage;
import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(className = "navigation-submenu__item")
    private List<WebElement> navigationPromotionsSection;

    private MenuContents menuContents;
    private String whoWeAreUrl = "https://www.openbank.es/quienes-somos";
    private String registerUrl = "https://www.openbank.es/hazte-cliente";


    public SectionsBar(WebElement container) {
        super(container);
        this.menuContents = new MenuContents(navigationMenuList.get(0));
    }


    public SectionsBar clickOnProducts() {
        click(sections.get(0));
        return this;
    }

    public SectionsBar clickOnPromotionsAndDiscounts() {
        click(sections.get(1));
        return this;
    }

    public PromotionAndDiscountsPage clickPromotionAndDiscounts(){
        click(navigationPromotionsSection.get(6));
        return new PromotionAndDiscountsPage();
    }


    public int navigationMenuListSize() {
        return navigationMenuList.size();
    }

    public boolean isRegisterAttributeRight() {
        return registerUrl.equals(register.getAttribute("href"));
    }


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

    public MenuContents getMenuContents() {
        return this.menuContents;
    }

    private String getRegisterText() {
        return register.getText();
    }

    private String getLoginText() {
        return login.getText();
    }


}
