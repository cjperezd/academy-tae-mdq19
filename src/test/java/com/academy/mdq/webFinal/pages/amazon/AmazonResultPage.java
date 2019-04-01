package com.academy.mdq.webFinal.pages.amazon;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import com.academy.mdq.webFinal.pages.components.BookCards;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AmazonResultPage extends WebPage {


    @FindBy(className = "s-include-content-margin")
        private List<WebElement> bookCardsContainer;

    @FindBy (className = "s-line-clamp-2")
        private WebElement bookName;

    List<BookCards> bookCardsList = new ArrayList<>();


    public List<BookCards> getCardsOnList(){
        bookCardsContainer.forEach(card -> bookCardsList.add(new BookCards(card)));
        return bookCardsList;
    }

    public AmazonPageBook clickRightBook(){
        //if(bookCardsList.get(0).isRightBook())
            bookCardsList.get(0).clickBook();
        return new AmazonPageBook();
    }


    public AmazonPageBook clickBook(){
        click(bookName);
        return new AmazonPageBook();
    }


}
