package com.academy.mdq.mobile.tests.deskClock;

import com.academy.mdq.mobile.pages.deskClock.Clock;
import com.academy.mdq.mobile.pages.deskClock.StopWatch;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DeskClockTest extends BaseTestSuite {

  @Test
  public void StopWatchTest() {

    StopWatch st = new Clock()
        .getToolbar()
        .clickStopWatchButton()
        .start()
        .stopAtTime("20");

    assertTrue("The value in the stopWatch is between 20 and 20 secs", st.isBetween(20, 25));


  }
}
