package com.academy.mdq.properties;

import java.io.IOException;
import java.util.Properties;

public enum EmailProperties {

  EMAIL_PROPERTIES;

  private static final String FILE_NAME = "email.properties";
  private static final String HOST = "mail.smtp.host";
  private static final String PORT = "mail.smtp.port";
  private static final String AUTH = "mail.smtp.auth";
  private static final String STARTTLS = "mail.smtp.starttls.enable";
  private static final String USER = "mail.smtp.user";
  private static final String PASS = "mail.smtp.pass";


  private static Properties properties = new Properties();


  public static Properties getProperties() {
    if (properties.isEmpty()) {
      try {
        properties.load(EmailProperties.class.getClassLoader().getResourceAsStream(FILE_NAME));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return properties;
  }

  public static String getUser (){ return getProperties().getProperty(USER);}
  public static String getPass (){ return getProperties().getProperty(PASS);}

}
