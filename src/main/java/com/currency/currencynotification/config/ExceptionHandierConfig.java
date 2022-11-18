package com.currency.currencynotification.config;

import com.currency.currencynotification.exception.CurrencyException;
import com.currency.currencynotification.dto.ErrorResponse;
import com.currency.currencynotification.utils.ErrorMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandierConfig {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public ErrorResponse exception(Exception ex) {
        log.error("Exception : ", ex);
        return ErrorResponse.builder()
                .statusCd(ErrorMapping.CODE9999)
                .statusDesc(ex.getMessage())
                .build();
    }

    @ExceptionHandler(value = {CurrencyException.class})
    @ResponseStatus(HttpStatus.OK)
    public ErrorResponse currencyException(CurrencyException ex) {
        log.error("CurrencyException : ", ex);
        return ErrorResponse.builder()
                .statusCd(ErrorMapping.CODE9999)
                .statusDesc(ex.getMessage())
                .build();
    }
}
