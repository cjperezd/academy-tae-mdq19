import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;

public class HotelsPage extends WebPage {

    @FindBy (id="hotel-destination-hp-hotel")
    private WebElement goingto;
    @FindBy (id="hotel-checkin-hp-hotel")
    private WebElement checkin;
    @FindBy (id= "hotel-checkout-hp-hotel")
    private WebElement checkout;
    @FindBy (id= "hotel-1-children-hp-hotel")
    private WebElement children;
    @FindBy (id= "hotel-1-age-select-1-hp-hotel")
    private WebElement agechild;
    @FindBy (css="#gcw-hotel-form-hp-hotel > div:nth-child(11) > label > button")
    private WebElement search;

    public HotelsPage completegoingto (){
        click(goingto);
        type(goingto,"Miami,Florida");
        return this;
    }

    public HotelsPage completecheckin(){
        click(checkin);
        checkin.clear();
        type(checkin, "04/09/2019");
        return this;
    }

    public HotelsPage completecheckout(){
        click(checkout);
        checkout.clear();
        type(checkout,"04/24/2019");
        return this;

        Waits.isVisible()
    }

}
