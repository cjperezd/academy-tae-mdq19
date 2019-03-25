package com.academy.mdq.pages.CheapTickets;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.CheapTickets.components.SearchBar;
import com.academy.mdq.pages.CheapTickets.components.SearchHotelComp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheapTickets extends WebPage {

    @FindBy(css = ".site-header.site-header-secondary.site_70301.en_US")
    private WebElement searchBarElement;

    @FindBy(className = "wizard-background")
    private WebElement hotelComp;

    SearchBar searchBar = new SearchBar(searchBarElement);
    SearchHotelComp searchHotelComp = new SearchHotelComp(hotelComp);

    public CheapTickets clickOn() {
        //Waits.isVisible(searchBar.getButtonHotel());
        click(searchBar.getButtonHotel());
        return new CheapTickets();
    }
}
