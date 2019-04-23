package com.academy.mdq.web.pages.footer;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.footer.components.News;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Press extends WebPage {

  @FindBy(className = "header-page__title")
  private WebElement pageTitle;

  @FindBy(className = "whynot__block")
  private List<WebElement> newsContainer;

  private final List<News> news = new ArrayList<>();

  public Press() {
    newsContainer.forEach(cont -> news.add(new News(cont)));
  }

  public List<News> getNews(){
    return news;
  }

}
