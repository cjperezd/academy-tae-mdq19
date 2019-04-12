package com.academy.mdq.web.listeners;

import com.academy.mdq.driver.Drivers;
import com.academy.mdq.reports.Report;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static com.aventstack.extentreports.Status.FAIL;


public class AmazonListener extends TestWatcher {

//  @Override
//  protected void failed(Throwable e, Description description) {
//    super.failed(e, description);
//    Report.logInfo(FAIL, e.getMessage());
//  }

  @Override
  protected void finished(Description description) {
    super.finished(description);
    Drivers.dispose();
  }

}
