package ua.com.library.serviceImpl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ua.com.library.service.MailSenderService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by admin on 06.12.2016.
 */
@Service
public class MailSenderServiceImpl implements MailSenderService{

    private final static String USERNAME = "alexbond761@gmail.com";// назва почти з якої буде розсилка
    private final static String PASSWORD = "fuckoff16121990";// пароль до цієї почти

    @Async
    public void sendMail(String theme, String mailBody, String email) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    email));
            message.setSubject(theme, "UTF-8");
            message.setText(mailBody);
            synchronized (this) {
                Transport.send(message);
            }
        } catch (MessagingException mex) {
            mex.printStackTrace();
            System.out.println("You have some problems with connection!");
        }
    }

}
