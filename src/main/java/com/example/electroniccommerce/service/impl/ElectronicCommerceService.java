package com.example.electroniccommerce.service.impl;

import com.example.electroniccommerce.model.dao.IPriceDao;
import com.example.electroniccommerce.model.dao.impl.PriceSpecifications;
import com.example.electroniccommerce.model.entity.PriceEntity;
import com.example.electroniccommerce.service.IElectronicCommerceService;
import com.example.electroniccommerce.service.mapper.IElectronicCommerceMapper;
import com.example.electroniccommerce.service.dto.PriceDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.electroniccommerce.util.Constants.NOT_FOUND;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */

@Service
public class ElectronicCommerceService implements IElectronicCommerceService {
    private final IPriceDao iPriceDao;
    private final PriceSpecifications priceSpecifications;
    private final IElectronicCommerceMapper iElectronicCommerceMapper;

    public ElectronicCommerceService(IPriceDao iPriceDao, PriceSpecifications priceSpecifications) {
        this.iPriceDao = iPriceDao;
        this.priceSpecifications = priceSpecifications;
        this.iElectronicCommerceMapper = Mappers.getMapper(IElectronicCommerceMapper.class);
    }

    @Override
    public List<PriceDto> getAllPriceDto() {
        return iElectronicCommerceMapper.toListPriceDto(iPriceDao.findAll());
    }

    @Override
    public PriceDto getPriceDtoByParam(String applicationDate, Integer productId, Integer brandId) throws ParseException {
        Date date = iElectronicCommerceMapper.convertStringToDate(applicationDate);
        List<PriceEntity> listPrice = priceSpecifications.findByParameterSearch(brandId,productId,date);
        if(listPrice.isEmpty()){
            throw new NotFoundException(NOT_FOUND);
        }
        PriceEntity priceEntity = listPrice.size() > 1
                ?  listPrice.stream().filter(x -> x.getPriority()==1).collect(Collectors.toList()).get(0)
                : listPrice.get(0);
        return iElectronicCommerceMapper.toPriceDto(priceEntity);
    }
}
