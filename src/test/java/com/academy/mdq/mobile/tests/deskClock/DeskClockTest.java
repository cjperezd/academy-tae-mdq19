package com.academy.mdq.mobile.tests.deskClock;

import com.academy.mdq.mobile.pages.deskClock.Clock;
import com.academy.mdq.mobile.pages.deskClock.StopWatch;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;

public class DeskClockTest extends BaseTestSuite {

  @Test
  public void StopWatchTest() {

    Clock clock = new Clock();

    StopWatch st = clock.getToolbar().clickStopWatchButton();
    st.start();
    st.stopAtTime("20");
    Assert.assertTrue(st.isBetween(20, 25));


  }
}
