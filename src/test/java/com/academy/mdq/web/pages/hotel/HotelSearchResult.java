package com.academy.mdq.web.pages.hotel;

import com.academy.mdq.driver.Drivers;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.hotel.components.HotelSearchCard;
import com.academy.mdq.web.pages.hotel.components.HotelSearchFilters;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class HotelSearchResult extends WebPage {

    @FindBy(id = "bcol")
    private WebElement wrapAll;

    @FindBy (id = "hotelNameGoBtn")
    private WebElement hotelNameButton;

    @FindBy(className = "flex-link-wrap")
    private List<WebElement> cardsContainer;

    @FindBy(css = ".neighborhood.secondary ")
    private List<WebElement> areaOfCity;

    @FindBy(id = "searchForm")
    private WebElement searchSecondPage;

    @FindBy(className = "modal-body")
    private WebElement popUpComp;


    private final HotelSearchFilters hotelSearchFilters = new HotelSearchFilters(searchSecondPage);


    private List<HotelSearchCard> listOfCards = new ArrayList<>();
    private Set<String> areas = new HashSet<>();
    private List <WebElement> hotelsName = new ArrayList<>();


    public HotelSearchResult() {
        super();
    }

    public List<HotelSearchCard> getCardsOnList(){
        cardsContainer.forEach(card -> listOfCards.add(new HotelSearchCard(card)));
        return listOfCards;
    }

    public Set<String> getAreas(){
        Waits.isVisible(wrapAll);
        return areas = this.areaOfCity.stream().map(area -> area.getText()).collect(toSet());
    }

    public HotelSearchFilters typeHotelName(String hotelName) {
        return hotelSearchFilters.typeHotelName(hotelName);
    }

    public String getTotalResults() {
        return hotelSearchFilters.getTotalResults();
    }

    public String getAllWords() {
        return hotelSearchFilters.getAllWords();
    }

    public HotelSearch clickOnFirstOptionFae() {
        return hotelSearchFilters.clickOnFirstOptionFae();
    }

    public HotelSearchResult clickHotelSearchButton() {
        click(hotelNameButton);
        return new HotelSearchResult();
    }

    public HotelSearchCard selectACard(int index){
        return listOfCards.get(index);
    }

    public boolean areAreasInTheCards(){
        return listOfCards.stream().allMatch(card -> getAreas().contains(card.getCityName()));
    }

    public HotelDetails getFirstHotel() {
        Waits.isVisible(wrapAll);
        return getCardsOnList().stream().findFirst().get().selectHotel();
    }


    public HotelDetails switchToNewWindow(){
        for (String handle : Drivers.getDriver().getWebDriver().getWindowHandles()) {
            Drivers.getDriver().getWebDriver().switchTo().window(handle);
        }
        return new HotelDetails();
    }

}
