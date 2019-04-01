package com.academy.mdq.webFinal.pages.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.webFinal.pages.amazon.AmazonResultPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookCards extends WebComponent {

    public BookCards(WebElement container) {
        super(container);
    }

    @FindBy (className = "s-image")
        private WebElement bookImage;

    @FindBy (className = "s-line-clamp-2")
        private WebElement bookName;

    @FindBy (css = "a-offscreen")
        private WebElement bookPrice;


    public AmazonResultPage click(){
        click(bookName);
        return new AmazonResultPage();
    }

    public boolean isRightBook(){
        return bookName.equals("Embracing the Power of AI: A Gentle CXO Guide");
    }

    public void clickBook(){
        click(bookImage);
    }


}
