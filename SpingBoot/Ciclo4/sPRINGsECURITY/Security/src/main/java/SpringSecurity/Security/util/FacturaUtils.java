package SpringSecurity.Security.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FacturaUtils {
    private FacturaUtils(){}

    public static ResponseEntity<String> GetResponseEntity(String message, HttpStatus httpStatus){
        return new  ResponseEntity<String>("Mensaje: "+ message , httpStatus);
    }
}
