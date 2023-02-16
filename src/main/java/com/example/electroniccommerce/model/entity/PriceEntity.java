package com.example.electroniccommerce.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static com.example.electroniccommerce.util.Constants.PATTERN;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PRICES")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "START_DATE")
    @DateTimeFormat(pattern= PATTERN)
    private Date startDate;

    @Column(name = "END_DATE")
    @DateTimeFormat(pattern= PATTERN)
    private Date endDate;

    @Basic
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Basic
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Basic
    @Column(name = "PRIORITY")
    private byte priority;

    @Basic
    @Column(name = "PRICE")
    private double price;

    @Basic
    @Column(name = "CURR")
    private String curr;
}
