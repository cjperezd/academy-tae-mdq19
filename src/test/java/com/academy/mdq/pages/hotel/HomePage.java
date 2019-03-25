package com.academy.mdq.pages.hotel;


import com.academy.mdq.pages.commons.NavigationBar;
import com.academy.mdq.page.web.WebPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {

    @FindBy (css = ".site-header-secondary")
    private WebElement navBar;

    private final NavigationBar navigationBar = new NavigationBar(navBar);

    public HotelSearch clickHotelsButton ()
    {
        return navigationBar.clickHotelsButton();
    }

}


