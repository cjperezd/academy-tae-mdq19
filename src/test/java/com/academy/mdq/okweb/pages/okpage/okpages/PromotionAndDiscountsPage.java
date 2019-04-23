package com.academy.mdq.okweb.pages.okpage.okpages;

import com.academy.mdq.okweb.pages.okpage.components.commons.PromotionCard;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PromotionAndDiscountsPage extends WebPage {

    @FindBy (className = "swipe-slider--active-promotions")
    private WebElement promotionCardsContainer;

    @FindBy (className = "promotion-grid__item")
    private List<WebElement> promotionCards;

   PromotionCard promotionCard;


    public PromotionAndDiscountsPage (){
        this.promotionCard = new PromotionCard(promotionCardsContainer);
    }



    List<PromotionCard> promotionCardList = new ArrayList<>();


    public PromotionCard getPromotionCard(){
        return promotionCard;
    }

    public boolean areCardsDisplayed(int idx){
        return promotionCards.get(idx).isDisplayed();
    }

    public boolean areAllElementsVisible(int idx){
        return getPromotionCard().areElementsDisplayed();
    }

    public int listOfCardsSize(){
        return getCardsOnList().size();
    }

    public PromoCardPage clickOnCards(int idx){
        getCardsOnList().get(idx).clickOnCtaButton();
        return new PromoCardPage();
    }

    public OnePercentPage clickOnOnePercentCard(){
        getCardsOnList().get(9).clickOnCtaButton();
        return new OnePercentPage();
    }

    private List<PromotionCard> getCardsOnList() {
        promotionCards.forEach(card -> promotionCardList.add(new PromotionCard(card)));
        return promotionCardList;
    }

    private PromotionCard getCard(int idx){
        return promotionCardList.get(idx);
    }


}
