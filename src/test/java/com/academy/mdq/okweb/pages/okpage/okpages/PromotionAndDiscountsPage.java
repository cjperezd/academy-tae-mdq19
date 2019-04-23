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



    List<PromotionCard> promotionCardList = new ArrayList<>();


    private List<PromotionCard> getCardsOnList() {
        promotionCards.forEach(card -> promotionCardList.add(new PromotionCard(card)));
        return promotionCardList;
    }

    public PromotionCard getFirstCard() {
        return getCardsOnList().stream().findFirst().get();
    }

    public String getTitleFirstCard(){
        return getFirstCard().getTitle();
    }
}
