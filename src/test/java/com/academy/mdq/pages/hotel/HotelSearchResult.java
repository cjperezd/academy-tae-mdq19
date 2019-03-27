package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.hotel.components.HotelSearchCard;
import com.academy.mdq.pages.hotel.components.HotelSearchFilters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    public HotelSearchResult() {
        super();
    }

    public List<HotelSearchCard> getCardsOnList(){
        cardsContainer.forEach(card -> listOfCards.add(new HotelSearchCard(card)));
        return listOfCards;
    }

    public Set<String> getAreas(){
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
}
