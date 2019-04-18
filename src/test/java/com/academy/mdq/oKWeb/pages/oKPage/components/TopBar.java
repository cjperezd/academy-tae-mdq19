package com.academy.mdq.oKWeb.pages.oKPage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopBar extends WebComponent {

    public TopBar(WebElement container) {
        super(container);
    }


    @FindBy (className = "openbank-topbar__language")
    private WebElement toolbarLanguage;

    @FindBy (className = "language-switcher")
    private WebElement languageSelector;

    @FindBy (className = "language-switcher-item")
    private List<WebElement> languageOptions;



    public TopBar clickLanguageSelector() {
        click(languageSelector);
        return this;
    }

    public TopBar clickLanguage() {
        click(languageOptions.get(1));
        return this;
    }
}
