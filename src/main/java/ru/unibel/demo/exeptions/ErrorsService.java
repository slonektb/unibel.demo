package ru.unibel.demo.exeptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsService {

    @ExceptionHandler
    public ResponseEntity<String> customException(CustomException ex) {
        HttpHeaders h = new HttpHeaders();
        h.add("Content-type", "text/html;charset=UTF-8");

        return new ResponseEntity<>(
                ex.getMessage(), h,
                HttpStatus.valueOf(400)
        );

    }

}
