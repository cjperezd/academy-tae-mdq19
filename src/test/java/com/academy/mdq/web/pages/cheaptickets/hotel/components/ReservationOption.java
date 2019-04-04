package com.academy.mdq.web.pages.cheaptickets.hotel.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.web.pages.cheaptickets.hotel.HotelRoomsReservation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservationOption extends WebComponent {

    @FindBy(css = "[data-automation=\"launchDepositModal\"]")
    private WebElement reservationButton;

    public ReservationOption(WebElement container) {
        super(container);
    }

    public HotelRoomsReservation clickReserveButton (HotelRoomsReservation hotelRoomsReservation)
    {
        click(reservationButton);
        return hotelRoomsReservation;
    }
}
