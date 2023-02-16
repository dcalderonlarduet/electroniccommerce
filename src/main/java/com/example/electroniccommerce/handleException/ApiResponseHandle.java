package com.example.electroniccommerce.handleException;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */
@Data
public class ApiResponseHandle {
    private Object message;
    private HttpStatus status;
    private ZonedDateTime timestamp;

    public ApiResponseHandle(Object message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.timestamp = ZonedDateTime.now();
    }
}