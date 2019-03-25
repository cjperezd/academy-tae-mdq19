package com.academy.mdq.pages.common.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.hotel.HotelSearch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends WebComponent {

  @FindBy(id = "primary-header-hotel")
  private WebElement hotelButton;

  public SearchBar(WebElement container) {
    super(container);
  }

  public HotelSearch clickOnHotels() {
    click(hotelButton);
    return new HotelSearch();
  }
}
