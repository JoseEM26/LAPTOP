package SpringSecurity_lll.Security_lll.Security.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils {

    @Value("${spring.security.private.key}")
    private String privateKey;
    @Value(value = "${spring.security.time.expiration}")
    private String timeExpiration;

    //Generar el Token de Acceso
   public String GenerateAccessToken(String username){
       return Jwts.builder()
               .setSubject(username)
               .setExpiration(new Date(System.currentTimeMillis()+ Long.parseLong(timeExpiration)))
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .signWith(getSignaturKey() , SignatureAlgorithm.HS256)
               .compact();
   }

   //validamos si el toke   es valido con la firma que es la contraseña
   public boolean ValidateToken(String token){
       try {
           Jwts.parserBuilder()
                   .setSigningKey(getSignaturKey())
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
           return true;
       }catch (Exception e){
                       return false;
       }
   }

   //Obtener la firma del token
    public Key getSignaturKey(){
       byte[] keybites= Decoders.BASE64.decode(privateKey);
       return Keys.hmacShaKeyFor(keybites);
    }

    public Claims extractAllClaims(String token){
       return Jwts.parserBuilder()
               .setSigningKey(getSignaturKey())
               .build()
               .parseClaimsJws(token)
               .getBody();
    }

    public <T>T getClaim(String token , Function<Claims,T> claimsTFunction) {
       Claims claims=extractAllClaims(token);
       return claimsTFunction.apply(claims);
    }

    public String GetUsernameFromToken(String token){
       return getClaim(token , Claims::getSubject );
    }

}
