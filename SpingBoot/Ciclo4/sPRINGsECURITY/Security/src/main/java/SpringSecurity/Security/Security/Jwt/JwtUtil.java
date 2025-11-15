package SpringSecurity.Security.Security.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String secretKey = "springboot"; // Clave secreta para firmar el JWT

    /**
     * Extrae todos los claims (datos) del token JWT
     */
    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    /**
     * Extrae un claim específico del token utilizando una función pasada como parámetro
     */
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extrae el nombre de usuario (subject) del token JWT
     */
    public String extractUsername(String token) {
        return extractClaims(token,Claims::getSubject);
    }

    /**
     * Extrae la fecha de expiración del token JWT
     */
    public Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }



    /**
     * Verifica si el token ha expirado
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    /**
     * Crea un token JWT con los claims y el subject especificados
     */
    public String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 100 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secretKey) // Corrección: Debe ser HS256 en lugar de ES256
                .compact();
    }
    /**
     * Genera un token JWT con el username y el rol del usuario
     */
    public String generateToken(String subject, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return createToken(claims, subject);
    }

    public boolean validateToken(String token, UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


}