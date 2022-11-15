package com.currency.currencynotification.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class HttpConfig {

    @Value(value = "${http.timeout}")
    private Integer httpTimeout;

    @Bean
    public HttpClient httpClient() {

        return HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NEVER)
                .connectTimeout(Duration.ofMinutes(httpTimeout))
                .build();
    }
}
