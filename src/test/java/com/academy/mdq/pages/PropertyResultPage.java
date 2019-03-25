package com.academy.mdq.pages;


import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.hotel.components.HotelResultCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PropertyResultPage extends WebPage {

    @FindBy (className = "flex-link-wrap")
    private List<WebElement> cardsContainer;

    private final List<HotelResultCard> hotelResultCards = new ArrayList<>();

    private int selectedCard;

    public PropertyResultPage () {
        super();
        cardsContainer.forEach(card -> hotelResultCards.add(new HotelResultCard(card)));
    }

    public HotelResultCard selectCard(int card){
      return hotelResultCards.get(card);
    }

    public String getHotelName ()
    {
        return hotelResultCards.get(selectedCard).getHotelName();
    }

    public Boolean isNameEnabled ()
    {
        return hotelResultCards.get(selectedCard).isNameEnabled();
    }

    public Boolean isVisibleImage ()
    {
        return hotelResultCards.get(selectedCard).isVisibleImage();
    }

    public Boolean isVisibleCity ()
    {
        return hotelResultCards.get(selectedCard).isVisibleCity();
    }

    public Boolean isVisiblePhone ()
    {
        return hotelResultCards.get(selectedCard).isVisiblePhone();
    }

    public Boolean isVisibleStars ()
    {
        return hotelResultCards.get(selectedCard).isVisibleStars();
    }

    public Boolean isVisibleRate () { return hotelResultCards.get(selectedCard).isVisibleRate(); }

    public Boolean isVisibleNightlyPrice ()
    {
        return hotelResultCards.get(selectedCard).isVisibleNightlyPrice();
    }

    public Boolean areCards(Set<String> locations){
      // TODO
      return true;
    }

    public int getCurrentResults(){
      return hotelResultCards.size();
    }

}
