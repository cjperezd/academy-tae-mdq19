package com.academy.mdq.reports;

import org.slf4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Properties;

import static org.slf4j.LoggerFactory.getLogger;

public class SendReportEmail {

  private static final Logger LOGGER = getLogger(SendReportEmail.class);

  public static void sendReport(String destination, String subject) {

    String origin = "anona1316@gmail.com";
    String password = "Anonimus12345";

    Properties props = new Properties();

    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(origin, password);
          }
        });
    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(origin));
      message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destination));

      message.setSubject(subject);

      Multipart multipart = new MimeMultipart();

      multipart.addBodyPart(readFile("src/test/resources/reports/testsInfo.txt"));

      multipart.addBodyPart(addFile("src/test/resources/reports/ExtentReportResults.html"));

      message.setContent(multipart);

      Transport.send(message);

      System.out.println("=====Email Sent=====");

    } catch (AddressException e2) {
      LOGGER.error(e2.getMessage(), e2);
    } catch (MessagingException e3) {
      LOGGER.error(e3.getMessage(), e3);
    }
  }

  private static BodyPart readFile(String path) {
    BodyPart messageBody = new MimeBodyPart();
    String content;
    try {
      content = new String(Files.readAllBytes(Paths.get(path)));
      messageBody.setText(content);
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
    } catch (MessagingException e) {
      LOGGER.error(e.getMessage(), e);
    }
    return messageBody;
  }

  private static BodyPart addFile(String path) {
    MimeBodyPart messageBody = new MimeBodyPart();
    String filename = path;
    DataSource source = new FileDataSource(filename);
    try {
      messageBody.setDataHandler(new DataHandler(source));
      messageBody.setFileName(filename);
    } catch (MessagingException e) {
      LOGGER.error(e.getMessage(), e);
    }
    return messageBody;
  }

  public static void writeTestInfo(String filePath, LinkedHashMap<Object, Object> map) {
    PrintWriter writer;
    try {
      writer = new PrintWriter(filePath + "/testsInfo.txt", "UTF-8");
      map.forEach((k,v) -> writer.println(String.format("%S %S", k, v)));
      writer.close();
    } catch (FileNotFoundException e) {
      LOGGER.error(e.getMessage(), e);
    } catch (UnsupportedEncodingException e) {
      LOGGER.error(e.getMessage(), e);
    }
  }



}