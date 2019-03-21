package com.academy.mdq.pages.CheapTickets;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.page.web.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends WebComponent {

    protected SearchBar(WebElement container) {
        super(container);
    }

    @FindBy (id = "primary-header-hotel")
    private WebElement buttonHotel;

    public WebElement getButtonHotel() {
        return buttonHotel;
    }
}
