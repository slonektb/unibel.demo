package ru.unibel.demo.exeptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException extends RuntimeException {
    private String message;

    public CustomException() {}

    public CustomException(String msg) {
        super(msg);
        this.message = msg;
    }
}
