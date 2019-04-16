package com.academy.mdq.properties;

import java.io.IOException;
import java.util.Properties;

public enum ReportProperties {

  REPORT_PROPERTIES;

  private static final String FILE_NAME = "reports.properties";
  private static final String REPORT_PATH = "report.path";
  private static final String REPORT_NAME = "report.name";
  private static final String REPORT_EXT = "extension";
  private static final String NAVIGATING = "navigating";
  private static final String CLICKING = "clicking";
  private static final String SELECTING = "selecting";
  private static final String TYPING = "typing";

  private Properties properties = new Properties();

  private String getProperty(String propertyName) {
    if (properties.isEmpty()) {
      try {
        properties.load(this.getClass().getClassLoader().getResourceAsStream(FILE_NAME));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return properties.getProperty(propertyName);
  }

  public String getReportPath() {
    return getProperty(REPORT_PATH);
  }

  public String getReportExt() {
    return getProperty(REPORT_EXT);
  }

  public String getReportName() {
    return getProperty(REPORT_NAME);
  }

  public String navigating() {
    return getProperty(NAVIGATING);
  }

  public String clicking() {
    return getProperty(CLICKING);
  }

  public String selecting() {
    return getProperty(SELECTING);
  }

  public String typing() {
    return getProperty(TYPING);
  }

}
