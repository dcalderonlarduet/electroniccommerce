package com.example.electroniccommerce.handleException.Exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {
    private  Object message;
    private  HttpStatus status;
    private  ZonedDateTime timestamp;
}
