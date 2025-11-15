package com.example.ResendMSTP.Controller;

import com.example.ResendMSTP.Model.EmailRequest;
import com.example.ResendMSTP.service.EmailService;
import com.resend.core.exception.ResendException;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            String emailId = emailService.sendEmail(
                    request.getTo(),
                    request.getSubject(),
                    request.getHtml()
            );
            return ResponseEntity.ok("Correo enviado! ID: " + emailId);
        } catch (ResendException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}

