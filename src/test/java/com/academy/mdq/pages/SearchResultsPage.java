package com.academy.mdq.pages;

import com.academy.mdq.components.PopUp;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.mdq.waits.Waits.*;

public class SearchResultsPage extends WebPage {

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

    private PopUp popUpComponent;

    public String getPropertyTitle() {
        return propertyCountTitle.getText();
    }

    public SearchResultsPage() {
        super();
        popUpComponent = new PopUp(popUpContainer);
    }

    public SearchResultsPage enterHotelName(String propertyName) {
        //popUpComponent.closePopUp(this, popUpContainer);
        type(searchByPropertyInput, propertyName);
        isVisible(firstOption).isEnabled();
        click(firstOption);
        return this;
    }

    public PropertyResultPage clickGoButton() {
        click(goButton);
        isNotVisible(waitingSign);
        Waits.isVisible(hotelResultTitle);
        return new PropertyResultPage();
    }

    public String getPropertyQuantity() {
        String result = propertyCountTitle.getText();

        String[] titleArray = result.split(" ");

        return titleArray[2];
    }

}
