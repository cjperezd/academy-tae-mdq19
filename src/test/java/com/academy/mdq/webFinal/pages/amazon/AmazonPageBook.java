package com.academy.mdq.webFinal.pages.amazon;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class AmazonPageBook extends WebPage {

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(id = "nav-cart")
    private WebElement cartButton;

    @FindBy(id = "uss-sheet-view")
    private WebElement addToCartViewer;

    @FindBy(id = "a-autoid-19-announce")
    private WebElement goToCart;

    @FindBy(id = "one-click-button")
    private WebElement oneClickButton;


    public AmazonPageBook addToCart() {
        click(addToCartButton);
        return this;
    }

    public CartPage cartButton() {
        click(cartButton);
        return new CartPage();
    }

}
