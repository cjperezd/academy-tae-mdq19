package com.academy.mdq.pages.CheapTickets;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.CheapTickets.components.CalendarComp;
import com.academy.mdq.pages.CheapTickets.components.SearchHotelComp;
import com.academy.mdq.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotelPage extends WebPage {

    @FindBy (className = "wizard-background")
    private WebElement searchHotelPage;

    @FindBy (className = "datepicker-cal")
    private WebElement wholeCalendar;

    SearchHotelComp searchHotelComp = new SearchHotelComp(searchHotelPage);
    CalendarComp calendarComp = new CalendarComp(wholeCalendar);


    public SearchHotelPage writeOnHotelComp(String text) {
        Waits.isClickable(searchHotelComp.getInputGoingTo());
        searchIsVisible();
        type(searchHotelComp.getInputGoingTo(), text);
        return this;
    }

    public SearchHotelPage writeOnCheckIn(String text) {
        searchIsVisible();
        type(searchHotelComp.getInputCheckIn(), text);
        return this;
    }

    public SearchHotelPage clickOnFirstOption() {
        click(searchHotelComp.getClickOnFirstOption());
        return this;
    }

    public SearchHotelPage writeOnCheckOut(String text) {
        jsClear(searchHotelComp.getInputCheckOut());
        type(searchHotelComp.getInputCheckOut(), text);
        return this;
    }

    public SearchHotelPage writeAdults(String adults) {
        type(searchHotelComp.getInputAdults(), adults);
        return this;
    }

    public SearchHotelPage writeChildrens(String childrens) {
        type(searchHotelComp.getInputChildrens(), childrens);
        return this;
    }

    public SearchHotelPage writeChildrensYear(String childrensYear) {
        type(searchHotelComp.getChildrensYears(), childrensYear);
        return this;
    }

    public SearchHotelPage clickSearch() {
        click(searchHotelComp.getSearchButton());
        return new SearchHotelPage();
    }

    private void searchIsVisible() {
        Waits.isVisible(searchHotelPage);
    }

    /*public void clickCheckInCalendarDay()
    {
        click(searchHotelComp.getInputCheckIn());
        click(calendarComp.getCalendarDay());
    }*/


}
