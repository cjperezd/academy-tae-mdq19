package com.academy.mdq.reports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.academy.mdq.properties.EmailProperties.*;
import static com.academy.mdq.properties.ReportProperties.REPORT_PROPERTIES;
import static com.academy.mdq.reports.Report.getReportPath;
import static com.academy.mdq.reports.Report.getReportStats;
import static java.lang.System.getProperty;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static javax.mail.Message.RecipientType.TO;
import static javax.mail.Session.getInstance;
import static javax.mail.Transport.send;
import static javax.mail.internet.InternetAddress.parse;


public class Email {
  private static final Logger LOGGER = LoggerFactory.getLogger(Email.class);
  private static final String STATS_FILE_PATH = getProperty("user.dir") + REPORT_PROPERTIES.getReportPath() + "stat.txt";
  private static final String RECIPIENT_MAIL = "corraleslucia@gmail.com";
  private static final Session SESSION = getInstance(getProperties(),
      new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(getUser(), getPass());
        }
      });
  private static final DataSource DATA_SOURCE = new FileDataSource(getReportPath());

  private String getTextFromFile(String path) throws IOException {
    return new String(readAllBytes(get(path)));
  }

  private Message configMessage(String recipient, String subject) {
    Message message = new MimeMessage(SESSION);
    try {
      message.setFrom(new InternetAddress(getUser()));
      message.setRecipients(TO, parse(RECIPIENT_MAIL));
      message.setSubject(subject);
      return message;
    } catch (AddressException e) {
      LOGGER.error(e.getLocalizedMessage(), e);
    } catch (MessagingException e) {
      LOGGER.error(e.getLocalizedMessage(), e);
    }
    return null;
  }

  private BodyPart generatePartFromTextFile(String path) {
    MimeBodyPart infoPart = new MimeBodyPart();
    try {
      infoPart.setText(getTextFromFile(path));
      return infoPart;
    } catch (MessagingException e1) {
      LOGGER.error(e1.getLocalizedMessage(), e1);
    } catch (IOException e1) {
      LOGGER.error(e1.getLocalizedMessage(), e1);
    }
    return null;
  }

  private BodyPart generateAttachPart(String path) {
    BodyPart attachFilePart = new MimeBodyPart();
    try {
      attachFilePart.setDataHandler(new DataHandler(DATA_SOURCE));
      attachFilePart.setFileName(path);
      return attachFilePart;
    } catch (MessagingException e1) {
      LOGGER.error(e1.getLocalizedMessage(), e1);
    }
    return null;
  }

  public void sendEmail(String subject) {
    Message message = configMessage(RECIPIENT_MAIL, subject);
    Multipart multipart = new MimeMultipart();
    try {
      writeStatsInFile(getReportStats());
      multipart.addBodyPart(generatePartFromTextFile(STATS_FILE_PATH));
      multipart.addBodyPart(generateAttachPart(getReportPath()));

      message.setContent(multipart);

      send(message);
    } catch (MessagingException e) {
      LOGGER.error(e.getLocalizedMessage(), e);
    }
  }

  public void writeStatsInFile(List<String> stats) {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(STATS_FILE_PATH, "UTF-8");
      stats.stream().forEach(writer::println);
      writer.close();
    } catch (FileNotFoundException e) {
      LOGGER.error(e.getLocalizedMessage(), e);
    } catch (UnsupportedEncodingException e) {
      LOGGER.error(e.getLocalizedMessage(), e);
    }
  }


}

