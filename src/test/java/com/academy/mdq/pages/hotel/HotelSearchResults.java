package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.commons.PopUp;
import com.academy.mdq.pages.hotel.components.HotelResultCard;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.waits.Waits.*;

public class HotelSearchResults extends WebPage {

    @FindBy(css = ".modal-body")
    private WebElement popUpContainer;

    @FindBy(id = "inpHotelNameMirror")
    private WebElement searchByPropertyInput;

    @FindBy(id = "aria-option-0")
    private WebElement firstOption;

    @FindBy(css = ".hotelNameFilterBtn.submitHotelName")
    private WebElement goButton;

    @FindBy(id = "modalInterstitial")
    private WebElement waitingSign;

    @FindBy(id = "hotelResultTitle")
    private WebElement hotelResultsTitle;

    @FindBy(className = "flex-link-wrap")
    private List<WebElement> cardsContainer;

    @FindBy(className = "neighborhoodTextLabel")
    private List<WebElement> areas;

    @FindBy (css = "#neighborhoodContainer .more:not(.visuallyhidden)")
    private WebElement showMoreButton;

    private final List<HotelResultCard> hotelResultCards = new ArrayList<>();

    private final PopUp popUpComponent = new PopUp(popUpContainer);

    private List<String> areasNames = new ArrayList<>();

    public HotelSearchResults() {
        super();
        areVisible(cardsContainer);
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
        areVisible(cardsContainer);
        return new HotelSearchResults();
    }

    public String getTotalResults() {
        return hotelResultsTitle.getText().split(" ")[2];
    }

    public void getAreaNames ()
    {
        clickShowMore();
        for (WebElement area : areas) {
            areasNames.add(area.getText());
        }
    }

    public boolean areCardsFromNeighborhood() {
        areVisible(cardsContainer);
        getAreaNames();
        return hotelResultCards.stream().allMatch(card -> areasNames.contains(card.getCityName()));
    }

    public HotelResultCard selectCard(int card) {
        return hotelResultCards.get(card);
    }

    public void clickShowMore ()
    {
        click(showMoreButton);
    }

}
