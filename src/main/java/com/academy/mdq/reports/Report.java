package com.academy.mdq.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.time.LocalDate;

import static com.academy.mdq.properties.ReportProperties.REPORT_PROPERTIES;

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
    return test;
  }


  public static void finishReport() {
    extent.flush();
  }


}
