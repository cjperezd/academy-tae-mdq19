package com.academy.mdq.reports;

import com.academy.mdq.driver.Drivers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.time.LocalDate;

import static com.academy.mdq.properties.ReportProperties.REPORT_PROPERTIES;
import static com.academy.mdq.properties.TestProperties.TEST_PROPERTIES;
import static com.academy.mdq.properties.TestWatcherProperties.TestWatcher_PROPERTIES;

public class Report {
  private static final ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(getReportPath());
  private static final ExtentReports extent = new ExtentReports();
  private static ExtentTest test;

  private static String getReportPath() {
    return System.getProperty("user.dir") + REPORT_PROPERTIES.getReportPath() +
        REPORT_PROPERTIES.getReportName() + LocalDate.now() + REPORT_PROPERTIES.getReportExt();
  }

  public static ExtentTest getTest() {
    return test;
  }

  public static ExtentTest getNewTest(String testName, String description) {
    extent.attachReporter(htmlReporter);
    test = extent.createTest(testName, description);
    getTest().log(Status.INFO, "Navigating to [" + TEST_PROPERTIES.getBaseUrl() + "].");
    return test;
  }


  public static void finishReport() {
    extent.flush();
  }


  public static void logScreenShotFailed(Throwable e) {
    String name = RandomString.make();
    name = System.getProperty("user.dir") + TestWatcher_PROPERTIES.getPath() + name + ".png";

    File screenShot = ((TakesScreenshot) Drivers.getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(screenShot, new File(name));
      getTest().fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(name).build());
    } catch (Exception e1) {
      throw new RuntimeException(e1);
    }
  }


}
