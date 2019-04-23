package com.academy.mdq.web.pages.footer.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class News extends WebComponent {

  @FindBy(className = "whynot__block__image")
  private WebElement newsImage;

  @FindBy(className = "paragraph--small")
  private WebElement newsDate;

  @FindBy(css=".heading-2,h2.text-align-justify")
  private WebElement newsTitle;

  @FindBy(css=".whynot__block__half__rich-text p:nth-child(3)")
  private WebElement newsText;

  public News(WebElement container) {
    super(container);
  }

  public boolean isVisibleImage(){
    return newsImage.isDisplayed();
  }

  public boolean isVisibleDate(){
    return newsDate.isDisplayed();
  }

  public boolean isVisibleTitle(){
    return newsTitle.isDisplayed();
  }

  public boolean isVisibleDescrpition(){
    return newsText.isDisplayed();
  }

  public String getTitle(){
    return newsTitle.getText();
  }
}
