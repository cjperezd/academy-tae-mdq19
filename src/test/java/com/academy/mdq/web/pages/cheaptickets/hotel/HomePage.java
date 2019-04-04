package com.academy.mdq.web.pages.cheaptickets.hotel;


import com.academy.mdq.web.pages.cheaptickets.commons.NavigationBar;
import com.academy.mdq.page.web.WebPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.web.pages.cheaptickets.commons.NavigationBar.Buttons.HOTELS;

public class HomePage extends WebPage {

    @FindBy (css = ".site-header-secondary")
    private WebElement navBar;

    private final NavigationBar navigationBar = new NavigationBar(navBar);

    public HotelSearch clickHotelsButton ()
    {
        return (HotelSearch) navigationBar.clickButton(HOTELS);
    }

}


