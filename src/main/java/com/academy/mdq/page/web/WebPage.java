package com.academy.mdq.page.web;

import com.academy.mdq.driver.Driver;
import com.academy.mdq.reports.BasicExtentReport;
import com.aventstack.extentreports.Status;

import static com.academy.mdq.driver.Drivers.getDriver;
import static com.academy.mdq.reports.BasicExtentReport.*;
import static com.aventstack.extentreports.Status.*;
import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class WebPage extends WebOperations {

  protected WebPage() {
    Driver driver = getDriver();
    initElements(driver.getWebDriver(), this);
    getTest().log(INFO, "Navigating to: " + driver.getWebDriver().getCurrentUrl());
    getTest().log(INFO, "At page: " + this.getClass().getName());
  }

}
