package com.academy.mdq.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.academy.mdq.reports.SendReportEmail.writeTestInfo;
import static com.aventstack.extentreports.Status.*;

public class BasicExtentReport {

  static String reportFolder = "src/test/resources/reports";
  static final ExtentHtmlReporter HTMLREPORTER = new ExtentHtmlReporter(reportFolder + "/ExtentReportResults.html");
  static ExtentReports EXTENT = new ExtentReports();
  static List<ExtentTest> TESTS = new ArrayList<>();

  public static ExtentTest getTest() {
    return TESTS.get(TESTS.size()-1);
  }

  public static void startTest(String testName, String description) {
    EXTENT.attachReporter(HTMLREPORTER);
    TESTS.add(EXTENT.createTest(testName, description));
  }

  @AfterClass
  public static void endTest() {
    EXTENT.flush();
    LinkedHashMap<Object, Object> values = new LinkedHashMap<>();
    values.put("Total of Tests: ", HTMLREPORTER.getTestList().size());
    values.put("Total of PASSED Tests: ", HTMLREPORTER.getStatusCount().getParentCountPass());
    HTMLREPORTER.getTestList().stream()
        .filter(t -> t.getStatus().equals(PASS))
        .forEach(t -> values.put(t.getID(), t.getDescription()));
    values.put("Total of FAILED Tests: ", HTMLREPORTER.getStatusCount().getParentCountFail());
    HTMLREPORTER.getTestList().stream()
        .filter(t -> t.getStatus().equals(FAIL))
        .forEach(t -> values.put(t.getID(), t.getDescription()));
    values.put("Total of SKIPPED Tests: ", HTMLREPORTER.getStatusCount().getParentCountSkip());
    HTMLREPORTER.getTestList().stream()
        .filter(t -> t.getStatus().equals(SKIP))
        .forEach(t -> values.put(t.getID(), t.getDescription()));
    writeTestInfo(reportFolder, values);
  }

}
