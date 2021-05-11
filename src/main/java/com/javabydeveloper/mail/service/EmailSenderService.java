package com.javabydeveloper.mail.service;

import com.javabydeveloper.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class EmailSenderService {

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendEmail(Mail mail) throws MessagingException, IOException {

        Context context = new Context();
        context.setVariables(mail.getProps());

        String html = templateEngine.process("newsletter-template", context);

    }

}
