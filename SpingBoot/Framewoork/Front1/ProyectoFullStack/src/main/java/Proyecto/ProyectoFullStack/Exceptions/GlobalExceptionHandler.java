package Proyecto.ProyectoFullStack.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex , WebRequest w) {
        ErrorDetails error= new ErrorDetails(LocalDateTime.now(),ex.message,w.getDescription(false),"Not Found");
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
