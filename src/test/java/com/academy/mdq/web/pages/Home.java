package com.academy.mdq.web.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.complements.NavigationBar;
import com.academy.mdq.web.pages.hotel.HotelPage;

public class Home extends WebPage {

  private final NavigationBar navigationBar = new NavigationBar();

  public HotelPage goToHotels() {
    return navigationBar.goToHotels();
  }
}
