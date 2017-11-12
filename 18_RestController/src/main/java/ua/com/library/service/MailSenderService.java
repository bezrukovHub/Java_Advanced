package ua.com.library.service;

/**
 * Created by admin on 06.12.2016.
 */
public interface MailSenderService {

    void sendMail(String theme, String mailBody, String email);

}
