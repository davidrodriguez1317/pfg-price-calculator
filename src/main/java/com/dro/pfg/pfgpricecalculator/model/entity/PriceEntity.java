package com.dro.pfg.pfgpricecalculator.model.entity;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class PriceEntity {

    private String id;
    private float price;
    private String currency;

}
