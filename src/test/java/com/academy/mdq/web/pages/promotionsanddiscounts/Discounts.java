package com.academy.mdq.web.pages.promotionsanddiscounts;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.promotionsanddiscounts.components.CategoriesMenu;
import com.academy.mdq.web.pages.promotionsanddiscounts.components.CategoriesMenu.Category;
import com.academy.mdq.web.pages.promotionsanddiscounts.components.DiscountsByCategory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Discounts extends WebPage {

  @FindBy(className = "header-page__title")
  private WebElement pageTitle;

  @FindBy(className = "discount__menu")
  private WebElement categoryMenuContainer;

  @FindBy(id = "774")
  private WebElement discountsByRestaurantContainer;

  @FindBy(id = "776")
  private WebElement discountsByFashionContainer;

  @FindBy(id = "778")
  private WebElement discountsByHotelsContainer;

  @FindBy(id = "777")
  private WebElement discountsByLeisureContainer;

  @FindBy(id = "775")
  private WebElement discountsByTransportationContainer;

  @FindBy(id = "773")
  private WebElement discountsByBeautyContainer;

  private final CategoriesMenu categoriesMenu = new CategoriesMenu(categoryMenuContainer);

  public String getPageTitle(){
    return pageTitle.getText();
  }

  public DiscountsByCategory clickDiscountByCategory(Category category) {
    categoriesMenu.clickCategory(category);
    switch (category) {
      case RESTAURANTES:
        return new DiscountsByCategory(discountsByRestaurantContainer);
      case MODA:
        return new DiscountsByCategory(discountsByFashionContainer);
      case HOTELES:
        return new DiscountsByCategory(discountsByHotelsContainer);
      case OCIO:
        return new DiscountsByCategory(discountsByLeisureContainer);
      case TRANSPORTE:
        return new DiscountsByCategory(discountsByTransportationContainer);
      case BELLEZA:
        return new DiscountsByCategory(discountsByBeautyContainer);
    }
    return null;
  }

  public CategoriesMenu getCategoriesMenu() {
    return categoriesMenu;
  }

}
