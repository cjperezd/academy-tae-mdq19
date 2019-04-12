package com.academy.mdq.reports;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class SendReportEmail {

  public static void sendEmail() {

    Properties props = new Properties();

    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("anona1316@gmail.com", "Anonimus12345");
          }
        });
    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("anona1316@gmail.com"));
      message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("ari.mazzini.98@gmail.com"));

      // Add the subject link
      message.setSubject("Amazon Tests");

      // Create object to add multimedia type content
      BodyPart messageBodyPart1 = new MimeBodyPart();

      String content;

      try {
        content = new String(Files.readAllBytes(Paths.get("src/test/resources/reports/testsInfo.txt")));
        messageBodyPart1.setText(content);
      } catch (IOException e) {
        e.printStackTrace();
      }

      // Create another object to add another content
      MimeBodyPart messageBodyPart2 = new MimeBodyPart();

      // Mention the file which you want to send
      String filename = "src/test/resources/reports/ExtentReportResults.html";

      // Create data source and pass the filename
      DataSource source = new FileDataSource(filename);

      // set the handler
      messageBodyPart2.setDataHandler(new DataHandler(source));

      // set the file
      messageBodyPart2.setFileName(filename);

      // Create object of MimeMultipart class
      Multipart multipart = new MimeMultipart();

      // add body part 1
      multipart.addBodyPart(messageBodyPart2);

      // add body part 2
      multipart.addBodyPart(messageBodyPart1);

      // set the content
      message.setContent(multipart);

      // finally send the email
      Transport.send(message);

      System.out.println("=====Email Sent=====");

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}