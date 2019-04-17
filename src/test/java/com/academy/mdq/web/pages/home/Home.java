package com.academy.mdq.web.pages.home;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.commons.TopBar;
import com.academy.mdq.web.pages.home.components.productSearch.FullCard;
import com.academy.mdq.web.pages.home.components.productSearch.ProductResultsComponent;
import com.academy.mdq.web.pages.home.components.productSearch.SearchBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends WebPage {
  @FindBy(id = "block-openbank-topbar")
  private WebElement topBarContainer;

  @FindBy(className = "product-search__search")
  private WebElement searchBarContainer;

  @FindBy(id = "product-search-empty")
  private WebElement emptySearchResults;

  @FindBy(id = "product-search-results")
  private WebElement searchResults;

  @FindBy(css = "#product-search .container")
  private WebElement searchContainer;

  @FindBy(id = "product-search-fullcard")
  private WebElement fullCardContainer;

  public boolean areResultsEmpty() {
    return emptySearchResults.isDisplayed();
  }

  public boolean areResults() {
    return searchResults.isDisplayed();
  }

  public ProductResultsComponent getProductResultsComponent() {
    return new ProductResultsComponent(searchResults);
  }

  public FullCard getFullCard(){
    return new FullCard(fullCardContainer);
  }

  public SearchBar getSearchBar() {
    scrollIntoElement(searchContainer);
    return new SearchBar(searchBarContainer);
  }

  public TopBar getTopBar() {
    return new TopBar(topBarContainer);
  }
}
