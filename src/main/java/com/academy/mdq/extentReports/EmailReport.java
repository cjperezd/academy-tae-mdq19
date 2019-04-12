package com.academy.mdq.extentReports;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailReport {
    final String username = "pruebareporteglo@gmail.com";
    final String password = "PruebaReporte123";
    private static final String filePath = "C:/Users/juan.poli/Desktop/Reports/MyReport.html";
    private static final String fileResumePath = "C:/Users/juan.poli/Desktop/Reports/resume.txt";

    public void sendEmail() {

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

        try {

            Message message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress("pruebareporteglo@gmail.com"));
            } catch (MessagingException e1) {
                e1.printStackTrace();
            }
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("juancruzpoli@gmail.com")
            );
            try {
                message.setSubject("Testing Gmail TLS");
            } catch (MessagingException e1) {
                e1.printStackTrace();
            }

            try {
                BodyPart messageBodyPart1 = new MimeBodyPart();
                MimeBodyPart messageBodyPart2 = new MimeBodyPart();

                DataSource file = new FileDataSource(filePath);
                DataSource resumeFile = new FileDataSource(fileResumePath);

                messageBodyPart2.setDataHandler(new DataHandler(file));
                messageBodyPart2.setFileName(filePath);

                //messageBodyPart1.setDataHandler(new DataHandler(file));
                messageBodyPart1.setDataHandler(new DataHandler(resumeFile));



                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart2);
                multipart.addBodyPart(messageBodyPart1);

                message.setContent(multipart);


            } catch (MessagingException e1) {
                e1.printStackTrace();
            }

            try {
                Transport.send(message);
            } catch (MessagingException e1) {
                e1.printStackTrace();
            }

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
