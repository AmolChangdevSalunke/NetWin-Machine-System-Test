package com.mystore.My_Store.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mystore.My_Store.Model.SaleDetail;
import com.mystore.My_Store.Repositery.SaleDetailRepository;

@Service
public class SaleDetailService {
	   @Autowired
	    private SaleDetailRepository saleDetailRepository;

	    public SaleDetail saveSaleDetail(SaleDetail saleDetail) {
	        if (saleDetail.getDateOfBirth().isAfter(LocalDate.now().minusYears(18))) {
	            saleDetail.setMinor(true);
	            if (saleDetail.getPayAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
	                throw new IllegalArgumentException("Minor can shop for only RS.1000");
	            }
	        } else {
	            saleDetail.setMinor(false);
	        }
	        if ("Maharashtra".equalsIgnoreCase(saleDetail.getState())) {
	            saleDetail.setPayAmount(saleDetail.getPayAmount().multiply(BigDecimal.valueOf(0.8)));
	        }
	        return saleDetailRepository.save(saleDetail);
	    }

	    public Page<SaleDetail> getSaleDetails(Pageable pageable) {
	        return saleDetailRepository.findAll(pageable);
	    }

		public List<SaleDetail> findByItemName(String value) {
			// TODO Auto-generated method stub
			return saleDetailRepository.findByItem_ItemNameContaining(value);
		}

		public List<SaleDetail> findByCustName(String value) {
			// TODO Auto-generated method stub
			return saleDetailRepository.findByCustNameContaining(value);
		}

		public List<SaleDetail> findByMobileNo(String value) {
			// TODO Auto-generated method stub
			return saleDetailRepository.findByMobileNoContaining(value);
		}

		public List<SaleDetail> findByPayAmount(BigDecimal bigDecimal) {
			// TODO Auto-generated method stub
			return saleDetailRepository.findByPayAmountGreaterThanEqual(bigDecimal);
		}

}
