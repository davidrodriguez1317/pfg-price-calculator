package com.dro.pfg.pfgpricecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableConfigurationProperties
public class PfgPriceCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfgPriceCalculatorApplication.class, args);
    }

}
