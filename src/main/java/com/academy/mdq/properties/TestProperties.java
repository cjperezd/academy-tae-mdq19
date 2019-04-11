package com.academy.mdq.properties;

import com.academy.mdq.browser.Browsers;
import com.academy.mdq.platform.Platform;

import java.io.IOException;
import java.util.Properties;

import static com.academy.mdq.browser.Browsers.CHROME;
import static com.academy.mdq.platform.Platform.WEB;
import static java.lang.System.getProperty;
import static java.lang.System.getenv;

/**
 * TestProperties manages (load / return) the test properties.
 */
public enum TestProperties {

  TEST_PROPERTIES;

  private static final String ENVIRONMENT = "environment";
  private static final String BASE_URL = "base.url";
  private static final String REMOTE_SERVER_URL = "remote.server.url";
  private static final String REMOTE_APPIUM_URL = "remote.appium.url";
  private static final String IMPLICIT_WAIT = "implicit.wait";
  private static final String EXPLICIT_WAIT = "explicit.wait";
  private static final String POLLING_EVERY = "polling.every";
  private static final String PAGE_LOAD_TIMEOUT = "page.load.timeout";
  private static final String SCRIPT_TIMEOUT = "script.timeout";
  private static final String PLATFORM = "platform";
  private static final String BROWSER = "browser";
  private static final String DEFAULT_ENVIRONMENT = "qa";

  private static Properties properties = new Properties();

  /**
   * Returns the base URL.
   *
   * @return the application base URL as {@link String}
   */
  public String getBaseUrl() {
    return getTestProperty(BASE_URL);
  }

  /**
   * Returns the remote server URL.
   *
   * @return the remote server URL to execute the automation as {@link String}
   */
  public String getRemoteServerUrl() {
    return getTestProperty(REMOTE_SERVER_URL);
  }

  /**
   * Returns the remote server URL for the Appium Server.
   *
   * @return the remote server URL to execute mobile testing as {@link String}
   */
  public String getRemoteAppiumUrl() {
    return getTestProperty(REMOTE_APPIUM_URL);
  }

  /**
   * Returns the WebDriver implicit wait.
   *
   * @return the implicit wait as {@link Long}
   */
  public Long getImplicitWait() {
    return Long.valueOf(getTestProperty(IMPLICIT_WAIT));
  }

  /**
   * Returns the WebDriver explicit wait.
   *
   * @return the explicit wait as {@link Long}
   */
  public Long getExplicitWait() {
    return Long.valueOf(getTestProperty(EXPLICIT_WAIT));
  }

  /**
   * Returns the polling every modifier to apply to the explicit waits.
   *
   * @return the polling every as {@link Long}
   */
  public Long getPollingEvery() {
    return Long.valueOf(getTestProperty(POLLING_EVERY));
  }

  /**
   * Returns the page load timeout.
   *
   * @return the page load timeout as {@link Long}
   */
  public Long getPageLoadTimeout() {
    return Long.valueOf(getTestProperty(PAGE_LOAD_TIMEOUT));
  }

  /**
   * Returns the script timeout.
   *
   * @return the script timeout as {@link Long}
   */
  public Long getScriptTimeout() {
    return Long.valueOf(getTestProperty(SCRIPT_TIMEOUT));
  }

  /**
   * Gets the browser name.
   * The supported browsers are based on {@link Browsers}
   *
   * @return the browser enumeration representing the browser name
   */
  public Browsers getBrowser() {
    String browser = get(BROWSER);
    if (browser == null) {
      return CHROME;
    } else {
      return Browsers.valueOf(browser.toUpperCase());
    }
  }

  /**
   * Gets the platform name.
   * The supported platforms are based on {@link Platform}
   *
   * @return the platform enumeration representing the platform name
   */
  public Platform getPlatform() {
    String platform = get(PLATFORM);
    if (platform == null) {
      return WEB;
    } else {
      return Platform.valueOf(platform.toUpperCase());
    }
  }

  /**
   * Gets the test property from the property file represented as [environment].properties.
   *
   * @param propertyName the property name
   * @return the property value
   */
  private String getTestProperty(String propertyName) {
    if (properties.isEmpty()) {
      try {
        StringBuilder propertyFile = new StringBuilder();
        String environment = get(ENVIRONMENT);
        if (environment == null) {
          environment = DEFAULT_ENVIRONMENT;
        }
        propertyFile.append(environment).append(".properties");
        properties.load(this.getClass().getClassLoader().getResourceAsStream(propertyFile.toString()));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return properties.getProperty(propertyName);
  }

  /**
   * Gets value from {@link System#getProperty(String)}, or from {@link System#getenv()}.
   *
   * @param key the key
   * @return the value
   */
  private static String get(String key) {
    String environment = getProperty(key);
    if (environment == null) {
      environment = getenv(key);
    }
    return environment;
  }
}
