package com.academy.mdq.components;


import com.academy.mdq.page.web.WebComponent;
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

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getVacationPackagesButton() {
        return vacationPackagesButton;
    }

    public WebElement getHotelsButton() {
        return hotelsButton;
    }

    public WebElement getCarsButton() {
        return carsButton;
    }

    public WebElement getCruisesButton() {
        return cruisesButton;
    }

    public WebElement getEventTicketsButton() {
        return eventTicketsButton;
    }

    public WebElement getActivitiesButton() {
        return activitiesButton;
    }

    public WebElement getFlightsButton() {
        return flightsButton;
    }

    public WebElement getDealsButton() {
        return dealsButton;
    }

    public WebElement getMobileButton() {
        return mobileButton;
    }

    public WebElement getCheapCashButton() {
        return cheapCashButton;
    }

    public WebElement getMoreButton() {
        return moreButton;
    }
}
