package ph.edu.dlsu.securde.SECURDE_MP.service;

import org.springframework.stereotype.Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@Service
public class EmailService {
    private final String from;
    //private final String host;
    private final Properties properties;
    private final Session session;

    private static final EmailService instance = new EmailService();

    private EmailService() {
        /* from = "carlo_eroles@dlsu.edu.ph";
        host = "localhost";
        properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        session = Session.getDefaultInstance(properties); */
        from = "boopadoptions@gmail.com";
        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        session = Session.getDefaultInstance(properties,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from,"P@ssw0rd123!");
                }
            });
    }

    public static EmailService getInstance() {
        return instance;
    }

    public boolean sendEmail(String to, String subj, String msg) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subj);
            message.setText(msg);
            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
    }
}
