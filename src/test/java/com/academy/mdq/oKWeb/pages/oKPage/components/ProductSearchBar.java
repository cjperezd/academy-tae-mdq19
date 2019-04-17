package com.academy.mdq.oKWeb.pages.oKPage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearchBar extends WebComponent {

    public ProductSearchBar(WebElement container) {
        super(container);
    }


    @FindBy(className = "product-search__search__input")
    private static WebElement productInput;

    @FindBy(className = "button--search")
    private WebElement searchButton;

    @FindBy(className = "button--clear")
    private WebElement noSearchButton;

    @FindBy (className = "autocomplete-list")
    private WebElement autocompleteTextButton;

    @FindBy (id = "product-search")
    private WebElement searchContainer;

    @FindBy(className = "typewriter-animation")
    private WebElement typeAnimation;



    public WebElement getProductInput() {
        return productInput;
    }


    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getNoSearchButton() {
        return noSearchButton;
    }

    public WebElement getAutocompleteTextButton(){
        return autocompleteTextButton;
    }

    public WebElement getSearchContainer() {
        return searchContainer;
    }

    public WebElement getTypeAnimation() {
        return typeAnimation;
    }
}
