package com.academy.mdq.web.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.complements.Room;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isVisible;

public class HotelToReservePage extends WebPage {

  @FindBy(className = "first-room-featured")
  private WebElement firstRoomTBody;

  @FindBy(className = "modal-body")
  private WebElement paymentPopUpDiv;

  @FindBy(id = "deposit-pay-now-button")
  private WebElement paymentButton;

  private final Room onlyRoom = new Room(firstRoomTBody);

  public HotelToReservePage switchTab(int tab) {
    openNewTab(tab);
    return this;
  }

  public HotelToReservePage reserveFirstRoom() {
    isVisible(firstRoomTBody);
    onlyRoom.reserveRoom();
    return this;
  }

  public PaymentPage payTotal() {
    isVisible(paymentPopUpDiv);
    click(paymentButton);
    return new PaymentPage();
  }

}
