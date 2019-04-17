package com.academy.mdq.oKWeb.pages.oKPage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFullCard extends WebComponent {

    public ProductFullCard(WebElement container) {
        super(container);
    }


    @FindBy(className = "box-grid__item__title")
    private WebElement title;
    @FindBy(className = "close-icon")
    private WebElement closeButton;


    public String getTitle() {
        return title.getText();
    }

    public WebElement getCloseButton() {
        return closeButton;
    }
}
