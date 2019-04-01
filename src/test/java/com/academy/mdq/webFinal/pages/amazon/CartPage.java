package com.academy.mdq.webFinal.pages.amazon;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import com.academy.mdq.webFinal.pages.components.BookCard;
import com.academy.mdq.webFinal.pages.components.CartBookCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends WebPage {

  @FindBy (className = "sc-list-item-content")
    private List<WebElement> cardContainer;

  @FindBy(css = ".a-size-small.sc-action-delete")
    private WebElement deleteButton;

  @FindBy(className = "sc-list-item-content")
    private List<WebElement> shoppingCardItems;

  @FindBy (className = "sc-cart-header")
    private WebElement cartInformation;

  @FindBy (className = "sc-list-item-removed-msg")
    private WebElement removedItems;

    private List<CartBookCard> listOfCards = new ArrayList<>();

    private List<CartBookCard> getCardsOnBookList() {
        cardContainer.forEach(card -> listOfCards.add(new CartBookCard(card)));
        return listOfCards;
    }


  public CartPage clickOnDelete() {
    click(deleteButton);
    return this;
  }

  public CartBookCard getFirstCard(){
      return getCardsOnBookList().stream().findFirst().get();
  }

  public String getTitle(){
        return getFirstCard().getBookTitle();
  }

  public boolean isCartEmpty(String information){
        Waits.isVisible(removedItems);
        return cartInformation.getText().equals(information);

  }


}
