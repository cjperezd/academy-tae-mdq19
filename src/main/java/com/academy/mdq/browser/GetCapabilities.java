package com.academy.mdq.browser;

import org.openqa.selenium.Capabilities;

/**
 * GetCapabilities represent a contract for any new Browser to be supported as part of the framework.
 */
public interface GetCapabilities {

  /**
   * Gets capabilities.
   *
   * @return the {@link Capabilities}
   */
  Capabilities getCapabilities();

}
