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
import java.nio.file.Paths;

import static com.academy.mdq.properties.EmailProperties.*;
import static com.academy.mdq.reports.Report.getReportPath;
import static com.academy.mdq.reports.Report.getStatsPath;
import static java.nio.file.Files.readAllBytes;
import static javax.mail.Message.RecipientType.TO;
import static javax.mail.internet.InternetAddress.parse;


public class Email {
  private String recipientMail = "corraleslucia@gmail.com";
  private Session session = Session.getInstance(getProperties(),
      new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(getUser(), getPass());
        }
      });

  private DataSource dataSource = new FileDataSource(getReportPath());

  public void sendEmail() {
    Message message = new MimeMessage(session);
    try {
      message.setFrom(new InternetAddress(getUser()));
      message.setRecipients(TO, parse(recipientMail));
      message.setSubject("Amazon TEST");

      MimeBodyPart infoPart = new MimeBodyPart();
      infoPart.setText(new String(readAllBytes(Paths.get(getStatsPath()))));

      BodyPart attachFilePart = new MimeBodyPart();
      attachFilePart.setDataHandler(new DataHandler(dataSource));
      attachFilePart.setFileName(getReportPath());

      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(infoPart);
      multipart.addBodyPart(attachFilePart);

      message.setContent(multipart);

      Transport.send(message);

    } catch (MessagingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}

