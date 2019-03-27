package com.academy.mdq.pages.hotel;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.common.components.CalendarComp;
import com.academy.mdq.pages.common.components.DatePickerCalendar;
import com.academy.mdq.pages.common.components.Search;
import com.academy.mdq.pages.hotel.components.HotelSearchForm;
import net.sf.cglib.core.Local;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class HotelSearch extends WebPage implements Search {

    @FindBy (className = "wizard-background")
    private WebElement searchHotelPage;

    @FindBy (className = "datepicker-cal")
    private WebElement wholeCalendar;

    private final HotelSearchForm hotelSearchForm = new HotelSearchForm(searchHotelPage);
    private final CalendarComp calendarComp = new CalendarComp(wholeCalendar);

    public HotelSearchForm typeGoingTo(String goingTo) {
        return hotelSearchForm.typeGoingTo(goingTo);
    }

    public HotelSearchForm selectCheckIn(LocalDate checkIn){
        return hotelSearchForm.selectCheckIn(checkIn);
    }

    public HotelSearchForm selectCheckOut(LocalDate checkOut, int checkInMonth){
        return hotelSearchForm.selectCheckOut(checkOut,checkInMonth);
    }

    public HotelSearchForm typeCheckIn(String checkIn) {
        return hotelSearchForm.typeCheckIn(checkIn);
    }

    public HotelSearchForm typeCheckOut(String checkOut) {
        return hotelSearchForm.typeCheckOut(checkOut);
    }

    public HotelSearchForm selectAdults(String adults) {
        return hotelSearchForm.selectAdults(adults);
    }

    public HotelSearchForm selectChildrens(String children) {
        return hotelSearchForm.selectChildren(children);
    }

    public HotelSearchForm selectChildrensYear(String childrenYear) {
        return hotelSearchForm.selectChildrenYear(childrenYear);
    }

    public HotelSearchResult clickSearch() {
        return hotelSearchForm.clickSearch();
    }
}
