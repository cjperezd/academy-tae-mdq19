package com.academy.mdq.okweb.pages.okpage.components.commons;

import com.academy.mdq.okweb.pages.okpage.okpages.HelpPage;
import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopBar extends WebComponent {

    @FindBy(className = "openbank-topbar__language")
    private WebElement toolbarLanguage;

    @FindBy(className = "language-switcher")
    private WebElement languageSelector;

    @FindBy(className = "language-switcher-item")
    private List<WebElement> languageOptions;

    @FindBy(css = ".openbank-topbar__utility__item a")
    private List<WebElement> topBarElements;

    @FindBy(className = "icon-ayuda-urgente")
    private WebElement iconoAyudaUrgente;

    private String helpUrl = "https://www.openbank.es/ayuda-urgente";
    private String contactUrl = "https://www.openbank.es/contacto";
    private String FAQUrl = "https://www.openbank.es/ayuda";
    private String ATMUrl = "https://www.openbank.es/cajeros-oficinas";

    public TopBar(WebElement container) {
        super(container);
    }


    public boolean areTopbarElementsCorrect() {
        return helpUrl.equals(topBarElements.get(0).getAttribute("href")) && contactUrl.equals(topBarElements.get(1).getAttribute("href"))
                && FAQUrl.equals(topBarElements.get(2).getAttribute("href")) && ATMUrl.equals(topBarElements.get(3).getAttribute("href"));
    }

    public TopBar clickLanguageSelector() {
        click(languageSelector);
        return this;
    }

    public TopBar clickLanguage() {
        click(languageOptions.get(1));
        return this;
    }

    public String getText(int idx) {
        return topBarElements.get(idx).getText();
    }

    public int getWebElementsSize() {
        return topBarElements.size();
    }

    public boolean isAyudaUrgenteVisible() {
        return helpUrl.equals(topBarElements.get(0).getAttribute("href")) && iconoAyudaUrgente.isDisplayed() && topBarElements.get(0).isDisplayed();
    }

    public HelpPage clickHelp() {
        click(iconoAyudaUrgente);
        return new HelpPage();
    }
}
