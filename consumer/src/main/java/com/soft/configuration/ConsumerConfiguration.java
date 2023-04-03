package com.soft.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class ConsumerConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){return new RestTemplate();}

}
