package com.cboe.clear.example.config;


import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@AutoConfiguration
@ComponentScan(basePackages = {
        "com.cboe.clear.example.client",
        "com.cboe.clear.example.server"
})
public class StaticDataApiAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
