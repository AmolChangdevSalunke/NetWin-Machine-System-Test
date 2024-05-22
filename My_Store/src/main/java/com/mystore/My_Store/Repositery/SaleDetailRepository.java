package com.mystore.My_Store.Repositery;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mystore.My_Store.Model.SaleDetail;
@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
    List<SaleDetail> findByItem_ItemNameContaining(String itemName);
    List<SaleDetail> findByCustNameContaining(String custName);
    List<SaleDetail> findByMobileNoContaining(String mobileNo);
    List<SaleDetail> findByPayAmountGreaterThanEqual(BigDecimal amount);

}
