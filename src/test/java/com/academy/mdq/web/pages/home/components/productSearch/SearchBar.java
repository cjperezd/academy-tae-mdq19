package com.academy.mdq.web.pages.home.components.productSearch;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends WebComponent {

  @FindBy(css = ".product-search__autocomplete [aria-label]")
  private WebElement productSearchInput;

  @FindBy(className = "button--search")
  private WebElement searchButton;

  @FindBy(className = "button--clear")
  private WebElement closeButton;

  @FindBy(id = "product-search")
  private WebElement searchContainer;

  public SearchBar(WebElement container) {
    super(container);
  }

  public String getAutoTextFromSearchInput() {
    return productSearchInput.getAttribute("aria-label");
  }

  public SearchBar typeProduct(String product) {
    type(productSearchInput, product);
    return this;
  }

  public SearchBar clickSearchButton() {
    click(searchButton);
    return this;
  }

  public SearchBar clickCloseButton() {
    click(closeButton);
    return this;
  }

}
