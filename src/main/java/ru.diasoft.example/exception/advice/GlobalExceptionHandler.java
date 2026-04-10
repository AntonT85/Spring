package ru.diasoft.example.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.diasoft.example.exception.NoSuchTaskException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchTaskException.class)
    public ResponseEntity<String> handleNoSuchTaskException(NoSuchTaskException e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }

}
