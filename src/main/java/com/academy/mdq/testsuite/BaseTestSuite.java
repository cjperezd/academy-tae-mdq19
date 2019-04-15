package com.academy.mdq.testsuite;

import com.academy.mdq.logger.Loggeable;
import com.academy.mdq.reports.Email;
import com.academy.mdq.rules.CustomErrorCollector;
import com.academy.mdq.rules.TestListener;
import org.hamcrest.Matcher;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;

import java.net.MalformedURLException;

import static com.academy.mdq.driver.Drivers.populateDriver;
import static com.academy.mdq.platform.Platform.WEB;
import static com.academy.mdq.properties.TestProperties.TEST_PROPERTIES;
import static com.academy.mdq.reports.Report.finishReport;
import static com.academy.mdq.server.SeleniumStandaloneServer.SERVER;
import static junit.framework.Assert.fail;


/**
 * BaseTestSuite represents the base suite for all the test suites in the test automation project.
 * A new suite should inherit BaseTestSuite functionality.
 */
public abstract class BaseTestSuite implements Loggeable {

  @Rule
  public CustomErrorCollector errorCollector = new CustomErrorCollector();

  @Rule
  public TestListener testListener = new TestListener();

  @BeforeClass
  public static void beforeClass() {
    if (WEB.equals(TEST_PROPERTIES.getPlatform())) {
      SERVER.start();
    }
  }

  @AfterClass
  public static void afterClass() {
    if (WEB.equals(TEST_PROPERTIES.getPlatform())) {
      SERVER.stop();
    }
    finishReport();
    Email e = new Email();
    e.sendEmail("TEST");
  }

  @Before
  public void before() {
    try {
      populateDriver(TEST_PROPERTIES.getPlatform(), TEST_PROPERTIES.getBrowser());
    } catch (MalformedURLException e) {
      fail("Unable to populateDriver an instance of the getDriver, please check the configuration.");
    }
  }

  protected <T> void checkThat(String reason, T value, Matcher<T> matcher) {
    errorCollector.checkThat(reason, value, matcher);
  }

}
