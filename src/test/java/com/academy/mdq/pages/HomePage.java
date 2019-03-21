package com.academy.mdq.pages;


import com.academy.mdq.components.NavigationBar;
import com.academy.mdq.page.web.WebPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {

    @FindBy (xpath = "//*[@id=\"header-container\"]/div[2]/div[8]")
    private WebElement navBar;

    private NavigationBar navigationBar;


    public HomePage ()
    {
        super();

        navigationBar = new NavigationBar(navBar);
    }


    public HotelsPage clickOnButton ()
    {
        click(navigationBar.getHotelsButton());
        return new HotelsPage();
    }

}


