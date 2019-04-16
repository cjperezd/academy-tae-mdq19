package com.academy.mdq.rules;

import org.hamcrest.Matcher;
import org.junit.rules.ErrorCollector;

import java.util.concurrent.Callable;

import static com.academy.mdq.reports.Report.logInfo;
import static com.aventstack.extentreports.Status.FAIL;
import static com.aventstack.extentreports.Status.PASS;
import static org.junit.Assert.assertThat;

public class CustomErrorCollector extends ErrorCollector {

  public <T> void checkThat(final String reason, final T value, final Matcher<T> matcher) {
    this.checkSucceeds((Callable<Object>) () -> {
      assertThat(reason, value, matcher);
      logInfo(PASS, reason);
      return value;
    });
  }

  public <T> T checkSucceeds(Callable<T> callable) {
    try {
      return callable.call();
    } catch (Throwable var3) {
      this.addError(var3);
      logInfo(FAIL, var3.getMessage());
      return null;
    }
  }


}
