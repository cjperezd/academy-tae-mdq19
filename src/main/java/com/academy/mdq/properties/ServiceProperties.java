package com.academy.mdq.properties;

import java.io.IOException;
import java.util.Properties;

public enum ServiceProperties {

  SERVICE_PROPERTIES;

  private static final String URL = "url";

  private static final Properties properties = new Properties();
  private static final String FILE_NAME = "service.properties";

  public String getUrl(){
    return getProperty(URL);
  }

  public String getProperty(String propertyName){
    if (properties.isEmpty()){
      try {
        properties.load(this.getClass().getClassLoader().getResourceAsStream(FILE_NAME));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return properties.getProperty(propertyName);
  }
}