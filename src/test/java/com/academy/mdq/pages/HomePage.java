package com.academy.mdq.pages;


import com.academy.mdq.components.NavigationBar;
import com.academy.mdq.page.web.WebPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isNotVisible;

public class HomePage extends WebPage {

    @FindBy (css = ".site-header.site-header-secondary.site_70301.en_US")
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


