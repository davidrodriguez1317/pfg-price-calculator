package com.dro.pfg.pfgpricecalculator.repository;

import com.dro.pfg.pfgpricecalculator.model.entity.PriceEntity;
import org.springframework.stereotype.Component;

/**
 * This class is mocking a real repository for testing purposes
 */
@Component
public class PriceRepository {
    public PriceEntity getPriceByIdAndCurrency(String currency, String id) {
        return PriceEntity.builder()
                .id(id)
                .price(56.1f)
                .currency(currency)
                .build();
    }
}
