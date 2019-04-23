package com.academy.mdq.web.pages.promotionsanddiscounts.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoriesMenu extends WebComponent {

  @FindBy(className = "category__title")
  private List<WebElement> categoriesTitles;

  public CategoriesMenu(WebElement container) {
    super(container);
  }

  public CategoriesMenu clickCategory(Category category) {
    click(categoriesTitles.stream().filter(cat -> cat.getText().toLowerCase().contains(category.toString().toLowerCase())).findFirst().get());
    return this;
  }

  public boolean isVisible(Category category) {
    return categoriesTitles.stream().filter(cat -> cat.getText().toLowerCase().contains(category.toString().toLowerCase())).findFirst().get().isDisplayed();
  }


  public enum Category {
    RESTAURANTES, MODA, HOTELES, OCIO, TRANSPORTE, BELLEZA
  }

}
