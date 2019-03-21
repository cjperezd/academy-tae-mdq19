import com.academy.mdq.pages.CheapTickets.CheapTickets;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

public class MyTest extends BaseTestSuite {

    @Test
    public void myTest() {

        CheapTickets home = new CheapTickets();
        String text= ("Miami Beach");
        String inDate = ("06/05/2019");
        String outDate = ("06/15/2019");
        String adults = ("4");
        String childrens = ("1");
        String childrensYear = ("7");
        home.clickOn();
        home.writeOnHotelComp(text);
        home.writeOnCheckIn(inDate);
        home.writeOnCheckOut(outDate);
        home.writeAdults(adults);
        home.writeChildrens(childrens);
        home.writeChildrensYear(childrensYear);
        home.clickSearch();
        home.clickClosePopUp();
    }
}
