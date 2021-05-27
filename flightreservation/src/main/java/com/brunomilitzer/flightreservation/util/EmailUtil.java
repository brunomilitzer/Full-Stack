package com.brunomilitzer.flightreservation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    @Value("${com.brunomilitzer.flightreservation.itinerary.email.subject}")
    public String EMAIL_SUBJECT;

    @Value("${com.brunomilitzer.flightreservation.itinerary.email.body}")
    public String EMAIL_BODY;

    @Autowired
    private JavaMailSender sender;

    public void sendItinerary(final String toAddress, final String filePath) {

        LOGGER.info(this.EMAIL_SUBJECT);

        final MimeMessage message = this.sender.createMimeMessage();

        try {
            final MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(toAddress);
            helper.setSubject(this.EMAIL_SUBJECT);
            helper.setText(this.EMAIL_BODY);
            helper.addAttachment("Itinerary", new File(filePath));

            this.sender.send(message);

        } catch (final MessagingException e) {
            LOGGER.error("Exception inside sendItinerary " + e);
        }
    }

}
