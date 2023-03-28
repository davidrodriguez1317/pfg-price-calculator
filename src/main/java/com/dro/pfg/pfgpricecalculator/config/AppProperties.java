package com.dro.pfg.pfgpricecalculator.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppProperties {
    private String defaultCurrency;
}
