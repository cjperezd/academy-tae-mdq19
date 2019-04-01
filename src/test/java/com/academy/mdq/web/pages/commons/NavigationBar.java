package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.books.SearchResults;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends WebComponent {

  @FindBy(id = "searchDropdownBox")
  private WebElement searchBoxSelect;

  @FindBy(id = "twotabsearchtextbox")
  private WebElement searchBarInput;

  @FindBy(css = ".nav-search-submit.nav-sprite")
  private WebElement submitSearchButton;

  @FindBy(id="nav-cart")
  private WebElement cartButton;

  public NavigationBar(WebElement container) {
    super(container);
  }

  public NavigationBar selectSearchDepartment(String option) {
    selectByText(searchBoxSelect, option);
    return this;
  }

  public NavigationBar typeProduct(String product) {
    type(searchBarInput, product);
    return this;
  }

  public SearchResults clickSearchButton() {
    click(submitSearchButton);
    return new SearchResults();
  }

  public Cart clickCartButton() {
    click(cartButton);
    return new Cart();
  }
}
