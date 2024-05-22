package com.mystore.My_Store.Controller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mystore.My_Store.Model.SaleDetail;
import com.mystore.My_Store.Service.SaleDetailService;

@RestController
public class SaleDetailController {
	@Autowired
    private SaleDetailService saleDetailService;

    @GetMapping("/sales")
    public String getAllSales(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<SaleDetail> salePage = saleDetailService.getSaleDetails(PageRequest.of(page, 20));
        model.addAttribute("sales", salePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", salePage.getTotalPages());
        return "viewSales";
    }

    @PostMapping("/sales")
    public String createSaleDetail(@ModelAttribute SaleDetail saleDetail) {
        saleDetailService.saveSaleDetail(saleDetail);
        return "redirect:/sales";
    }

    @GetMapping("/sales/search")
    public String searchSales(@RequestParam String criteria, @RequestParam String value, Model model) {
        List<SaleDetail> sales;
        switch (criteria) {
            case "itemName":
                sales = saleDetailService.findByItemName(value);
                break;
            case "custName":
                sales = saleDetailService.findByCustName(value);
                break;
            case "mobileNo":
                sales = saleDetailService.findByMobileNo(value);
                break;
            case "amount":
                sales = saleDetailService.findByPayAmount(new BigDecimal(value));
                break;
            default:
                sales = Collections.emptyList();
        }
        model.addAttribute("sales", sales);
        return "sales";
    }

}
