package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.complements.ResultCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.mdq.waits.Waits.waitForInvisibility;

public class PropertyResults extends WebPage {

    @FindBy(css = "div .flex-link-wrap")
    private List<WebElement> cardsDiv;

    @FindBy(id = "modalInterstitial")
    private WebElement waitingDiv;

    private final ResultCard firstCard= new ResultCard(cardsDiv.get(0));

    public PropertyResults waiting() {
        waitForInvisibility(waitingDiv);
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
