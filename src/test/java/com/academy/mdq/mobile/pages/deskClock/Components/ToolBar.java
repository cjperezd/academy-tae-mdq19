package com.academy.mdq.mobile.pages.deskClock.Components;

import com.academy.mdq.mobile.pages.deskClock.StopWatch;
import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ToolBar extends MobileComponent {

  @AndroidFindBy(className = "android.support.v7.app.ActionBar$Tab")
  private List<MobileElement> toolBarbuttons;

  private MobileElement alarmButton;

  private MobileElement clockButton;

  private MobileElement timerButton;

  private MobileElement stopWatchButton;

  public ToolBar(MobileElement container) {
    super(container);
    alarmButton = toolBarbuttons.get(0);
    clockButton = toolBarbuttons.get(1);
    timerButton = toolBarbuttons.get(2);
    stopWatchButton = toolBarbuttons.get(3);
  }

  public StopWatch clickStopWatchButton() {
    click(stopWatchButton);
    return new StopWatch();
  }

}



