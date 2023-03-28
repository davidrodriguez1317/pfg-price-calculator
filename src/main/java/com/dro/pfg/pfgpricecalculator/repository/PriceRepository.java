package com.dro.pfg.pfgpricecalculator.repository;

import com.dro.pfg.pfgpricecalculator.model.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceRepository {
    public PriceEntity getPriceByIdAndCurrency(String currency, String id) {
        return PriceEntity.builder()
                .id(id)
                .price(1.1f)
                .currency(currency)
                .build();
    }
}
