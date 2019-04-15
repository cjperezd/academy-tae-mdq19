package com.academy.mdq.rules;

import com.academy.mdq.driver.Drivers;
import com.academy.mdq.reports.BasicExtentReport;
import com.aventstack.extentreports.MediaEntityBuilder;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import static com.academy.mdq.reports.BasicExtentReport.getTest;
import static com.aventstack.extentreports.Status.INFO;
import static com.aventstack.extentreports.Status.PASS;
import static org.slf4j.LoggerFactory.getLogger;

public final class ExtendErrorCollector extends ErrorCollector {

  private static final Logger LOGGER = getLogger(ExtendErrorCollector.class);

  @Override
  public <T> void checkThat(final String reason, final T value, final Matcher<T> matcher) {
    getTest().log(INFO, "Checking if: " + reason);
    this.checkSucceeds((Callable<Object>) () -> {
      Assert.assertThat(reason, value, matcher);
      getTest().log(PASS, "Check passed");
      return value;
    });
  }

  @Override
  public <T> T checkSucceeds(Callable<T> callable) {
    String path = "C:/Users/ariana.mazzini/Desktop/academy-web-final/academy-tae-mdq19src/test/resources/reports/screenshots/" + RandomString.make() + ".png";
    try {
      return callable.call();
    } catch (Throwable var3) {
      this.addError(var3);
      System.out.println("\nError: " + var3.getClass().getSimpleName() + "\n");
      File scrFile = ((TakesScreenshot) Drivers.getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
      try {
        FileUtils.copyFile(scrFile, new File(path), true);
        BasicExtentReport.getTest().fail("Type of error: " + var3.getClass().getSimpleName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        System.out.println("=====Screenshot taken and saved=====\n");
      } catch (IOException e1) {
        LOGGER.error(e1.getMessage(), e1);
      }
      return null;
    }
  }

}
