package com.academy.mdq.extentReports.errorCollector;

import com.academy.mdq.driver.Drivers;
import com.academy.mdq.extentReports.Extent;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matcher;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertThat;

public class CheckError extends ErrorCollector {
    private Extent extent = new Extent();

    @Override
    public <T> void checkThat(String reason, T value, Matcher<T> matcher) {
        super.checkThat(reason, value, matcher);
        checkSucceeds((Callable<Object>) () -> {
            assertThat(reason, value, matcher);
            pass();
            return value;
        });
    }

    @Override
    public <T> T checkSucceeds(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Throwable e) {
            addError(e);
            failed();
            return null;
        }

    }

    private void failed() {
        String nameTest = RandomString.make();
        String name = "C:/Users/juan.poli/Desktop/Screenshots/" + nameTest + ".png";

        File screenshot = ((TakesScreenshot) Drivers.getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(name));
            extent.getTest().fail("Failed!!", MediaEntityBuilder.createScreenCaptureFromPath(name).build());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void pass() {
        extent.getTest().log(Status.PASS, "The test pass the assertion");
    }

    public void callTear() {
        extent.tearDown();
    }


}
