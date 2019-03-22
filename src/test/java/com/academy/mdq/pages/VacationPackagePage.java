package com.academy.mdq.pages;


import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

public class VacationPackagePage extends WebPage {

        @FindBy (id="tab-hotel-tab-hp")
        private WebElement hotelbotton;

        public HotelsPage pressbotton(){
            hotelbotton.click();
            return new HotelsPage();

            Waits.isClickable()
        }
    }




}
