package com.academy.mdq.reports;

import com.academy.mdq.driver.Drivers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import static com.academy.mdq.properties.ReportProperties.REPORT_PROPERTIES;
import static com.academy.mdq.properties.TestProperties.TEST_PROPERTIES;
import static com.academy.mdq.properties.TestWatcherProperties.TestWatcher_PROPERTIES;
import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath;
import static com.aventstack.extentreports.Status.INFO;
import static java.lang.String.format;
import static java.lang.System.getProperty;

public class Report {
  private static final ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(getReportPath());
  private static final ExtentReports extent = new ExtentReports();
  private static ExtentTest test;
  private static String statsFilePath = "C:\\Users\\lucia.corrales\\Desktop\\Proyectos Academy\\WebFinal\\academy-tae-mdq19\\testReport\\stat.txt";

  public static String getReportPath() {
    return getProperty("user.dir") + REPORT_PROPERTIES.getReportPath() +
        REPORT_PROPERTIES.getReportName() + LocalDate.now() + REPORT_PROPERTIES.getReportExt();
  }

  public static void startTest(String testName, String description) {
    extent.attachReporter(htmlReporter);
    test = extent.createTest(testName, description);
    logInfo(INFO, format(REPORT_PROPERTIES.navigating(), TEST_PROPERTIES.getBaseUrl()));
  }

  public static void logInfo(Status status, String message) {
    switch (status) {
      case INFO:
        test.info(message);
        break;
      case FAIL:
        logScreenShotFailed(message);
        break;
      case PASS:
        test.pass(message);
        break;
      case SKIP:
        test.skip(message);
        break;
    }
  }

  public static void writeStats() {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(statsFilePath, "UTF-8");
      writer.println("RESULTS:");
      writer.println("Total: " + htmlReporter.getStatusCount().getParentCount());
      writer.println("Passed = " + htmlReporter.getStatusCount().getParentCountPass());
      writer.println("Failed = " + htmlReporter.getStatusCount().getParentCountFail());
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  public static String getStatsPath (){
    return statsFilePath;
  }

  public static void logScreenShotFailed(String message) {
    String name = RandomString.make();
    name = getProperty("user.dir") + TestWatcher_PROPERTIES.getPath() + name + ".png";

    File screenShot = ((TakesScreenshot) Drivers.getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(screenShot, new File(name));
      test.fail(message, createScreenCaptureFromPath(name).build());
    } catch (Exception e1) {
      throw new RuntimeException(e1);
    }
  }

  public static void finishReport() {
    extent.flush();
    writeStats();
  }

}
