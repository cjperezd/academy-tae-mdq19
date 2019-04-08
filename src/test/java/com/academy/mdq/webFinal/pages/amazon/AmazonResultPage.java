package com.academy.mdq.webFinal.pages.amazon;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.webFinal.pages.components.BookCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AmazonResultPage extends WebPage {


    @FindBy(className = "s-include-content-margin")
    private List<WebElement> bookCardsContainer;

    @FindBy(className = "s-line-clamp-2")
    private WebElement bookName;

    List<BookCard> bookCardList = new ArrayList<>();


    private List<BookCard> getCardsOnList() {
        bookCardsContainer.forEach(card -> bookCardList.add(new BookCard(card)));
        return bookCardList;
    }

    public BookCard getFirstCard() {
        return getCardsOnList().stream().findFirst().get();
    }


    public AmazonPageBook clickBook() {
        click(bookName);
        return new AmazonPageBook();
    }


}
