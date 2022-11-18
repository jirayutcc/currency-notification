package com.currency.currencynotification.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptoCurrencyList {

    private CryptoCurrency EUR;
    private CryptoCurrency USD;
    private CryptoCurrency JPY;
    private CryptoCurrency THB;

}
