package com.academy.mdq.mobile.clock.components;

import com.academy.mdq.mobile.clock.application.Clock;
import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Toolbar extends MobileComponent {

    public Toolbar(MobileElement container) {
        super(container);
    }

    @AndroidFindBy (accessibility = "Alarm")
        private MobileElement alarmButton;

    @AndroidFindBy (accessibility = "Clock")
        private MobileElement clockButton;

    @AndroidFindBy (accessibility = "Timer")
        private MobileElement timerButton;

    @AndroidFindBy (accessibility = "Stopwatch")
        private MobileElement stopWatch;


    public Clock clickOnStopwatch (){
        click(stopWatch);
        return new Clock();
    }


}
