package com.academy.mdq.mobile.tests;
import com.academy.mdq.mobile.clock.application.Clock;
import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.waits.Waits;
import org.junit.Assert;
import org.junit.Test;

public class ClockTest extends BaseTestSuite {

    @Test
    public void myTest() throws InterruptedException {
        Clock clock = new Clock();

        clock.clickStopWatch();
        clock.clickOnPlayButton();
        clock.clickOnPauseButton();
        System.out.println("Time: " +clock.getTimeText());
        Assert.assertTrue(clock.isMinorThan());

    }
}