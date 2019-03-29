package com.academy.mdq.web.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.web.pages.complements.ResultCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.areVisible;
import static com.academy.mdq.waits.Waits.waitForInvisibility;

public class PropertyResultsPage extends WebPage {

    @FindBy(className = "flex-link-wrap")
    private List<WebElement> cardsDiv;

    @FindBy(id = "modalInterstitial")
    private WebElement waitingDiv;

    private final ResultCard firstCard = new ResultCard(cardsDiv.get(0));

    public PropertyResultsPage waiting() {
        waitForInvisibility(waitingDiv);
        areVisible(cardsDiv);
        return this;
    }

    public boolean isFirstImgDivVisible() {
        return firstCard.isImgDivVisible();
    }

    public boolean isFirstHotelLiEnable() {
        return firstCard.isHotelLiEnable();
    }

    public boolean isFirstHotelLiEqual(String property) {
        return firstCard.isHotelLiEqual(property);
    }

    public boolean isFirstAreaLiVisible() {
        return firstCard.isAreaLiVisible();
    }

    public boolean isFirstPhoneLiVisible() {
        return firstCard.isPhoneLiVisible();
    }

    public boolean isFirstStarLiVisible() {
        return firstCard.isStarLiVisible();
    }

    public boolean isFirstReviewLiVisible() {
        return firstCard.isReviewLiVisible();
    }

    public boolean isFirstPriceSpanVisible() {
        return firstCard.isPriceSpanVisible();
    }

}
