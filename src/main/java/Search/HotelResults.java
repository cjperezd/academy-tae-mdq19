package Search;

import Complements.ResultSidebar;
import com.academy.mdq.waits.Waits;
import org.junit.Assert;

import static com.academy.mdq.waits.Waits.isVisible;

public class HotelResults extends ResultSidebar {

    private HotelResults closePopUp() {
        if (isVisible(getPopUpDiv()).isDisplayed()) {
            click(getPopUpButton());
        }
        return this;
    }

    public HotelResults verifyResults(String destination) {
        isVisible(getResultsHeader());
        String[] results = getResultsHeader().getText().split(":");
        Assert.assertEquals(results[0], destination);
        Assert.assertNotEquals(results[1], "0 properties");
        return this;
    }

    public HotelResults searchProperty(String property) {
        //closePopUp();
        type(getPropertyInput(), property);
        click(getFirstOption());
        return this;
    }

    public PropertyResults selectGo() {
        click(getGoButton());
        Waits.waitForInvisibility(getWaitingDiv());
        return new PropertyResults();
    }
}
