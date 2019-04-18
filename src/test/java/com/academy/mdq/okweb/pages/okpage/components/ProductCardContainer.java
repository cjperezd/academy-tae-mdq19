package com.academy.mdq.okweb.pages.okpage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductCardContainer extends WebComponent {

    @FindBy(className = "box-grid__item")
    private static List<WebElement> cardContainer;


    private static List<ProductCard> productCardList = new ArrayList<>();

    public ProductCardContainer(WebElement container) {
        super(container);
    }


    public static List<ProductCard> getCardsOnList() {
        cardContainer.forEach(card -> productCardList.add(new ProductCard(card)));
        return productCardList;
    }


}
