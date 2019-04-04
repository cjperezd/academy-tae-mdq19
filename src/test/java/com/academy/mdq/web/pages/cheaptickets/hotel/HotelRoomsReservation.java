package com.academy.mdq.web.pages.cheaptickets.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.cheaptickets.commons.PaymentModal;
import com.academy.mdq.web.pages.cheaptickets.hotel.components.ReservationOption;
import com.academy.mdq.waits.Waits;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.areVisible;


public class HotelRoomsReservation extends WebPage {

    @FindBy (css= ".room .rate-plan")
    private List<WebElement> reservationOptionContainer;

    @FindBy(id = "payment-choice-modal")
    private WebElement paymentModalContainer;

    private List<ReservationOption> reservationOptions = new ArrayList<>();

    private PaymentModal paymentModal = new PaymentModal(paymentModalContainer);

    public HotelRoomsReservation ()
    {
        super();
        areVisible(reservationOptionContainer);
        reservationOptionContainer.forEach(option->reservationOptions.add(new ReservationOption(option)));
    }

    public HotelRoomsReservation clickReserveRoom() {
        return reservationOptions.get(0).clickReserveButton(this);
    }

    public HotelPayment clickPayTotal ()
    {
        Waits.isVisible(paymentModalContainer);
        paymentModal.clickPayTotal();
        return new HotelPayment();
    }



}
