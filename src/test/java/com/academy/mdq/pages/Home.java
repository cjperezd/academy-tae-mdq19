package com.academy.mdq.pages;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.complements.NavigationBar;
import com.academy.mdq.pages.hotel.HotelPage;

public class Home extends WebPage {

  private final NavigationBar navigationBar = new NavigationBar();

  public HotelPage goToHotels() {
    return navigationBar.goToHotels();
  }
}
