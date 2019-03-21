package com.academy.mdq.pages.CheapTickets;

import com.academy.mdq.driver.Driver;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import com.academy.mdq.pages.CheapTickets.SearchBar;
import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;

public class CheapTickets extends WebPage {

    @FindBy (xpath = "//*[@id=\"header-container\"]/div[2]/div[8]")
    private WebElement searchBarElement;

    @FindBy (className = "wizard-background")
            private WebElement hotelComp;

    @FindBy (className = "modal-body")
    private WebElement popUpComp;

    SearchBar searchBar = new SearchBar(searchBarElement);
    SearchHotelComp searchHotelComp = new SearchHotelComp(hotelComp);
    PopUpClass popUpClass = new PopUpClass(popUpComp);

    public CheapTickets clickOn(){
        Waits.isVisible(searchBar.getButtonHotel());
        click(searchBar.getButtonHotel());
        return new CheapTickets();
    }

    public void print (){
        System.out.println("Elemento Button: " + searchBar.getButtonHotel());
    }

    public CheapTickets writeOnHotelComp(String text){
        type(searchHotelComp.getInputGoingTo(),text);
        return this;
    }

    public CheapTickets writeOnCheckIn(String text){
        type(searchHotelComp.getInputCheckIn(),text);
        return this;
    }

    public CheapTickets writeOnCheckOut(String text){
        type(searchHotelComp.getInputCheckOut(),text);
        return this;
    }

    public CheapTickets writeAdults(String adults){
        type(searchHotelComp.getInputAdults(),adults);
        return this;
    }

    public CheapTickets writeChildrens(String childrens){
        type(searchHotelComp.getInputChildrens(),childrens);
        return this;
    }

    public CheapTickets writeChildrensYear(String childrensYear){
        type(searchHotelComp.getChildrensYear(),childrensYear);
        return this;
    }

    public CheapTickets clickSearch(){
        click(searchHotelComp.getSearchButton());
        return new CheapTickets();
    }

    public CheapTickets clickClosePopUp(){
        if(popUpComp.isDisplayed()) {
            click(popUpClass.getClosePopUp());
        }
        return new CheapTickets();
    }
}
