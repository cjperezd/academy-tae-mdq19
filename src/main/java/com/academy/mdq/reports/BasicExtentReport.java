package com.academy.mdq.reports;

import com.academy.mdq.driver.Drivers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasicExtentReport {

  static ExtentHtmlReporter htmlReporter;
  static List<ExtentTest> test = new ArrayList<>();
  static ExtentReports extent;

  public static ExtentTest getTest() {
    return test.get(test.size()-1);
  }

  public static void startReport() {
    htmlReporter = new ExtentHtmlReporter("src/test/resources/reports/ExtentReportResults.html");
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
  }

  public static void startTest(String description) {
    test.add(extent.createTest("AmazonTest", description));
  }

  @Test
  public void extentReportsDemo() throws IOException {
    System.setProperty("webdriver.chrome.driver", "D:/SubmittalExchange_TFS/QA/Automation/3rdparty/chrome/chromedriver.exe");
    WebDriver driver = Drivers.getDriver().getWebDriver();
    driver.get("https://www.google.co.in");
    if(driver.getTitle().equals("Google")) {
      getTest().log(Status.PASS, "Navigated to the specified URL");
    } else {
      getTest().log(Status.FAIL, "Test Failed");
    }
  }

  @AfterClass
  public static void endTest() {
    extent.flush();
  }

}
