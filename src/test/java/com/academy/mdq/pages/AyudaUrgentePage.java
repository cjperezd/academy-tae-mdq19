package com.academy.mdq.pages;

import com.academy.mdq.component.HelpCard;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AyudaUrgentePage extends WebPage {

  @FindBy(className = "box-grid__item")
  private List<WebElement> numberCardsDiv;

  private final List<HelpCard> helpcards = new ArrayList<>();

  public AyudaUrgentePage() {
    numberCardsDiv.forEach(card -> helpcards.add(new HelpCard(card)));
  }

  public HelpCard getHelpCard(int index) {
    if (index < helpcards.size())
      return helpcards.get(index);
    else
      return null;
  }

  public int totalOfCards() {
    return helpcards.size();
  }

}
