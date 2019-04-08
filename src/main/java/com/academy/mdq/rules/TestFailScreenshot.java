package com.academy.mdq.rules;

import com.academy.mdq.driver.Drivers;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestFailScreenshot extends TestWatcher {

  @Override
  protected void failed(Throwable e, Description description) {
    String name = description.getDisplayName();
    System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
    File scrFile = ((TakesScreenshot) Drivers.getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
    String path = "src/test/resources/screenshots";
    try {
      FileUtils.copyFile(scrFile, new File(path + "/" + name + ".png"), true);
      System.out.println("Screenshot taken and saved");
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }

  @Override
  protected void finished(Description description) {
    super.finished(description);
    Drivers.dispose();
  }
}
