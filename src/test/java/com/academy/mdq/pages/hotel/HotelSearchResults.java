package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.commons.PopUp;
import com.academy.mdq.pages.hotel.components.HotelResultCard;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private WebElement hotelResultsTitle;

    @FindBy (className = "flex-link-wrap")
    private List<WebElement> cardsContainer;

    @FindBy (className = "neighborhoodTextLabel")
    private Set <String> areas;

    private final List<HotelResultCard> hotelResultCards = new ArrayList<>();

    private final PopUp popUpComponent = new PopUp(popUpContainer);


    public HotelSearchResults ()
    {
        super();
        cardsContainer.forEach(card -> hotelResultCards.add(new HotelResultCard(card)));
    }

    public String getHotelResultsTitle() {
        Waits.isVisible(hotelResultsTitle);
        return hotelResultsTitle.getText();
    }

    public HotelSearchResults enterHotelName(String propertyName) {
        type(searchByPropertyInput, propertyName);
        isVisible(firstOption).isEnabled();
        click(firstOption);
        return this;
    }

    public HotelSearchResults clickGoButton() {
        click(goButton);
        isNotVisible(waitingSign);
        Waits.areVisible(cardsContainer);
        return new HotelSearchResults();
    }

    public String getTotalResults() {
        return hotelResultsTitle.getText().split(" ")[2];
    }

    public Boolean areCardsFromNeighborhood(){

        for(HotelResultCard card : hotelResultCards)
        {
            if (!areas.contains(card.getCityName()))
            {
                return false;
            }
        }

        return true;
    }

    public HotelResultCard selectCard(int card){
        return hotelResultCards.get(card);
    }



}
