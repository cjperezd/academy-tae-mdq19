package com.academy.mdq.webFinal.pages.amazon;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.webFinal.pages.components.SearchBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends WebPage {


  @FindBy(id = "nav-search")
  private WebElement searchBarContainer;

  SearchBar searchBar = new SearchBar(searchBarContainer);

  public AmazonResultPage clickOnGo() {
    searchBar.search();
    return new AmazonResultPage();
  }

  public AmazonHomePage typeText(String bookName) {
    searchBar.typeBookText(bookName);
    return this;
  }

  public SearchBar getSearchBar() {
    return searchBar;
  }
}
