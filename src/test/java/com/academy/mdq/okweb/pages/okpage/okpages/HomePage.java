package com.academy.mdq.okweb.pages.okpage.okpages;

import com.academy.mdq.okweb.pages.okpage.components.*;
import com.academy.mdq.okweb.pages.okpage.components.commons.Footer;
import com.academy.mdq.okweb.pages.okpage.components.commons.NavigationMenuContents;
import com.academy.mdq.okweb.pages.okpage.components.commons.SectionsBar;
import com.academy.mdq.okweb.pages.okpage.components.commons.TopBar;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    private WebElement topbarContainer;

    @FindBy(css = "#product-search .container")
    private WebElement searchContainer;

    @FindBy(id = "product-search-results-cards")
    private WebElement cardsContainer;

    @FindBy(className = "openbank-topbar__bottom")
    private WebElement sectionsBarContainer;

    @FindBy(className = "openbank-topbar__actions__access")
    private WebElement loginButton;

    @FindBy(className = "navigation-menu__item-content")
    private List<WebElement> navigationMenuContentsList;

    @FindBy (className = "footer-menu__top")
    private WebElement footerContainer;


    private ProductSearchBar productSearchBar;
    private ProductCard productCard;
    private ProductFullCard productFullCard;
    private TopBar topBar;
    private ProductCardContainer productCardContainer;
    private SectionsBar sectionsBar;
    private Login login;
    private NavigationMenuContents navigationMenuContents;
    private Footer footer;


    public HomePage() {
        this.productSearchBar = new ProductSearchBar(productSearchbarContainer);
        this.productCard = new ProductCard(oneCardContainer);
        this.productFullCard = new ProductFullCard(fullCardContainer);
        this.topBar = new TopBar(topbarContainer);
        this.productCardContainer = new ProductCardContainer(cardsContainer);
        this.sectionsBar = new SectionsBar(sectionsBarContainer);
        this.login = new Login();
        this.navigationMenuContents = new NavigationMenuContents(navigationMenuContentsList.get(0));
        this.footer = new Footer(footerContainer);
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

    public ProductCardContainer getProductCardContainer() {
        return productCardContainer;
    }

    public TopBar getTopBar() {
        return topBar;
    }

    public SectionsBar getSectionsBar() {
        return sectionsBar;
    }

    public HomePage scrollPage() {
        scroll(searchContainer);
        return this;
    }

    public HomePage scrollToFooter(){
        scroll(footerContainer);
        return this;
    }

    public Login clickLogin() {
        click(loginButton);
        return new Login();
    }

    public Login getLogin() {
        return login;
    }

    public NavigationMenuContents getNavigationMenuContents() {
        return navigationMenuContents;
    }

    public Footer getFooter (){
        return footer;
    }


}
