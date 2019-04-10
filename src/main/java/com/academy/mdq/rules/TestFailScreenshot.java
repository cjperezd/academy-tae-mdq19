package com.academy.mdq.rules;

import com.academy.mdq.driver.Drivers;
import com.academy.mdq.reports.BasicExtentReport;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestFailScreenshot extends TestWatcher {

  @Override
  protected void finished(Description description) {
    super.finished(description);
    BasicExtentReport.endTest();
    Drivers.dispose();
  }
}
