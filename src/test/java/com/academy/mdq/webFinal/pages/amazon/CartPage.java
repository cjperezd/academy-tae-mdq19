package com.academy.mdq.webFinal.pages.amazon;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends WebPage {

    @FindBy (css = ".a-size-small.sc-action-delete")
        private WebElement deleteButton;

    @FindBy (className = "a-size-base")
        private List<WebElement> nameOfBookDeleted;


    public CartPage clickOnDelete(){
        click(deleteButton);
        return this;
    }

    public boolean isTheName(){
        return nameOfBookDeleted.get(0).getText().equals("Embracing the Power of AI: A Gentle CXO Guide was removed from Shopping Cart.");
    }
}
