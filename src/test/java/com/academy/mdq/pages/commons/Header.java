package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.AmazonHomePage;
import com.academy.mdq.pages.CartListPage;
import com.academy.mdq.pages.SearchResultPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.*;
import static com.academy.mdq.waits.Waits.isVisible;

public class Header extends WebComponent {

  @FindBy(className = "nav-searchbar")
  private WebElement searchBarForm;

  @FindBy(id = "nav-cart")
  private WebElement cartButton;

  @FindBy(id = "icp-nav-flyout")
  private WebElement languageLink;

  @FindBy(id = "nav-flyout-icp")
  private WebElement optionsDiv;

  @FindBy(css = "#nav-flyout-icp .nav-link")
  private List<WebElement> languagesLinks;

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
    click(isVisible(cartButton));
    return new CartListPage();
  }

  public AmazonHomePage changeLanguage(String language) {
    hover(isVisible(languageLink));
    Waits.isVisible(optionsDiv);
    languagesLinks.stream()
        .filter(l -> l.getText().toLowerCase().contains(language.toLowerCase()))
        .findFirst()
        .ifPresent(WebElement::click);
    return new AmazonHomePage();
  }

}
