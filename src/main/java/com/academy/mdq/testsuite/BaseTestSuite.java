package com.academy.mdq.testsuite;

import com.academy.mdq.extentReports.EmailReport;
import com.academy.mdq.extentReports.errorCollector.CheckError;
import com.academy.mdq.logger.Loggeable;
import org.hamcrest.Matcher;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;

import java.net.MalformedURLException;

import static com.academy.mdq.driver.Drivers.populateDriver;
import static com.academy.mdq.platform.Platform.WEB;
import static com.academy.mdq.properties.TestProperties.TEST_PROPERTIES;
import static com.academy.mdq.server.SeleniumStandaloneServer.SERVER;
import static java.lang.String.format;
import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

/**
 * BaseTestSuite represents the base suite for all the test suites in the test automation project.
 * A new suite should inherit BaseTestSuite functionality.
 */

public abstract class BaseTestSuite implements Loggeable {


  @Rule
  public CheckError checkError = new CheckError();

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
  }

  @Before
  public void before() {
    try {
      populateDriver(TEST_PROPERTIES.getPlatform(), TEST_PROPERTIES.getBrowser());
    } catch (MalformedURLException e) {
      fail("Unable to populateDriver an instance of the getDriver, please check the configuration.");
    }
  }

  /*@After
  public void after() {
    dispose();
  }*/

  /**
   * Checks for the equality of two Strings.
   *
   * @param expected the expected String
   * @param actual   the actual String
   */
  protected void checkEquals(String expected, String actual) {
    assertEquals(format("Error: Expected '%s', but was '%s'", expected, actual), expected, actual);
  }

  public <T> void checkThat(String reason, T value, Matcher<T> matcher) {
    checkError.checkThat(reason, value, matcher);
  }

  public void callTear() {
    checkError.callTear();
  }


  @AfterClass
    public static void sendEmails() {
        EmailReport emailReport = new EmailReport();
        emailReport.sendEmail();
    }
}
