package com.dro.pfg.pfgpricecalculator.model.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Jacksonized
@ToString
public class DeliveryCostDto {

    private String id;
    private float deliveryCost;
    private String currency;

}
