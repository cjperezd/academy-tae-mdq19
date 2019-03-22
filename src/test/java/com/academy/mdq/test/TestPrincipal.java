package com.academy.mdq.test;
import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.pages.HotelsPage;
import com.academy.mdq.pages.VacationPackagePage;
import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.waits.Waits;
import org.junit.Test;
import org.openqa.selenium.WebElement;




public class TestPrincipal extends BaseTestSuite {

    @Test
    public void test1() throws InterruptedException {
        VacationPackagePage vacationPackagePage= new VacationPackagePage();
        HotelsPage hotelsPage = new HotelsPage();

       hotelsPage = vacationPackagePage.pressbotton();

        hotelsPage = hotelsPage.completegoingto();
        hotelsPage = hotelsPage.completecheckin();
        hotelsPage = hotelsPage.completecheckout();


    }
}





