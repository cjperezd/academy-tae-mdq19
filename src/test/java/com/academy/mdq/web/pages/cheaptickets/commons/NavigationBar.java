package com.academy.mdq.web.pages.cheaptickets.commons;


import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.cheaptickets.hotel.HotelSearch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends WebComponent {

    public NavigationBar(WebElement container) {
        super(container);
    }

    @FindBy (id = "primary-header-home")
    private WebElement homeButton;

    @FindBy (id = "primary-header-package")
    private WebElement vacationPackagesButton;

    @FindBy (id = "primary-header-hotel")
    private WebElement hotelsButton;

    @FindBy (id = "primary-header-car")
    private WebElement carsButton;

    @FindBy (id = "primary-header-cruise")
    private WebElement cruisesButton;

    @FindBy (id = "primary-header-events")
    private WebElement eventTicketsButton;

    @FindBy (id = "primary-header-activity")
    private WebElement activitiesButton;

    @FindBy (id = "primary-header-flight")
    private WebElement flightsButton;

    @FindBy (id = "primary-header-deals")
    private WebElement dealsButton;

    @FindBy (id = "primary-header-mobile")
    private WebElement mobileButton;

    @FindBy (id = "primary-header-rewards")
    private WebElement cheapCashButton;

    @FindBy (id = "primary-header-all-in-header-shop-menu")
    private WebElement moreButton;


    public enum Buttons {
        HOME,VACATIONPACKAGES,HOTELS,CARS,CRUISES,EVENTTICKETS,ACTIVITIES,FLIGHTS,DEALS,MOBILE,CHEAPCASH,MORE
    }

    public WebPage clickButton (Buttons buttonName)
    {
        switch(buttonName) {
            case HOME:
                break;
            case VACATIONPACKAGES:
                break;
            case HOTELS:
                click(hotelsButton);
                return new HotelSearch();
            case CARS:
                break;
            case CRUISES:
                break;
            case EVENTTICKETS:
                break;
            case ACTIVITIES:
                break;
            case FLIGHTS:
                break;
            case DEALS:
                break;
            case MOBILE:
                break;
            case CHEAPCASH:
                break;
            case MORE:
                break;

        }

        return null;
    }




}
