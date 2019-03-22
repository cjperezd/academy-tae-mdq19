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

    @FindBy(css = ".site-content.cols-row cf")
    private WebElement backgroundDiv;

    private PopUp popUpComponent;

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


    public String getPropertyTitle() {
        return propertyCountTitle.getText();
    }

    public SearchResultsPage() {
        super();
        popUpComponent = new PopUp(popUpContainer);
    }

    private SearchResultsPage closePopUp() {
        if (isVisible(popUpContainer).isDisplayed()) {
            click(popUpComponent.getCloseButton());
        }
        return this;
    }

    public SearchResultsPage enterHotelName(String propertyName) {
        type(searchByPropertyInput, propertyName);
        isVisible(firstOption);
        click(firstOption);
        return this;
    }

    public PropertyResultPage clickGoButton() {
        click(goButton);
        isNotVisible(waitingSign);
        return new PropertyResultPage();
    }

    public String getPropertyQuantity() {
        String result = propertyCountTitle.getText();

        String[] titleArray = result.split(" ");

        return titleArray[2];
    }

}
