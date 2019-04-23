package com.academy.mdq.okweb.pages.okpage.okpages;

import com.academy.mdq.okweb.pages.okpage.components.PrensaCard;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PrensaPage extends WebPage {

    @FindBy(className = "generic-page__bottom-blocks")
    private WebElement cardsContainer;

    @FindBy(className = "whynot__block--half-background ")
    private List<WebElement> cardsContainerList;


    private List<PrensaCard> prensaCardList = new ArrayList<>();

    public PrensaPage() {

    }

    public boolean areCardsContentVisible(int idx) {
        return getPrensaCardsOnList().get(idx).areElementsVisible();
    }

    public int getPrensaCardListSize() {
        return prensaCardList.size();
    }


    private List<PrensaCard> getPrensaCardsOnList() {
        cardsContainerList.forEach(card -> prensaCardList.add(new PrensaCard(card)));
        return prensaCardList;
    }
}
