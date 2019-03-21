package Search;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectHotels extends WebPage {

    @FindBy(id = "primary-header-hotel")
    private WebElement hotelLink;

    public HotelPage selectButton() {
        hotelLink.click();
        return new HotelPage();
    }

}
