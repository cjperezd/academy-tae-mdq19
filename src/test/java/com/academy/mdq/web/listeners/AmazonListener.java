package com.academy.mdq.web.listeners;

import com.academy.mdq.driver.Drivers;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import static com.academy.mdq.properties.TestWatcherProperties.TestWatcher_PROPERTIES;
import static com.academy.mdq.reports.Report.getTest;

public class AmazonListener extends TestWatcher {

  @Override
  protected void failed(Throwable e, Description description) {
    super.failed(e, description);
    String name = description.getDisplayName();
    name = System.getProperty("user.dir") + TestWatcher_PROPERTIES.getPath() + name + ".png";

    File screenShot = ((TakesScreenshot) Drivers.getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(screenShot, new File(name));
      getTest().fail("Verification for: " + e.getMessage() + ", failed.", MediaEntityBuilder.createScreenCaptureFromPath(name).build());
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
