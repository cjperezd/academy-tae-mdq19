package com.academy.mdq.webFinal.pages.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartBookCard extends WebComponent {


    public CartBookCard(WebElement container) {
        super(container);
    }


    @FindBy (css = "a-size-medium.sc-product-title.a-text-bold")
        private WebElement bookTitle;




    public String getBookTitle(){
        return bookTitle.getText();
    }

}
