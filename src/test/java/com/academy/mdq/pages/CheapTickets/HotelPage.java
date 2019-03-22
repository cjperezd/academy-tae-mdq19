package com.academy.mdq.pages.CheapTickets;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelPage extends WebPage {

    @FindBy(id = "searchForm")
    private WebElement searchSecondPage;

    @FindBy(className = "flex-link-wrap ")
    private WebElement card;

    @FindBy(className = "modal-body")
    private WebElement popUpComp;


    SecondSearchPageComp secondSearchPageComp = new SecondSearchPageComp(searchSecondPage);
    CardComponent cardComponent = new CardComponent(card);
    PopUpClass popUpClass = new PopUpClass(popUpComp);


    public HotelPage writeHotelName(String hotelName) {
        type(secondSearchPageComp.getInputHotelName(), hotelName);
        return this;
    }

    public HotelPage clickHotelSearchButton() {
        click(secondSearchPageComp.getHotelNameButton());
        return new HotelPage();
    }

    public String[] getTheTitle() {
        String arr = new String();
        arr = secondSearchPageComp.getHotelResultTitle().getText();
        String[] array = arr.split(" ");
        return array;
    }

    public String getAllWords() {
        String arr;
        return arr = secondSearchPageComp.getHotelResultTitle().getText();
    }

    public HotelPage clickOnFirstOptionFae() {
        click(secondSearchPageComp.getClickFirstOptionFae());
        return new HotelPage();
    }

    public boolean cardImageVisible() {
        return cardComponent.getCardImage().isDisplayed();
    }

    public boolean cardHotelName() {
        return cardComponent.getHotelName().isDisplayed();
    }

    public boolean cardCityName() {
        return cardComponent.getCityArea().isDisplayed();
    }

    public boolean cardPhone() {
        return cardComponent.getPhone().isDisplayed();
    }

    public boolean cardStars() {
        return cardComponent.getStars().isDisplayed();
    }

    public boolean cardRate() {
        return cardComponent.getRate().isDisplayed();
    }

    public boolean cardNightlyClass() {
        return cardComponent.getActualPrice().isDisplayed();
    }


    public String getHotelTitle() {
        String arr;
        return arr = cardComponent.getHotelName().getText();
    }

     /*public void clickClosePopUp() {
        click(secondSearchPageComp.getInputHotelName());
    }*/

}
