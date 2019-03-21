package Search;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelResults extends WebPage {

    @FindBy(css = "div[class = 'modal-body']")
    private WebElement popUpDiv;

    @FindBy(id = "modalCloseButton")
    private WebElement popUpButton;

    @FindBy(css = "[class='section-header-main']")
    private WebElement resultsHeader;

    @FindBy(id = "inpHotelNameMirror")
    private WebElement propertyInput;

    @FindBy(id="hotelNameGoBtn")
    private WebElement goButton;

    private HotelResults closePopUp() {
        Waits.isVisible(popUpDiv);
        if (popUpDiv.isDisplayed()) {
            click(popUpButton);
        }
        return this;
    }

    public HotelResults verifyResults(String destination) {
        closePopUp();
        String[] results = resultsHeader.getText().split(":");
        Assert.assertEquals(results[0], destination);
        Assert.assertNotEquals(results[1], "0 properties");
        return this;
    }

    public HotelResults searchProperty(String property) {
        type(propertyInput, property);
        return this;
    }

    public PropertyResults selectGo() {
        click(goButton);
        return new PropertyResults();
    }
}
