package com.academy.mdq.web.pages.commons;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.books.SearchResults;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends WebPage {

  @FindBy(id = "nav-search")
  private WebElement navBarContainer;

  private NavigationBar navBar = new NavigationBar((navBarContainer));

  public SearchResults searchByBooks (String bookName)
  {
    navBar.selectSearchDepartment("Books");
    navBar.searchTextInput(bookName);
    return navBar.clickSearchButton();


  }

}
