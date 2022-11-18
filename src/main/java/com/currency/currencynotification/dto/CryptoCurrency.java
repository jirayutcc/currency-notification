package com.currency.currencynotification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptoCurrency {

    private BigDecimal last;
    private BigDecimal buy;
    private BigDecimal sell;
    private String symbol;

}
