package com.example.electroniccommerce.service.dto;

import com.example.electroniccommerce.util.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static com.example.electroniccommerce.util.Constants.PATTERN;
import static com.example.electroniccommerce.util.Constants.TIME_ZONE;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

    private Long id;

    private Integer brandId;

    @JsonFormat(pattern= PATTERN, timezone=TIME_ZONE)
    private Date startDate;

    @JsonFormat(pattern=PATTERN, timezone=TIME_ZONE)
    private Date endDate;

    private Integer priceList;

    private Integer productId;

    private double price;

}
