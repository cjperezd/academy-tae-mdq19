package com.academy.mdq.oKWeb.pages.oKPage.oKpages;

import com.academy.mdq.oKWeb.pages.oKPage.components.*;
import com.academy.mdq.page.web.WebPage;
import javafx.scene.control.ScrollToEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends WebPage {



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

    @FindBy(className = "differential-and-characteristic__title")  //ELIMINAR
    private WebElement justForTest;

    @FindBy (css = "#product-search .container")
    private WebElement searchContainer;

    @FindBy (id = "product-search-results-cards")
    private WebElement cardsContainer;

    private ProductSearchBar productSearchBar;
    private ProductCard productCard;
    private ProductFullCard productFullCard;
    private TopBar topBar;
    private ProductCardContainer productCardContainer;


    public HomePage() {
        this.productSearchBar = new ProductSearchBar(productSearchbarContainer);
        this.productCard = new ProductCard(oneCardContainer);
        this.productFullCard = new ProductFullCard(fullCardContainer);
        this.topBar = new TopBar(toolbarContainer);
        this.productCardContainer = new ProductCardContainer(cardsContainer);
    }

    List<ProductFullCard> productFullCardList = new ArrayList<>();




    private List<ProductFullCard> getFullCardsOnList() {
        fullCardContainerList.forEach(card -> productFullCardList.add(new ProductFullCard(card)));
        return productFullCardList;
    }

    private ProductFullCard getFirstFullCard() {
        return getFullCardsOnList().stream().findFirst().get();
    }

    public String getFullCardName() {
        return getFirstFullCard().getTitle();
    }

    public String getNoExistsDescription() {
        return resultSearchNoExistText.getText();
    }

    public HomePage clickCloseCookiesButton() {
        click(cookiesCloseButton);
        return this;
    }

    public ProductSearchBar getProductSearchBar() {
        return productSearchBar;
    }

    public ProductCard getProductCard() {
        return productCard;
    }

    public ProductFullCard getProductFullCard() {
        return productFullCard;
    }

    public ProductCardContainer getProductCardContainer(){
        return productCardContainer;
    }

    public TopBar getTopBar() {
        return topBar;
    }

    public HomePage scrollPage(){
        scroll(searchContainer);
        return this;
    }
}
