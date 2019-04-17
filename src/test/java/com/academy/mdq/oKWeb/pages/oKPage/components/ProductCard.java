package com.academy.mdq.oKWeb.pages.oKPage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends WebComponent {

    public ProductCard(WebElement container) {
        super(container);
    }

    @FindBy(className = "img-responsive")  //For clicking...
    private WebElement image;


    @FindBy(className = "box-grid__item__title")
    private WebElement cardTitle;

    @FindBy(className = "box-grid__item__content__description")
    private WebElement cardDescription;


    public String getCardTitle() {
        return cardTitle.getText();
    }

    public WebElement getImage() {
        return image;
    }

    public WebElement getCardDescription() {
        return cardDescription;
    }
}
