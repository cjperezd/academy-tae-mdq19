package com.academy.mdq.web.pages.books;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.books.components.BookResultCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends WebPage {

  @FindBy (css=".s-include-content-margin.s-border-bottom")
  private List<WebElement> resultCardsContainers;

  private List<BookResultCard> bookResultCards = new ArrayList<>();

  public SearchResults (){
    super();
    resultCardsContainers.forEach(resultContainer->bookResultCards.add(new BookResultCard(resultContainer)));
  }

  public boolean compareResults(String name, String price) {
    BookResultCard first = bookResultCards.get(0);
    return first.getBookTitle().contains(name) && first.getBookPrice().equals(price);
  }
  public ResultDetails selectBook ()
  {
    return bookResultCards.get(0).selectTitle();
  }


}
