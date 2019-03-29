package com.academy.mdq.mobile.pages;

import com.academy.mdq.page.mobile.MobilePage;
import com.academy.mdq.waits.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ClockPage extends MobilePage {

  @AndroidFindBy(id = "Stopwatch")
  private MobileElement chronoButton;

  @AndroidFindBy(id = "fab")
  private MobileElement redButton;

  @AndroidFindBy(id = "stopwatch_time_text")
  private MobileElement timeClock;

  public ClockPage selectChrono() {
    click(chronoButton);
    return this;
  }

  public ClockPage pressButton() {
    click(redButton);
    return this;
  }

  public ClockPage setWaitingTime(int sec){
    Waits.waitingSec(timeClock, sec);
    return this;
  }

  public int getWaitingSec() {
    String[] finalTime = timeClock.getAttribute("contentDescription").split(" ");
    return Integer.valueOf(finalTime[2]);
  }

}
