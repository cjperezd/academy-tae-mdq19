package com.academy.mdq.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.common.components.Search;
import com.academy.mdq.pages.common.components.SearchBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheapTickets extends WebPage {

  @FindBy(className = "site-header-secondary")
  private WebElement searchBarElement;

  private final SearchBar searchBar = new SearchBar(searchBarElement);

  public Search clickOn(Product product) {
    switch (product) {
      case HOTEL:
        return searchBar.clickOnHotels();
      default:
        return searchBar.clickOnHotels();
    }
  }

  public enum Product {
    HOTEL, FLIGHT, CAR
  }
}
