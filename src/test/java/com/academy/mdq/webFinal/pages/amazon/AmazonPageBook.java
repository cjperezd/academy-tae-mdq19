package com.academy.mdq.webFinal.pages.amazon;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPageBook extends WebPage {

    @FindBy (id = "add-to-cart-button")
        private WebElement addToCartButton;

    @FindBy (id = "nav-cart")
        private WebElement cartButton;



    public AmazonPageBook clickOnAddToCart(){
        click(addToCartButton);
        return this;
    }

    public CartPage clickCartButton(){
        click(cartButton);
        return new CartPage();
    }
}
