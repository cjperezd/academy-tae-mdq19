package com.academy.mdq.mobile.pages.deskClock;

import com.academy.mdq.page.mobile.MobilePage;
import com.academy.mdq.waits.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StopWatch extends MobilePage {

  @AndroidFindBy(id = "fab")
  private MobileElement playStopButton;

  @AndroidFindBy(id = "stopwatch_time_text")
  private MobileElement timeElapsedText;

  @AndroidFindBy(id = "stopwatch_time")
  private MobileElement time;

  public StopWatch start() {
    click(playStopButton);
    return this;
  }

  private StopWatch stop() {
    click(playStopButton);
    return this;
  }

  public StopWatch stopAtTime(String secs) {
    Waits.isTime(timeElapsedText,"contentDescription", "0 minutes " + secs + " second");
    click(playStopButton);
    return this;
  }


  public String readTime() {
    return timeElapsedText.getAttribute("contentDescription");
  }

  public int returnSecs ()
  {
    String time = readTime();
    String[] timeArray = time.split(" ");
    String secs = timeArray[2];
    return Integer.parseInt(secs);
  }

  public boolean isBetween (int minSecs, int maxSecs)
  {
    if (returnSecs() <= maxSecs && returnSecs()>=minSecs)
    {
      return true;
    }
    return false;
  }


}
