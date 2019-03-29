package com.academy.mdq.mobile.clock.application;

import com.academy.mdq.mobile.clock.components.Toolbar;
import com.academy.mdq.page.mobile.MobilePage;
import com.academy.mdq.waits.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Clock extends MobilePage {

    @AndroidFindBy (id = "desk_clock_pager")
        private MobileElement deskPageContainer;

    @AndroidFindBy (id = "toolbar")
        private MobileElement toolbarContainer;

    @AndroidFindBy (id = "fab")
        private MobileElement playButton;

    @AndroidFindBy (id = "stopwatch_time_text")
    private MobileElement stopWatchTime;


    private Toolbar toolbar = new Toolbar(toolbarContainer);



    public void clickStopWatch(){
        toolbar.clickOnStopwatch();
    }

    public void clickOnPlayButton(){
        click(playButton);
    }

    public void clickOnPauseButton() throws InterruptedException {
        Waits.waitTSeconds(stopWatchTime,"contentDescription","20");
        click(playButton);
    }

    public String getTimeText(){
        return stopWatchTime.getAttribute("contentDescription").split(" ")[2];
    }

    public boolean isMinorThan() {
        int seconds = Integer.parseInt(getTimeText());
        return seconds < 25;
    }


}
