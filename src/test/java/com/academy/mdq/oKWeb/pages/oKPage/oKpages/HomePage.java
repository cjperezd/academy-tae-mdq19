package com.academy.mdq.oKWeb.pages.oKPage.oKpages;

import com.academy.mdq.oKWeb.pages.oKPage.components.ProductCard;
import com.academy.mdq.oKWeb.pages.oKPage.components.ProductFullCard;
import com.academy.mdq.oKWeb.pages.oKPage.components.ProductSearchBar;
import com.academy.mdq.oKWeb.pages.oKPage.components.TopBar;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends WebPage {


    @FindBy(className = "box-grid__item")
    private List<WebElement> cardContainer;

    @FindBy(className = "box-grid__item")
    private WebElement oneCardContainer;

    @FindBy(className = "product-search__search")
    private WebElement productSearchbarContainer;

    @FindBy(id = "product-search-fullcard")
    private List<WebElement> fullCardContainerList;

    @FindBy(className = "box-grid__item--expanded")
    private WebElement fullCardContainer;

    @FindBy(className = "field--name-field-empty-result-message")
    private WebElement resultSearchNoExistText;

    @FindBy(className = "cookies-policy__close-icon")
    private WebElement cookiesCloseButton;

    @FindBy(className = "openbank-topbar__top")
    private WebElement toolbarContainer;

    private String noExists = "Libros";
    private String exists = "Fondos de inversión";

    private String noExistsEN = "Foots";
    private String existsEN = "Investment Funds";

    private ProductSearchBar productSearchBar;
    private ProductCard productCard;
    private ProductFullCard productFullCard;
    private TopBar topBar;


    public HomePage() {
        this.productSearchBar = new ProductSearchBar(productSearchbarContainer);
        this.productCard = new ProductCard(oneCardContainer);
        this.productFullCard = new ProductFullCard(fullCardContainer);
        this.topBar = new TopBar(toolbarContainer);
    }


    List<ProductCard> productCardList = new ArrayList<>();
    List<ProductFullCard> productFullCardList = new ArrayList<>();


    public List<ProductCard> getCardsOnList() {
        cardContainer.forEach(card -> productCardList.add(new ProductCard(card)));
        return productCardList;
    }

    private List<ProductFullCard> getFullCardsOnList() {
        fullCardContainerList.forEach(card -> productFullCardList.add(new ProductFullCard(card)));
        return productFullCardList;
    }

    private ProductFullCard getFirstCard() {
        return getFullCardsOnList().stream().findFirst().get();
    }

    public HomePage clickOnSearchButton() {
        click(productSearchBar.getSearchButton());
        return this;
    }

    public HomePage clickOnNoSearchButton() {
        click(productSearchBar.getNoSearchButton());
        return this;
    }

    public HomePage clickOnCard(int idx) {
        click(getCardsOnList().get(idx).getImage());
        return this;
    }

    public String getCardName(int idx) {
        return getCardsOnList().get(idx).getCardTitle();
    }

    public String getFullCardName() {
        return getFirstCard().getTitle();
    }


    public String getInputTextAnimation() {
        click(productSearchBar.getSearchContainer());
        return productSearchBar.getTypeAnimation().getText();
    }

    public HomePage typeNoExistsProduct() {
        type(productSearchBar.getProductInput(), noExists);
        return this;
    }

    public HomePage typeExistsProduct() {
        type(productSearchBar.getProductInput(), exists);
        return this;
    }

    public HomePage clickCloseFullCard() {
        click(productFullCard.getCloseButton());
        return this;
    }

    public String getNoExistsDescription() {
        return resultSearchNoExistText.getText();
    }

    public HomePage clickAutocomplete() {
        click(productSearchBar.getAutocompleteTextButton());
        return this;
    }

    public HomePage clickCloseCookiesButton() {
        click(cookiesCloseButton);
        return this;
    }

    public HomePage clickLanguageSelector() {
        click(topBar.getLanguageSelector());
        return this;
    }

    public HomePage clickLanguage() {
        click(topBar.getLanguageOptions().get(1));
        return this;
    }

    public HomePage typeNoExistsProductEN() {
        type(productSearchBar.getProductInput(), noExistsEN);
        return this;
    }

    public HomePage typeExistsProductEN() {
        type(productSearchBar.getProductInput(), existsEN);
        return this;
    }
}
