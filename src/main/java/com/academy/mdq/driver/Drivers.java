package com.academy.mdq.driver;

import com.academy.mdq.browser.Browsers;
import com.academy.mdq.logger.Loggeable;
import com.academy.mdq.platform.Platform;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.academy.mdq.properties.TestProperties.TEST_PROPERTIES;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Drivers manages the creation of different {@link org.openqa.selenium.WebDriver} instances, supporting parallel execution
 * by using {@link ThreadLocal} to store the WebDriver instance per thread.
 */
public final class Drivers implements Loggeable {

  private static final ThreadLocal<Driver> DRIVERS = new ThreadLocal<>();

  /**
   * Creates an instance of {@link Driver}.
   * The {@link org.openqa.selenium.WebDriver} instance will be instantiated with the desired platform capabilities.
   *
   * @param platform the {@link Platform}
   * @param browsers the {@link Browsers}
   * @return the {@link Driver}
   * @throws MalformedURLException if the URL of the remote server is invalid
   */
  public static void populateDriver(Platform platform, Browsers browsers) throws MalformedURLException {
    if (DRIVERS.get() == null) {
      WebDriver webdriver;
      switch (platform) {
        case MOBILE:
          webdriver = new AppiumDriver(new URL(TEST_PROPERTIES.getRemoteAppiumUrl()), browsers.getCapabilities());
          break;
        case WEB: {
          webdriver = new RemoteWebDriver(new URL(TEST_PROPERTIES.getRemoteServerUrl()), browsers.getCapabilities());
          webdriver.manage().timeouts().pageLoadTimeout(TEST_PROPERTIES.getPageLoadTimeout(), SECONDS);
          webdriver.manage().timeouts().setScriptTimeout(TEST_PROPERTIES.getScriptTimeout(), SECONDS);
          webdriver.manage().timeouts().implicitlyWait(TEST_PROPERTIES.getImplicitWait(), SECONDS);
          webdriver.manage().window().maximize();
          webdriver.get(TEST_PROPERTIES.getBaseUrl());
        }
        break;
        default:
          webdriver = new RemoteWebDriver((URL) null, null);
      }
      DRIVERS.set(new Driver(platform, browsers, webdriver));
    }
  }

  /**
   * Gets the instance previously created and stored at thread-level of the getDriver.
   *
   * @return the {@link Driver}
   */
  public static Driver getDriver() {
    return DRIVERS.get();
  }

  /**
   * Dispose the getDriver, releasing the session between the client and the server.
   * The platform will be closed.
   */
  public static void dispose() {
    DRIVERS.get().getWebDriver().quit();
  }

}
