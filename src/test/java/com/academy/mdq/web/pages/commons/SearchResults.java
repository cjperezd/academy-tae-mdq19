package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.books.ResultDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResults extends WebPage {

  @FindBy(css = ".s-include-content-margin.s-border-bottom")
  private List<WebElement> resultCardsContainers;

  private final List<ResultCard> resultCards = new ArrayList<>();

  public SearchResults() {
    super();
    resultCardsContainers.forEach(resultContainer -> resultCards.add(new ResultCard(resultContainer)));
  }

  public ResultCard getResultCard(int index) {
    return resultCards.get(index);
  }

  public ResultDetails selectCardTitle(int index) {
    return resultCards.get(index).selectTitle();
  }


}
