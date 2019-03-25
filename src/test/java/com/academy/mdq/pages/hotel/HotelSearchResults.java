package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.PropertyResultPage;
import com.academy.mdq.pages.commons.PopUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.isNotVisible;
import static com.academy.mdq.waits.Waits.isVisible;

public class HotelSearchResults extends WebPage {

    @FindBy(css = ".modal-body")
    private WebElement popUpContainer;

    @FindBy(id = "inpHotelNameMirror")
    private WebElement searchByPropertyInput;

    @FindBy(id = "aria-option-0")
    private WebElement firstOption;

    @FindBy(css = ".hotelNameFilterBtn.submitHotelName")
    private WebElement goButton;

    @FindBy(id="modalInterstitial")
    private WebElement waitingSign;

    @FindBy(id = "hotelResultTitle")
    private WebElement propertyCountTitle;

    @FindBy(id= "hotelResultTitle")
    private WebElement hotelResultTitle;

    private final PopUp popUpComponent = new PopUp(popUpContainer);

    public String getPropertyTitle() {
        return propertyCountTitle.getText();
    }

    public HotelSearchResults enterHotelName(String propertyName) {
        type(searchByPropertyInput, propertyName);
        isVisible(firstOption).isEnabled();
        click(firstOption);
        return this;
    }

    public PropertyResultPage clickGoButton() {
        click(goButton);
        isNotVisible(waitingSign);
        isVisible(hotelResultTitle);
        return new PropertyResultPage();
    }

    public String getTotalResults() {
        return propertyCountTitle.getText().split(" ")[2];
    }

    public PropertyResultPage results(){
      return new PropertyResultPage();
    }

}
