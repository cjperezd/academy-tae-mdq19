package com.academy.mdq.okweb.pages.okpage.okpages;

import com.academy.mdq.okweb.pages.okpage.components.DiscountCards;
import com.academy.mdq.okweb.pages.okpage.components.HelpCards;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HelpPage extends WebPage {

    @FindBy (className = "equal-height-child")
    private List<WebElement> cardContainer;

    @FindBy(className = "heading-1--content")
    private WebElement titleContent;

    @FindBy(className = "contact__communications__title")
    private WebElement cardsTitle;

    @FindBy(className = "equal-height-parent")
    private WebElement cardsContainer;

    private List<HelpCards> helpCardList = new ArrayList<>();

    public HelpPage() {

    }

    public List<HelpCards> getHelpCardsOnList() {
        cardContainer.forEach(card -> helpCardList.add(new HelpCards(card)));
        return helpCardList;
    }

    public boolean areAllElementsDisplayed() {
        return titleContent.isDisplayed() && cardsTitle.isDisplayed() && cardsContainer.isDisplayed();
    }

    public int getHelpCardsSize(){
        return helpCardList.size();
    }


    public boolean areContentsVisible (int idx){
        return getHelpCardsOnList().get(idx).areContentVisible();
    }

}
