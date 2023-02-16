package com.example.electroniccommerce.controller;

import com.example.electroniccommerce.service.impl.ElectronicCommerceService;
import com.example.electroniccommerce.service.dto.PriceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */
@RestController
@RequestMapping("/electroniccommerce")
@Validated
@Tag(name = "Api-ElectronicCommerce", description = "Access to the application Electronic Commerce")
public class ElectronicCommerceController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ElectronicCommerceService electronicCommerceService;

    public ElectronicCommerceController(ElectronicCommerceService electronicCommerceService) {
        this.electronicCommerceService = electronicCommerceService;
    }

    /**
     * Controller method to obtain all prices of electronic commerce.
     * @return all prices of electronic commerce
     */
    @GetMapping(path = "/allprice", produces = "application/json")
    @Operation(summary = "Get a list with the products prices of electronic commerce", description = "Returns a list with the products prices of electronic commerce")
    public @ResponseBody
    ResponseEntity<List<PriceDto>> getAllPrice() {
        log.info("[ELECTRONIC-COMMERCE] - method:GET, url:/electroniccommerce");
        List<PriceDto> response = electronicCommerceService.getAllPriceDto();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    /**
     * Controller method to get the product price given the application date, product id and string id
     * @param applicationDate application date in format yyyy-MM-dd HH:mm:ss
     * @param productId product identifier
     * @param brandId brand identifier
     * @return the product price by priority.
     */
    @GetMapping(path = "/price", produces = "application/json")
    @Operation(summary = "Get the product price given the application date, product id and brand id", description = "Return the product price given the application date, product id and brand id")
    public @ResponseBody
    ResponseEntity<PriceDto> getProductPriceByParam(
            @RequestParam()
            @Parameter(description = "application date in format yyyy-MM-dd HH:mm:ss ")
            String applicationDate,
            @RequestParam()
            @Parameter(description = "product identifier")
            Integer productId,
            @RequestParam()
            @Parameter(description = "brand identifier")
            Integer brandId) throws ParseException {

        log.info("[ELECTRONIC-COMMERCE] - method:GET, url:/electroniccommerce/price/{},{},{} "
                , applicationDate
                , productId
                , brandId);
        PriceDto response = electronicCommerceService.getPriceDtoByParam(applicationDate,productId,brandId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
