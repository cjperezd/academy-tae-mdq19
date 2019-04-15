package com.academy.mdq.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.academy.mdq.driver.Drivers.getDriver;
import static com.academy.mdq.properties.ReportProperties.REPORT_PROPERTIES;
import static com.academy.mdq.properties.TestProperties.TEST_PROPERTIES;
import static com.academy.mdq.properties.TestWatcherProperties.TEST_WATCHER_PROPERTIES;
import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath;
import static com.aventstack.extentreports.Status.FAIL;
import static com.aventstack.extentreports.Status.INFO;
import static java.lang.String.format;
import static java.lang.System.getProperty;
import static net.bytebuddy.utility.RandomString.make;
import static org.apache.commons.io.FileUtils.copyFile;
import static org.slf4j.LoggerFactory.getLogger;

public class Report {
  private static final Logger LOGGER = getLogger(Report.class);

  private static final ExtentHtmlReporter HTML_REPORTER = new ExtentHtmlReporter(getReportPath());
  private static final ExtentReports EXTENT_REPORTS = new ExtentReports();
  private static ExtentTest test;


  public static String getReportPath() {
    return getProperty("user.dir") + REPORT_PROPERTIES.getReportPath() +
        REPORT_PROPERTIES.getReportName() + LocalDate.now() + REPORT_PROPERTIES.getReportExt();
  }

  public static void startTest(String testName, String description) {
    EXTENT_REPORTS.attachReporter(HTML_REPORTER);
    test = EXTENT_REPORTS.createTest(testName, description);
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

  public static List<String> getReportStats (){
    List<String> stats = new ArrayList<>();
    stats.add("RESULTS");
    stats.add("Total: " + HTML_REPORTER.getStatusCount().getParentCount());
    stats.add("Passed: " + HTML_REPORTER.getStatusCount().getParentCountPass());
    stats.add("Failed: " + HTML_REPORTER.getStatusCount().getParentCountFail());
    HTML_REPORTER.getTestList().stream()
        .filter(test -> test.getStatus().equals(FAIL))
        .forEach(test -> stats.add(String.format("\tTest Failed: %s // %s", test.getName(),test.getDescription())));
    return stats;
  }

  private static void logScreenShotFailed(String message) {
    String name = getProperty("user.dir") + TEST_WATCHER_PROPERTIES.getPath() + make() + ".png";

    File screenShot = ((TakesScreenshot) getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
    try {
      copyFile(screenShot, new File(name));
      test.fail(message, createScreenCaptureFromPath(name).build());
    } catch (Exception e1) {
      LOGGER.error(e1.getLocalizedMessage(),e1);
    }
  }

  public static void finishReport() {
    EXTENT_REPORTS.flush();
  }

}
