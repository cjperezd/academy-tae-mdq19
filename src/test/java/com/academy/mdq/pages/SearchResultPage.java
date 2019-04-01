package com.academy.mdq.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.commons.ResultCard;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.*;

public class SearchResultPage extends WebPage {

  @FindBy(className = "s-include-content-margin")
  private List<WebElement> resultsDiv;

  private final List<ResultCard> resultsCards = new ArrayList<>();

  public boolean checkFirstCard(String search, String price) {
    areVisible(resultsDiv);
    setCards();
    return resultsCards.get(0).getTitle().contains(search)
        && resultsCards.get(0).getOriginalPrice().contains(price);
  }

  public ResultPage selectFirstCard() {
    resultsCards.get(0).clickLink();
    return new ResultPage();
  }

  private void setCards() {
    resultsDiv.stream().forEach(card -> resultsCards.add(new ResultCard(card)));
  }

}
