package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelDetails extends WebPage {

@FindBy (css = ".rate-plan.rate-plan-first")
    private WebElement firstHotelWrap;

@FindBy (css = ".btn-primary.book-button.btn-pwa.btn-action")
    private WebElement reserveButton;

@FindBy (id = "payment-choice-modal")
private WebElement modalWrap;

@FindBy (id = "deposit-pay-now-button")
    private WebElement payButton;

    public HotelDetails() {
        super();
    }

    public HotelDetails clickReserveHotel(){
        click(reserveButton);
        return new HotelDetails();
    }

    public HotelDetailsResult clickPayButton(){
        Waits.isVisible(modalWrap);
        click(payButton);
        return new HotelDetailsResult();
    }
}
