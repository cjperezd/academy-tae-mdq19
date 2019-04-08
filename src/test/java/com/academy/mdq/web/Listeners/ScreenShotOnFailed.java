package com.academy.mdq.web.Listeners;

import com.academy.mdq.driver.Drivers;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import static com.academy.mdq.properties.TestWatcherProperties.TestWatcher_PROPERTIES;

public class ScreenShotOnFailed extends TestWatcher {

  @Override
  protected void failed(Throwable e, Description description) {
    super.failed(e, description);
    String name = description.getDisplayName();
    name = System.getProperty("user.dir") + TestWatcher_PROPERTIES.getPath() + name + ".png";

    File screenShot = ((TakesScreenshot) Drivers.getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(screenShot, new File(name));
    } catch (Exception e1) {
      throw new RuntimeException(e1);
    }
  }

  @Override
  protected void finished(Description description) {
    super.finished(description);
    Drivers.dispose();
  }

}
