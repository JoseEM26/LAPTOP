package com.example.ResendMSTP.Model;

import lombok.Data;

@Data
public class EmailRequest {
    private String to;
    private String subject;
    private String html;
}
