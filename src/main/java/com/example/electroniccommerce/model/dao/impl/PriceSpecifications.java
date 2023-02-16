package com.example.electroniccommerce.model.dao.impl;

import com.example.electroniccommerce.model.dao.IPriceDao;
import com.example.electroniccommerce.model.entity.PriceEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */
@Repository
public class PriceSpecifications {


    private final IPriceDao IPriceDao;

    public PriceSpecifications(IPriceDao IPriceDao) {
        this.IPriceDao = IPriceDao;
    }

    public List<PriceEntity> findByParameterSearch(Integer brandId, Integer productId, Date applicationDate) {

        return IPriceDao.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            /*
            Search by brandId
             */
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("brandId"), brandId)));
             /*
            Search by productId
             */
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("productId"), productId)));

             /*
             Search between startDate and endDate
             */
            predicates.add(criteriaBuilder.and(criteriaBuilder.between(criteriaBuilder.literal(applicationDate), root.<Date>get("startDate"), root.<Date>get("endDate"))));

            Predicate predicateAnd = criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            return query.where(predicateAnd).getRestriction();

        });
    }

}
