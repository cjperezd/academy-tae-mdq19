package com.academy.mdq.pages.hotel.components;
import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.pages.hotel.HotelSearch;
import com.academy.mdq.pages.hotel.HotelSearchResult;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchFilters extends WebComponent {

    @FindBy (id = "inpHotelNameMirror")
    private WebElement inputHotelName;

    @FindBy (className = "section-header-main")
    private WebElement hotelResultTitle;

    @FindBy (id = "hotelNameGoBtn")
    private WebElement hotelNameButton;

    @FindBy (id = "aria-option-0")
    private WebElement clickFirstOptionFae;

    @FindBy (id = "modalInterstitial")
    private WebElement waitSearch;

    public HotelSearchFilters(WebElement container) {
        super(container);
    }

    public HotelSearchFilters typeHotelName(String hotelName) {
        type(inputHotelName, hotelName);
        return this;
    }

    public HotelSearch clickHotelSearchButton() {
        click(hotelNameButton);
        return new HotelSearch();
    }

    public String getTotalResults() {
        Waits.isVisible(hotelResultTitle);
        String arr = hotelResultTitle.getText().split(" ")[2];
        return arr;
    }

    public String getAllWords() {
        String arr;
        return arr = hotelResultTitle.getText();
    }

    public HotelSearch clickOnFirstOptionFae() {
        click(clickFirstOptionFae);
        return new HotelSearch();
    }
}
