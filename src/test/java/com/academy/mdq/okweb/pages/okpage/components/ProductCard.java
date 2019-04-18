package com.academy.mdq.okweb.pages.okpage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(className = "box-grid__item")
    private List<WebElement> cardContainer;


    public String getCardTitle() {
        return cardTitle.getText();
    }

    public ProductCard clickOnCard(int idx) {
        click(ProductCardContainer.getCardsOnList().get(idx).image);
        return this;
    }

    public String getCardName(int idx) {
        return ProductCardContainer.getCardsOnList().get(idx).getCardTitle();
    }
}
