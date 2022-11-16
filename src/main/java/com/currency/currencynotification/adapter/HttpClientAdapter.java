package com.currency.currencynotification.adapter;

import com.currency.currencynotification.exception.CurrencyException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
public class HttpClientAdapter {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public HttpClientAdapter(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public <T> T get(String url, Class<T> clazz, String errMessage) throws CurrencyException {

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() != HttpStatus.OK.value()) {
                throw new CurrencyException(errMessage);
            }

            return objectMapper.readValue(response.body(), clazz);

        } catch (Exception ex) {
            throw new CurrencyException(ex.getMessage());
        }
    }

    public <T> T getWithParameters(String url, Class<T> clazz, String currencyType, String errMessage) throws CurrencyException {

        try {

            URI uri = new URIBuilder(url)
                    .addParameter("base", currencyType)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            log.info("[GET] request: {}", request);

            HttpResponse<String> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );
            log.info("[GET] response: {}, body: {}", response, response.body());

            if (response.statusCode() != HttpStatus.OK.value()) {
                throw new CurrencyException(errMessage);
            }

            return objectMapper.readValue(response.body(), clazz);

        } catch (Exception ex) {
            throw new CurrencyException(ex.getMessage());
        }
    }
}
