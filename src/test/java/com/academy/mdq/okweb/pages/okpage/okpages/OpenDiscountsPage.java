package com.academy.mdq.okweb.pages.okpage.okpages;

import com.academy.mdq.okweb.pages.okpage.components.DiscountCards;
import com.academy.mdq.okweb.pages.okpage.components.DiscountsMenu;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class OpenDiscountsPage extends WebPage {

    @FindBy(className = "discount__menu")
    private WebElement discountMenuContainer;

    @FindBy(className = "discount__category__title")
    private List<WebElement> categoryTitleList;

    @FindBy(className = "card__content")
    private List<WebElement> cardsContent;

    @FindBy(className = "card---wrapper")
    private List<WebElement> cardContainer;

    private DiscountsMenu discountsMenu;
    private List<DiscountCards> discountCardList = new ArrayList<>();

    public OpenDiscountsPage() {
        this.discountsMenu = new DiscountsMenu(discountMenuContainer);
    }


    public List<DiscountCards> getDiscountCardsOnList() {
        cardContainer.forEach(card -> discountCardList.add(new DiscountCards(card)));
        return discountCardList;
    }


    public DiscountsMenu getDiscountsMenu() {
        return discountsMenu;
    }

    public boolean isTheRightCategory(int idx) {
        getDiscountsMenu().clickCategory(idx);
        return getDiscountsMenu().getCategoryText(idx).equals(getCategoryTitle(idx));
    }

    public boolean areCardsElementsVisible(int idx){
        return getDiscountCardsOnList().get(idx).areCardElementsVisible();
    }

    public int getSizeOfCardList(){
        return discountCardList.size();
    }

    private String getCategoryTitle(int idx) {
        return categoryTitleList.get(idx).getText();
    }


}
