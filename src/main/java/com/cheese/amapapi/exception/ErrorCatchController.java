package com.cheese.amapapi.exception;

import com.cheese.amapapi.log.BaseLogable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorCatchController extends BaseLogable {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = LogicException.class)
    public String logicErrorHandler(LogicException e) {
        logger.error("[Error Catch] LogicException: " + e.getMessage());
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = JSException.class)
    public String jsErrorHandler(JSException e) {
        logger.error("[Error Catch] JSException: " + e.getMessage());
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(Exception e) {
        logger.error("[Unknown Error Catch] UnknownException: " + e.getMessage());
        e.printStackTrace();
        return "Unknown Server Error";
    }
}
