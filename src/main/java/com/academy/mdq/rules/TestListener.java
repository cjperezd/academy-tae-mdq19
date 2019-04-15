package com.academy.mdq.rules;

import com.academy.mdq.driver.Drivers;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static com.academy.mdq.reports.BasicExtentReport.startTest;

public final class TestListener extends TestWatcher {

  @Override
  public void starting(Description description) {
    super.starting(description);
    startTest(description.getTestClass().getSimpleName(), description.getMethodName());
  }

  @Override
  protected void finished(Description description) {
    super.finished(description);
    Drivers.dispose();
  }
}