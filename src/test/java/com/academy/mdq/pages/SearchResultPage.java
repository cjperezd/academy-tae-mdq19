package com.academy.mdq.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.commons.ResultCard;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;

import static com.academy.mdq.waits.Waits.*;

public class SearchResultPage extends WebPage {

  @FindBy(className = "s-include-content-margin")
  private List<WebElement> resultsDiv;

  private final List<ResultCard> resultsCards = new ArrayList<>();

  public SearchResultPage() {
    resultsDiv.stream().forEach(card -> resultsCards.add(new ResultCard(card)));
  }

  public ResultCard getResultCard(int index) {
    areVisible(resultsDiv);
    return resultsCards.get(index);
  }

  public ResultPage selectCard(int index) {
    resultsCards.get(index).clickLink();
    return new ResultPage();
  }

}
