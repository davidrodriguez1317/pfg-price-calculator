package com.dro.pfg.pfgpricecalculator.service;

import com.dro.pfg.pfgpricecalculator.config.AppProperties;
import com.dro.pfg.pfgpricecalculator.model.dto.DeliveryCostDto;
import com.dro.pfg.pfgpricecalculator.model.dto.PriceDto;
import com.dro.pfg.pfgpricecalculator.model.entity.PriceEntity;
import com.dro.pfg.pfgpricecalculator.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class PriceService {

    private final DeliveryCostService deliveryCostService;

    private final PriceRepository priceRepository;

    private final AppProperties appProperties;

    public PriceDto getProductById(String currency, String id) {

        String defaultCurrency = appProperties.getDefaultCurrency();
        log.info("Default currency: {}", defaultCurrency);

        DeliveryCostDto deliveryCost = deliveryCostService.getDeliverCostFromId(currency, id);
        log.info("Delivery cost por product with id {} and currency {}: {}", id, currency, deliveryCost);

        PriceEntity priceEntity = priceRepository.getPriceByIdAndCurrency(defaultCurrency, id);
        log.info("Price from db for product with id {} and currency {}: {}", id, currency, priceEntity);

        return PriceDto.builder()
                .id(id)
                .currency(currency)
                .price(priceEntity.getPrice())
                .deliveryCost(deliveryCost.getDeliveryCost())
                .build();
    }
}
