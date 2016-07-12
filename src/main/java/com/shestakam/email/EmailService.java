package com.shestakam.email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sendFrom;

    public void send(String sendTo, String subject, String messageText) {

        sendTo = "shestakalexandr@mail.ru";
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(sendTo);
            //helper.setReplyTo("someone@localhost");
            helper.setFrom(sendFrom);
            helper.setSubject(subject);
            helper.setText(messageText);
        } catch (MessagingException e) {
            logger.error(e);
        } finally {}
        javaMailSender.send(mail);
        //return helper;
    }
}
