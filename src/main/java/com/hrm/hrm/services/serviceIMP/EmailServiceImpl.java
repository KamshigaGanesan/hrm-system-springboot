package com.hrm.hrm.services.serviceIMP;

import com.hrm.hrm.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmployeeEmail(String toEmail, String employeeName) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Northern UNI");
        message.setText("Hello " + employeeName + ",\n\nWelcome to the company! Your account has been created successfully.\n\nRegards,\nHR Team");

        mailSender.send(message);
    }
}
