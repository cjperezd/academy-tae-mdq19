package com.academy.mdq.driver.capabilities;

import com.academy.mdq.logger.Loggeable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.lang.String.format;

/**
 * CapabilitiesReader loads the capabilities specified in a file.
 */
public enum CapabilitiesReader implements Loggeable {

  CAPABILITIES_READER;

  /**
   * Reads capabilities from file.
   *
   * @param file the file name
   * @return a {@link Map} with the capabilities, key value pair
   */
  public Map<String, Object> readCapabilities(String file) {

    // NOTE: This is just a simple example to show how to get capabilities from a file (JSON, XML, YAML, etc,)

    Map<String, Object> propertiesAsMap = new HashMap<>();
    try {
      Properties properties = new Properties();
      properties.load(this.getClass().getClassLoader().getResourceAsStream(file));
      properties.forEach((key, value) -> propertiesAsMap.put(String.valueOf(key), value));
    } catch (IOException e) {
      error(format("Unable to read capabilities from file: %s - %s", file, e.getMessage()));
    }
    return propertiesAsMap;
  }
}
