package com.example.electroniccommerce.model.dao;

import com.example.electroniccommerce.model.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Daniel Calderon
 * @Project electronicCommerce
 * @Creation 2/15/2023
 */
@Repository
public interface IPriceDao extends JpaRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity> {


}