package com.brunomilitzer.location.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailUtilImpl implements EmailUtil {

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(final String toAddress, final String subject, final String body) {

        final MimeMessage message = this.sender.createMimeMessage();
        final MimeMessageHelper helper = new MimeMessageHelper(message);

        try {

            helper.setTo(toAddress);
            helper.setText(body);
            helper.setSubject(subject);

        } catch (final MessagingException ex) {
            ex.printStackTrace();
        }

        this.sender.send(message);
    }

}