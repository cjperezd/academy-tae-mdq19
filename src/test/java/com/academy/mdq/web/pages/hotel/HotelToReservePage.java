package com.academy.mdq.web.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.complements.Room;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.areVisible;
import static com.academy.mdq.waits.Waits.isVisible;

public class HotelToReservePage extends WebPage {

  @FindBy(className = "tbody.room")
  private List<WebElement> roomsTBody;

  @FindBy(className = "modal-body")
  private WebElement paymentPopUpDiv;

  @FindBy(id = "deposit-pay-now-button")
  private WebElement paymentButton;

  private final List<Room> rooms = new ArrayList<>();

  public HotelToReservePage() {
    areVisible(roomsTBody);
    roomsTBody.stream().forEach(room -> rooms.add(new Room(room)));
  }

  public HotelToReservePage switchTab(int tab) {
    openNewTab(tab);
    return this;
  }

  public HotelToReservePage reserveRoom(int room) {
    rooms.get(room).reserveRoom();
    return this;
  }

  public PaymentPage payTotal() {
    isVisible(paymentPopUpDiv);
    click(paymentButton);
    return new PaymentPage();
  }

}
