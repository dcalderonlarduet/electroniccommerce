package com.example.electroniccommerce.handleException;

import com.example.electroniccommerce.handleException.Exception.ApiException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import javax.validation.ConstraintViolationException;
import java.text.ParseException;
import java.time.ZonedDateTime;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {


    @ExceptionHandler({MissingServletRequestParameterException.class, DuplicateKeyException.class, HttpRequestMethodNotSupportedException.class, ConstraintViolationException.class})
    public ResponseEntity<?> apiRequestException(Exception e) {
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> errorNoFound(RuntimeException ex) {
        ApiException apiException = new ApiException(ex.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({ParseException.class})
    public ResponseEntity<?> apiParseException(ParseException e) {
        ApiException apiException = new ApiException("Date format error: " + e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> apiException(Exception e) {
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
