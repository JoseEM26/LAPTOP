package com.Clase3.Excepciones.handler;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejoErrores {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> HandlerAritmeticError(ArithmeticException e){
        return new ResponseEntity<>("Error ocurrido por un 0",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handlerNumberError(NumberFormatException e){
        return new ResponseEntity<>("Error con el numero",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> HandlerNull(NullPointerException e){
        return new ResponseEntity<>("Error con un numero null",HttpStatus.BAD_REQUEST);
    }

}
