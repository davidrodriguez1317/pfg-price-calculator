package com.dro.pfg.pfgpricecalculator.service;

import com.dro.pfg.pfgpricecalculator.exception.DeliveryCostServiceNotAvailableException;
import com.dro.pfg.pfgpricecalculator.model.dto.DeliveryCostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryCostService {

    private final WebClient webClient;

    private final DiscoveryClient discoveryClient;

    public DeliveryCostDto getDeliverCostFromId(String currency, String id) {

        URI service = serviceUrl()
                .map(s -> s.resolve(String.format("/delivery/%s/%s", currency, id)))
                .orElseThrow(DeliveryCostServiceNotAvailableException::new);

        log.info("Getting delivery cost. Delivery cost service URI: " + service.toString());

        Mono<DeliveryCostDto> response = this.webClient
                .get()
                .uri(service)
                .retrieve()
                .bodyToMono(DeliveryCostDto.class);

        return response.block();
    }

    public Optional<URI> serviceUrl() {
        return discoveryClient.getInstances("delivery-cost")
                .stream()
                .findFirst()
                .map(ServiceInstance::getUri);
    }

}
