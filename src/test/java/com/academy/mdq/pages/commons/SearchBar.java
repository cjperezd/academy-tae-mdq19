package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchBar extends WebComponent {

  @FindBy(id = "searchDropdownBox")
  private WebElement filterBox;

  @FindBy(id = "twotabsearchtextbox")
  private WebElement searchInput;

  @FindBy(css = ".nav-input[value='Go']")
  private WebElement searchButton;

  public SearchBar(WebElement container) {
    super(container);
  }

  public void selectFilter(String filter) {
    selectByText(filterBox, filter);
  }

  public void writeSearch(String search) {
    click(searchInput);
    type(searchInput, search);
  }

  public void clickGoButton() {
    click(searchButton);
  }

}
