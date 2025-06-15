package com.SpringSecurity.TeoriaSecurity1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1")
public class CustomerController {

    @Autowired
    private SessionRegistry sessionRegistry;

    @GetMapping(path = "/index")
    public String GetMessage(){
        return "Hello World";
    }

    @GetMapping(path = "/index2")
    public String GetMessageWithoutSecurity(){
        return "Hello World NotSecurity";
    }

    @GetMapping(path = "/session")
    public ResponseEntity<Map<String, Object>> getDetailsSession(){

        String sessionId = "No active session";
        String username = "No authenticated user";

        // 🔹 Obtener todas las sesiones activas
        List<Object> sessions = sessionRegistry.getAllPrincipals();

        for (Object session : sessions) {
            if (session instanceof UserDetails userDetails) { // ✅ Usa "instanceof" con variable en Java 17+
                username = userDetails.getUsername(); // Obtiene el nombre del usuario
            }

            List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(session, false);
            for (SessionInformation sessionInformation : sessionInformations) {
                sessionId = sessionInformation.getSessionId();
            }
        }

        // 🔹 Crear respuesta JSON
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hello World");
        response.put("sessionID", sessionId);
        response.put("username", username);

        return ResponseEntity.ok(response);
    }
}
