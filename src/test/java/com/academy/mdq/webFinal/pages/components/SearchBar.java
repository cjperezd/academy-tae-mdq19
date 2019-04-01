package com.academy.mdq.webFinal.pages.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.webFinal.pages.amazon.AmazonHomePage;
import com.academy.mdq.webFinal.pages.amazon.AmazonResultPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchBar extends WebComponent {

  public SearchBar(WebElement container) {
    super(container);
  }

  @FindBy(className = "nav-left")
  private WebElement categorySelector;

  @FindBy(id = "twotabsearchtextbox")
  private WebElement textContainer;

  @FindBy(className = "nav-input")
  private WebElement goButton;

  public SearchBar selectCategory(String category) {
    new Select(categorySelector).selectByVisibleText(category);
    return new SearchBar(getContainer());
  }

  public AmazonResultPage search() {
    click(goButton);
    return new AmazonResultPage();
  }

  public SearchBar typeBookText(String bookName) {
    type(textContainer, bookName);
    return this;
  }


}



