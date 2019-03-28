package com.academy.mdq.web.pages.hotel;


import com.academy.mdq.web.pages.commons.NavigationBar;
import com.academy.mdq.page.web.WebPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.web.pages.commons.NavigationBar.Buttons.HOTELS;

public class HomePage extends WebPage {

    @FindBy (css = ".site-header-secondary")
    private WebElement navBar;

    private final NavigationBar navigationBar = new NavigationBar(navBar);

    public HotelSearch clickHotelsButton ()
    {
        return (HotelSearch) navigationBar.clickButton(HOTELS);
    }

}


