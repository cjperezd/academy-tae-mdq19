package com.academy.mdq.pages;

import com.academy.mdq.component.NewSection;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PrensaPage extends WebPage {

  @FindBy(className = "whynot")
  private List<WebElement> newsSection;

  private final List<NewSection> news = new ArrayList<>();

  public PrensaPage() {
    newsSection.forEach(n -> news.add(new NewSection(n)));
  }

  public int totalOfNews() {
    return news.size();
  }

  public NewSection getNewSection(int index) {
    if (index < news.size())
      return news.get(index);
    else
      return null;
  }

}
