package com.academy.mdq.pages.CheapTickets.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecondSearchPageComp extends WebComponent {


    public SecondSearchPageComp(WebElement container) {
        super(container);
    }

    @FindBy (id = "inpHotelNameMirror")
    private WebElement inputHotelName;

    @FindBy (className = "section-header-main")
    private WebElement hotelResultTitle;

    @FindBy (id = "hotelNameGoBtn")
    private WebElement hotelNameButton;

    @FindBy (id = "aria-option-0")
    private WebElement clickFirstOptionFae;

    @FindBy (id = "modalInterstitial")
    private WebElement waitSearch;


    public WebElement getInputHotelName() {

        return inputHotelName;
    }

    public WebElement getHotelResultTitle() {

        return hotelResultTitle;
    }

    public WebElement getHotelNameButton() {

        return hotelNameButton;
    }

    public WebElement getClickFirstOptionFae() {

        return clickFirstOptionFae;
    }

    public WebElement getWaitSearch() {
        return waitSearch;
    }
}
