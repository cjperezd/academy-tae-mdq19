package com.academy.mdq.properties;

import java.io.IOException;
import java.util.Properties;

public enum TestWatcherProperties {

  TEST_WATCHER_PROPERTIES;

    private static final String FILE_NAME = "testwatcher.properties";
    private static final String FOLDER_PATH = "folderPath";

    private Properties properties = new Properties();

    private String getProperty(String propertyName){
      if(properties.isEmpty()){
        try {
          properties.load(this.getClass().getClassLoader().getResourceAsStream(FILE_NAME));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return properties.getProperty(propertyName);
    }

    public String getPath(){
      return getProperty(FOLDER_PATH);
    }

}
