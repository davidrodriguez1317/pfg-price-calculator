package com.dro.pfg.pfgpricecalculator.controller;

import com.dro.pfg.pfgpricecalculator.model.dto.DeliveryCostDto;
import com.dro.pfg.pfgpricecalculator.model.dto.PriceDto;
import com.dro.pfg.pfgpricecalculator.service.PriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
@Slf4j
public class PriceController {

    private final PriceService priceService;

    @GetMapping("/{currency}/{id}")
    public PriceDto getPrice(@PathVariable(value="currency") String currency, @PathVariable(value="id") String id) {

        log.info("Getting price for product with id {} and currency {}", id, currency);
        PriceDto price = priceService.getProductById(currency, id);

        log.info("Price for product with id {} and currency {}: {}", id, currency, price);
        return price;
    }

}
