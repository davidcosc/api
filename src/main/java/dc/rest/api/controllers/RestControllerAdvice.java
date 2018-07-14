package dc.rest.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by david on 12.07.2018.
 */
@ControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<?> handleServiceNotFoundException(Exception e) {
        String[] error = {e.getMessage(), HttpStatus.NOT_FOUND.toString()};
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
