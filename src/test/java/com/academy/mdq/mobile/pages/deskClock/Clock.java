package com.academy.mdq.mobile.pages.deskClock;

import com.academy.mdq.mobile.pages.deskClock.Components.ToolBar;
import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Clock extends MobilePage {

  @AndroidFindBy(id = "toolbar")
  private MobileElement toolbarContainer;

  public ToolBar getToolbar() {
    return new ToolBar(toolbarContainer);
  }
}
