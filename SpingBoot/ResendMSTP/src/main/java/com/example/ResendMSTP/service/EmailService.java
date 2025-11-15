package com.example.ResendMSTP.service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final Resend resend;

    public EmailService(Resend resend) {
        this.resend = resend;
    }

    public String sendEmail(String to, String subject, String htmlContent) throws ResendException {
        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("Tu App <onboarding@resend.dev>")  // Debe estar verificado en Resend
                .to(to)
                .subject(subject)
                .html(htmlContent)
                .build();

        CreateEmailResponse response = resend.emails().send(params);
        return response.getId(); // ID del correo enviado
    }
}