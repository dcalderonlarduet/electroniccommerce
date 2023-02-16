package com.example.electroniccommerce.service;

import com.example.electroniccommerce.service.dto.PriceDto;

import java.text.ParseException;
import java.util.List;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */

public interface IElectronicCommerceService {

    /**
     * Get all Products Prices
     * @return all Products Price
     */
    List<PriceDto> getAllPriceDto();

    /**
     * Get the product price by param
     * @return product price
     */
    PriceDto getPriceDtoByParam(String dateApplication, Integer productId, Integer brandId) throws ParseException;
}
