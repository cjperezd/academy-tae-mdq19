package com.academy.mdq.pages;

import com.academy.mdq.component.ProductCard;
import com.academy.mdq.component.ProductFullCard;
import com.academy.mdq.component.commons.ToolBar;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.areVisible;
import static com.academy.mdq.waits.Waits.isVisible;

public class OpenBankHomePage extends WebPage {

  @FindBy(css = "#block-openbank-topbar #cookies-policy")
  private WebElement cookiesBarDiv;

  @FindBy(css = "#block-openbank-topbar .cookies-policy__close-icon")
  private WebElement topBarCloseButton;

  @FindBy(className = "openbank-topbar__layout")
  private WebElement toolBarDiv;

  @FindBy(id = "product-search")
  private WebElement searchProductContainer;

  @FindBy(css = "input#product-search")
  private WebElement searchBarInput;

  @FindBy(id = "product-search-results")
  private WebElement productsResultDiv;

  @FindBy(id = "product-search-empty")
  private WebElement emptySearchDiv;

  @FindBy(className = "button--search")
  private WebElement searchButton;

  @FindBy(className = "button--clear")
  private WebElement closeButton;

  @FindBy(id = "product-search-fullcard")
  private WebElement fullCardDiv;

  @FindBy(css = ".box-grid__item--expanded .close-icon")
  private WebElement closeFullCardButton;

  @FindBy(className = "box-grid__item")
  private List<WebElement> cardsDiv;

  private final ToolBar toolBar = new ToolBar(toolBarDiv);

  private final List<ProductCard> cards = new ArrayList<>();

  private final ProductFullCard fullCard = new ProductFullCard(fullCardDiv);

  public OpenBankHomePage() {
    if (cookiesBarDiv.isDisplayed())
      click(topBarCloseButton);
    areVisible(cardsDiv);
    cardsDiv.stream().forEach(card -> cards.add(new ProductCard(card)));
  }

  public String getSearchBarText() {
    click(searchProductContainer);
    return searchBarInput.getAttribute("aria-label");
  }

  /**
   * @param search
   * @return true is there are results, false if the were no results
   */
  public OpenBankHomePage typeInSearchBar(String search) {
    click(searchProductContainer);
    if (fullCardDiv.isDisplayed())
      click(closeFullCardButton);
    if (closeButton.isDisplayed())
      click(closeButton);

    click(searchBarInput);
    type(searchBarInput, search);
    click(searchButton);
    return this;
  }

  public boolean checkIfEmpty() {
    return emptySearchDiv.isDisplayed();
  }

  public boolean checkIfHasResults() {
    return productsResultDiv.isDisplayed() || fullCardDiv.isDisplayed();
  }

  public OpenBankHomePage selectACard(int card) {

    if (fullCardDiv.isDisplayed()) {
      click(closeFullCardButton);
      areVisible(cardsDiv);
    }

    if (card < cards.size()) {
      cards.get(card).selectFullCard();
      isVisible(fullCardDiv);
    }

    return this;
  }

  public ProductCard getProductCard(int card) {
    if (fullCardDiv.isDisplayed())
      click(closeFullCardButton);

    return cards.get(card);
  }

  public String getFullCardTitle() {
    return fullCard.getCardTitle();
  }

  public String getFullCardDescription() {
    return fullCard.getDescriptionDiv();
  }

  public String getFullCardIconSrc() {
    return fullCard.getIconSrc();
  }

  public int totalCards() {
    return cards.size();
  }

  public OpenBankHomePage changeLanguage(String lang) {
    isVisible(toolBarDiv);
    return toolBar.selectLanguage(lang);
  }

  public boolean topButtonMatch(String buttonName) {
    return toolBar.topButtonMatch(buttonName);
  }

  public boolean bottomButtonMatch(String buttonName) {
    return toolBar.bottomButtonMatch(buttonName);
  }

  public boolean topBarActionMatch(String actionName) {
    return toolBar.topBarActionMatch(actionName);
  }

  public boolean isTopButtonEnable(String buttonName) {
    return toolBar.isTopButtonEnable(buttonName);
  }

  public boolean isBottomButtonEnable(String buttonName) {
    return toolBar.isBottomButtonEnable(buttonName);
  }

  public boolean isTopBarActionEnable(String actionName) {
    return toolBar.isTopBarActionEnable(actionName);
  }

  public boolean isTopButtonClickable(String buttonName) {
    return toolBar.isTopButtonClickable(buttonName);
  }

  public boolean isBottomButtonClickable(String buttonName) {
    return toolBar.isBottomButtonClickable(buttonName);
  }

  public boolean isTopBarActionClickable(String actionName) {
    return toolBar.isTopBarActionClickable(actionName);
  }
}
