package com.academy.mdq.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class BasicExtentReport {

  static ExtentHtmlReporter htmlReporter;
  static List<ExtentTest> test = new ArrayList<>();
  static ExtentReports extent;
  static String reportFolder = "src/test/resources/reports";

  public static ExtentTest getTest() {
    return test.get(test.size()-1);
  }

  public static void startReport() {
    htmlReporter = new ExtentHtmlReporter(reportFolder + "/ExtentReportResults.html");
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
  }

  public static void startTest(String description) {
    test.add(extent.createTest("AmazonTest", description));
  }

  @AfterClass
  public static void endTest() {
    extent.flush();
    writeFile();
  }

  private static void writeFile() {
    PrintWriter writer;
    try {
      writer = new PrintWriter(reportFolder + "/testsInfo.txt", "UTF-8");
      writer.println("Total Tests: " + htmlReporter.getTestList().size());
      writer.println("   Test PASSED: " + htmlReporter.getStatusCount().getParentCountPass());
      writer.println("   Test FAILED: " + htmlReporter.getStatusCount().getParentCountFail());
      writer.println("   Test SKIPPED: " + htmlReporter.getStatusCount().getParentCountSkip());
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
