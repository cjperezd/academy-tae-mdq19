package com.academy.mdq.rules;

import com.academy.mdq.driver.Drivers;
import com.academy.mdq.reports.BasicExtentReport;
import com.aventstack.extentreports.MediaEntityBuilder;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import static com.academy.mdq.reports.BasicExtentReport.getTest;
import static com.aventstack.extentreports.Status.PASS;

public class ExtendErrorCollector extends ErrorCollector {

  @Override
  public <T> void checkThat(final String reason, final T value, final Matcher<T> matcher) {
    this.checkSucceeds((Callable<Object>) () -> {
      Assert.assertThat(reason, value, matcher);
      getTest().log(PASS, "Check successfull");
      return value;
    });
  }

  @Override
  public <T> T checkSucceeds(Callable<T> callable) {
    try {
      return callable.call();
    } catch (Throwable var3) {
      this.addError(var3);
      String name = RandomString.make();
      System.out.println(name + " " + var3.getClass().getSimpleName() + "\n");
      File scrFile = ((TakesScreenshot) Drivers.getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
      String path = "src/test/resources/reports/screenshots";
      try {
        FileUtils.copyFile(scrFile, new File(path + "/" + name + ".png"), true);
        BasicExtentReport.getTest().fail("Test failed: ", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\ariana.mazzini\\Desktop\\academy-web-final\\academy-tae-mdq19\\src\\test\\resources\\reports\\screenshots\\" + name + ".png").build());
        System.out.println("Screenshot taken and saved");
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      return null;
    }
  }

}
