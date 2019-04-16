package com.academy.mdq.extentReports;

import org.junit.rules.ErrorCollector;
import org.slf4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

import static org.slf4j.LoggerFactory.getLogger;


public class EmailReport {
    final String username = "pruebareporteglo@gmail.com";
    final String password = "PruebaReporte123";
    private static final String filePath = "C:/Users/juan.poli/Desktop/Reports/MyReport.html";
    private static final String fileResumePath = "C:/Users/juan.poli/Desktop/Reports/resume.txt";

    private static final Logger LOGGER = getLogger(ErrorCollector.class);


    public void sendEmail() {
        Message message = new MimeMessage(setProperties());

        try {
            message.setFrom(new InternetAddress("pruebareporteglo@gmail.com"));
        } catch (MessagingException e1) {
            LOGGER.error(e1.getLocalizedMessage(), e1);
        }
        try {
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("juancruzpoli@gmail.com")
            );
            try {
                message.setSubject("Testing Gmail TLS");
            } catch (MessagingException e1) {
                LOGGER.error(e1.getLocalizedMessage(), e1);
            }

            try {
                BodyPart messageBodyPart1 = new MimeBodyPart();
                MimeBodyPart messageBodyPart2 = new MimeBodyPart();

                DataSource file = new FileDataSource(filePath);
                DataSource resumeFile = new FileDataSource(fileResumePath);

                messageBodyPart2.setDataHandler(new DataHandler(file));
                messageBodyPart2.setFileName(filePath);

                messageBodyPart1.setDataHandler(new DataHandler(resumeFile));


                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart2);
                multipart.addBodyPart(messageBodyPart1);

                message.setContent(multipart);


            } catch (MessagingException e1) {
                LOGGER.error(e1.getLocalizedMessage(), e1);
            }

            try {
                Transport.send(message);
            } catch (MessagingException e1) {
                LOGGER.error(e1.getLocalizedMessage(), e1);
            }

            System.out.println("Done");

        } catch (MessagingException e) {
            LOGGER.error(e.getLocalizedMessage(), e);
        }
    }


    private Session setProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        return session;
    }
}

