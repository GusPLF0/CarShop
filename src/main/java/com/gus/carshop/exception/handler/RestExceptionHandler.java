package com.gus.carshop.exception.handler;

import com.gus.carshop.exception.ApiErrorMessage;
import com.gus.carshop.exception.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CarNotFoundException.class)
    public ResponseEntity<ApiErrorMessage> handleNotFound(CarNotFoundException ex, WebRequest request){

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(apiErrorMessage, HttpStatus.NOT_FOUND);
    }
}
