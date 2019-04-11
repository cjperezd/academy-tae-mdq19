package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends WebComponent {

  @FindBy(id = "searchDropdownBox")
  private WebElement categoryDropDown;

  @FindBy(id = "twotabsearchtextbox")
  private WebElement searchBarInput;

  @FindBy(css = ".nav-search-submit.nav-sprite")
  private WebElement submitSearchButton;

  @FindBy(id = "nav-cart")
  private WebElement goToCartButton;

  public NavigationBar(WebElement container) {
    super(container);
  }

  public NavigationBar selectSearchDepartment(String option) {
    selectByText(categoryDropDown, option);
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
    click(goToCartButton);
    return new Cart();
  }

}
