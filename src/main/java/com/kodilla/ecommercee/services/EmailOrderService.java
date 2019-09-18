package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.config.AdminConfig;
import com.kodilla.ecommercee.domains.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailOrderService {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private SimpleEmailService emailService;

    private static final String SUBJECT = "Created new order on Kodilla Store!";
    private static final String MESSAGE = "New order has just been created! ";

    public void sendEmail() {
        emailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, MESSAGE));
    }
}