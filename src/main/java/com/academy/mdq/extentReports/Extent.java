package com.academy.mdq.extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static com.academy.mdq.properties.TestProperties.TEST_PROPERTIES;



public class Extent {

    private static ExtentHtmlReporter htmlReporter;
    private static String name = "MyReportOK";
    private static ExtentReports extent = getConfigExtent();
    private static ExtentTest test;
    private static int countPass = 0;
    private static int countFailed = 0;

    public Extent() {
        test = extent.createTest("OKTestReporter");
        getTest().log(Status.INFO, "Navigating into: " + TEST_PROPERTIES.getBaseUrl());
    }


    @BeforeClass
    private static void config() {
        htmlReporter = new ExtentHtmlReporter("C:/Users/juan.poli/Desktop/OKReports/" + name + ".html");
        extent = new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
        createResume();
    }

    public static ExtentReports getConfigExtent() {
        config();
        return extent;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static int getCountPass() {
        return countPass;
    }

    public static int getCountFailed() {
        return countFailed;
    }

    public int testPass() {
        return htmlReporter.getStatusCount().getParentCountPass();
    }

    public int testFail() {
        return htmlReporter.getStatusCount().getParentCountFail();
    }

    private void createResume() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("C:/Users/juan.poli/Desktop/OKReports/ResumeOK.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.countPass = testPass();
        this.countFailed = testFail();
        writer.println("Test pass: " + this.countPass);
        writer.println("Test Fail: " + this.countFailed);
        writer.close();
    }
}
