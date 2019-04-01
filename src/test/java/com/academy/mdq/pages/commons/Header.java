package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.CartListPage;
import com.academy.mdq.pages.SearchResultPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends WebComponent {

  @FindBy(className = "nav-searchbar")
  private WebElement searchBarForm;

  @FindBy(id = "nav-cart")
  private WebElement cartButton;

  private SearchBar searchBar = new SearchBar(searchBarForm);

  public Header(WebElement container) {
    super(container);
  }

  public void selectFilter(String filter) {
    searchBar.selectFilter(filter);
  }

  public SearchResultPage enterSearch(String search) {
    searchBar.writeSearch(search);
    searchBar.clickGoButton();
    return new SearchResultPage();
  }

  public CartListPage selectCart() {
    click(cartButton);
    return new CartListPage();
  }

}
