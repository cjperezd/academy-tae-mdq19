package com.academy.mdq.component.commons;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.PrensaPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.isVisible;

public class FooterTop extends WebComponent {

  @FindBy(css = "#block-piedepagina .menu-item")
  private List<WebElement> menuOptions;

  public FooterTop(WebElement container) {
    super(container);
  }

  public boolean areAllOptionsVisible() {
    return menuOptions.stream().allMatch(o -> isVisible(o).isDisplayed());
  }

  public PrensaPage selectPrensa() {
    click(menuOptions.stream().filter(o -> o.getText().equals("Prensa")).findFirst().get());
    return new PrensaPage();
  }

}
