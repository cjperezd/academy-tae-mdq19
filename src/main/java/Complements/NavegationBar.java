package Complements;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavegationBar extends WebPage {

  @FindBy(id = "primary-header-hotel")
  private WebElement hotelLink;

  public WebElement getHotelLink() {
    return hotelLink;
  }

}
