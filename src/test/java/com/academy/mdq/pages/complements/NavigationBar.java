package com.academy.mdq.pages.complements;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.hotel.HotelPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends WebPage {

  @FindBy(id = "primary-header-hotel")
  private WebElement hotelLink;

  public HotelPage goToHotels() {
    click(hotelLink);
    return new HotelPage();
  }

}
