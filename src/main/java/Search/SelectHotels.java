package Search;

import Complements.NavegationBar;

public class SelectHotels extends NavegationBar {

    public HotelPage selectButton() {
        click(getHotelLink());
        return new HotelPage();
    }

}