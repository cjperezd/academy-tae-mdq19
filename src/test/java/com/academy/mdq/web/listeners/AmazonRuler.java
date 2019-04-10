package com.academy.mdq.web.listeners;

import com.academy.mdq.reports.Report;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.rules.ErrorCollector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.academy.mdq.reports.Report.*;
import static com.academy.mdq.reports.Report.getTest;

public class AmazonRuler extends ErrorCollector {
  private List<Throwable> errors = new ArrayList();

  public <T> void checkThat(final String reason, final T value, final Matcher<T> matcher) {
    this.checkSucceeds((Callable<Object>) () -> {
      Assert.assertThat(reason, value, matcher);
      getTest().pass(reason);
      return value;
    });
  }

  public <T> T checkSucceeds(Callable<T> callable) {
    try {
      return callable.call();
    } catch (Throwable var3) {
      this.addError(var3);
      logScreenShotFailed(var3);
      return null;
    }
  }


}
