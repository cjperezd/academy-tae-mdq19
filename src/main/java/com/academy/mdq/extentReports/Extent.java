package com.academy.mdq.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;


@RunWith(Parameterized.class)
public class Extent {

    private static ExtentHtmlReporter htmlReporter;
    private static com.aventstack.extentreports.ExtentReports extent2;
    private static String name = "MyReport";
    private static ExtentReports extent = getConfigExtent();
    private static ExtentTest test;

    public Extent (){
        test = extent.createTest("AmazonTestReporter");
    }


    @BeforeClass
    private static void config() {
        htmlReporter = new ExtentHtmlReporter("C:/Users/juan.poli/Desktop/Reports/" + name + ".html");
        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
    }

    public static ExtentReports getConfigExtent() {
        config();
        return extent;
    }

    private boolean failed(boolean condition, ExtentTest test) {
        return !condition;
    }

    private boolean passTest(boolean condition, ExtentTest test) {
        return condition;
    }

    public void testState(boolean condition, ExtentTest test, String testName) throws IOException {
        test.log(Status.INFO, testName + " Assert: name product matches with the search");
        if (failed(condition, test)) {
            test.log(Status.ERROR, "The test do not pass the " + testName + " Assertion");
            test.addScreenCaptureFromPath("C:/Users/juan.poli/Desktop/Screenshots");
        } else if (passTest(condition, test))
            test.log(Status.PASS, "The " + testName + " Assertion passed the test");
    }

    public static ExtentTest getTest(){
        return test;
    }
}
