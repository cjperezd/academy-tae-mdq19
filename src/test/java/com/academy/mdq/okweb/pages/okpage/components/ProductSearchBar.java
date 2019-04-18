package com.academy.mdq.okweb.pages.okpage.components;

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

    @FindBy(className = "typewriter-animation")
    private WebElement typeAnimation;

    private String noExists = "Libros";
    private String exists = "Fondos de inversión";

    private String noExistsEN = "Foots";
    private String existsEN = "Investment Funds";



    public ProductSearchBar clickOnSearchButton() {
        click(searchButton);
        return this;
    }

    public ProductSearchBar clickOnNoSearchButton() {
        click(noSearchButton);
        return this;
    }

    public String getInputTextAnimation() {
        //scrollTo();
        return typeAnimation.getText();
    }

    public ProductSearchBar typeNoExistsProduct() {
        type(productInput, noExists);
        return this;
    }

    public ProductSearchBar typeExistsProduct() {
        type(productInput, exists);
        return this;
    }

    public ProductSearchBar typeNoExistsProductEN() {
        type(productInput, noExistsEN);
        return this;
    }

    public ProductSearchBar typeExistsProductEN() {
        type(productInput, existsEN);
        return this;
    }

}
