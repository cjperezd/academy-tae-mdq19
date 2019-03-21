package Search;

import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelPage extends WebPage {

        @FindBy(id = "hotel-destination-hlp")
        private WebElement destinInput;

        @FindBy(id = "aria-option-0")
        private WebElement destinLi;

        @FindBy(id = "hotel-checkin-hlp")
        private WebElement checkinInput;

        @FindBy(id = "hotel-checkout-hlp")
        private WebElement checkoutInput;

        @FindBy(id = "hotel-rooms-hlp")
        private WebElement roomsSelect;

        @FindBy(id = "hotel-1-adults-hlp")
        private WebElement adultSelect;

        @FindBy(id = "hotel-1-children-hlp")
        private WebElement childrenSelect;

        @FindBy(id = "hotel-1-age-select-1-hlp")
        private WebElement childrenAgeSelect;

        @FindBy(css = "[data-gcw-change-submit-text='Search']")
        private WebElement searchButton;

        public HotelPage enterDestination(String destination) {
            type(destinInput, destination);
            click(destinLi);
            return this;
        }

        public HotelPage enterCheckin(String dateIn) {
            type(checkinInput, dateIn);
            return this;
        }

        public HotelPage enterCheckout(String dateOut) {
            type(checkoutInput, dateOut);
            return this;
        }

        public HotelPage selectAdults(int num) {
            selectByText(adultSelect, String.valueOf(num));
            return this;
        }

        public HotelPage selectChildren(int num) {
            selectByText(childrenSelect, String.valueOf(num));
            return this;
        }

        public HotelPage selectAge(int num) {
            selectByText(childrenAgeSelect, String.valueOf(num));
            return this;
        }

        public HotelResults selectButton() {
            click(searchButton);
            return new HotelResults();
        }

}
