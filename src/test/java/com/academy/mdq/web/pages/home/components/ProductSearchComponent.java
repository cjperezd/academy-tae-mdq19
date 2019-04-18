package com.academy.mdq.web.pages.home.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.home.components.productSearch.ExpandedSearchCard;
import com.academy.mdq.web.pages.home.components.productSearch.SearchBar;
import com.academy.mdq.web.pages.home.components.productSearch.SearchCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.areVisible;
import static com.academy.mdq.waits.Waits.isVisible;

public class ProductSearchComponent extends WebComponent {

  @FindBy(className = "product-search__search")
  private WebElement searchBarContainer;

  @FindBy(id = "product-search-empty")
  private WebElement emptySearchResults;

  @FindBy(id = "product-search-results")
  private WebElement searchResults;

  @FindBy(id = "product-search-fullcard")
  private WebElement fullCardContainer;

  @FindBy(className = "box-grid__result__card")
  private List<WebElement> productCardsContainers;

  private final List<SearchCard> cards = new ArrayList<>();

  public List<SearchCard> getCards() {
    return cards;
  }

  public ProductSearchComponent(WebElement container) {
    super(container);
    areVisible(productCardsContainers);
    productCardsContainers.forEach(cont -> cards.add(new SearchCard(cont)));
  }

  public boolean areResultsEmpty() {
    return emptySearchResults.isDisplayed();
  }

  public boolean areResults() {
    return searchResults.isDisplayed();
  }

  public ExpandedSearchCard clickSearchCard(SearchCard card) {
    card.clickCardTitle();
    return new ExpandedSearchCard(fullCardContainer);
  }

  public SearchBar getSearchBar() {
    isVisible(searchResults);
    scrollIntoElement(searchResults);
    return new SearchBar(searchBarContainer);
  }
}
