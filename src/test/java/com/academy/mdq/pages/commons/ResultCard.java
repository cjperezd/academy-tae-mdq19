package com.academy.mdq.pages.commons;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultCard extends WebComponent {

  @FindBy(css = ".a-section h5 span")
  private WebElement titleSpan;

  @FindBy(css = ".a-price .a-price-whole")
  private List<WebElement> pricesWholeList;

  @FindBy(css = ".a-price .a-price-fraction")
  private List<WebElement> pricesFractionList;

  @FindBy(css = "h5 .a-link-normal")
  private WebElement resultLink;

  public ResultCard(WebElement container) {
    super(container);
  }

  public String getTitle() {
    return titleSpan.getText();
  }

  public String getOriginalPrice() {
    return pricesWholeList.get(0).getText() + "." + pricesFractionList.get(0).getText();
  }

  public void clickLink() {
    click(resultLink);
  }

}
