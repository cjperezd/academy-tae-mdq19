package com.academy.mdq.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.academy.mdq.properties.TestProperties.TEST_PROPERTIES;


@RunWith(Parameterized.class)
public class Extent {

    private static ExtentHtmlReporter htmlReporter;
    private static com.aventstack.extentreports.ExtentReports extent2;
    private static String name = "MyReport";
    private static ExtentReports extent = getConfigExtent();
    private static ExtentTest test;

    public Extent() {
        test = extent.createTest("AmazonTestReporter");
        getTest().log(Status.INFO, "Navigating into: " + TEST_PROPERTIES.getBaseUrl());

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

    public static ExtentTest getTest() {
        return test;
    }
}
