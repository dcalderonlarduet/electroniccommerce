package com.example.electroniccommerce.service.mapper;

import com.example.electroniccommerce.model.entity.PriceEntity;
import com.example.electroniccommerce.service.dto.PriceDto;
import com.example.electroniccommerce.util.Constants;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.example.electroniccommerce.util.Constants.INVALIDAD_FORMAT;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IElectronicCommerceMapper {

    /**
     * Maps priceEntity to PriceDto
     *
     * @param entity priceEntity
     * @return PriceDto
     */
    PriceDto toPriceDto(PriceEntity entity);

    /**
     * Maps a list of priceEntity to List PriceDto
     *
     * @param priceEntities list of priceEntity
     * @return list of PriceDto
     */
    List<PriceDto> toListPriceDto(List<PriceEntity> priceEntities);


    /**
     * Maps priceEntity to PriceDto
     *
     * @param dto priceEntity
     * @return PriceDto
     */
    PriceEntity toPriceEntity(PriceDto dto);


    /**
     * Convert Value dateString To Date
     *
     * @param dateString date to format String
     * @return date Value to format Date
     */
    default Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.PATTERN, Locale.ENGLISH);
        try {
            if (dateString.length() != 19) {
                throw new ParseException(INVALIDAD_FORMAT, 1);
            } else {
                return formatter.parse(dateString);
            }
        } catch (ParseException e) {
            throw new ParseException(e.getMessage(), e.getErrorOffset());
        }
    }

}
