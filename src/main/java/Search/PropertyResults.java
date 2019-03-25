package Search;

import Complements.ResultSidebar;

import static com.academy.mdq.waits.Waits.isVisible;
import static com.academy.mdq.waits.Waits.waitForInvisibility;

public class PropertyResults extends ResultSidebar {

    public PropertyResults waiting() {
        waitForInvisibility(getWaitingDiv());
        return this;
    }

    public boolean isImgDivVisible() {
        return isVisible(getImgDiv()).isDisplayed();
    }

    public boolean isHotelLiEqual(String property) {
        return getHotelLi().getText().equals(property);
    }

    public String getHotel() {
       return getHotelLi().getText();
    }

    public boolean isHotelLiEnable() {
        return getHotelLi().isEnabled();
    }

    public boolean isAreaLiVisible() {
        return isVisible(getAreaLi()).isDisplayed();
    }

    public boolean isPhoneLiVisible() {
        return isVisible(getPhoneLi()).isDisplayed();
    }

    public boolean isStarLiVisible() {
        return isVisible(getStarLi()).isDisplayed();
    }

    public boolean isReviewLiVisible() {
        return isVisible(getReviewLi()).isDisplayed();
    }

    public boolean isPriceSpanVisible() {
        return isVisible(getPriceSpan()).isDisplayed();
    }
}
