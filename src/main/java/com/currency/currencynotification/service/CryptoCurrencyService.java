package com.currency.currencynotification.service;

import com.currency.currencynotification.adapter.HttpClientAdapter;
import com.currency.currencynotification.exception.CurrencyException;
import com.currency.currencynotification.dto.CryptoCurrencyList;
import com.currency.currencynotification.properties.CurrencyProperties;
import com.currency.currencynotification.utils.Constant;
import org.springframework.stereotype.Service;

import static com.currency.currencynotification.utils.Constant.BTC_ERROR_MESSAGE;

@Service
public class CryptoCurrencyService {

    private final HttpClientAdapter httpClientAdapter;
    private final CurrencyProperties currencyProperties;

    public CryptoCurrencyService(HttpClientAdapter httpClientAdapter, CurrencyProperties currencyProperties) {
        this.httpClientAdapter = httpClientAdapter;
        this.currencyProperties = currencyProperties;
    }

    public CryptoCurrencyList getBitcoinCurrency() throws CurrencyException {
        return httpClientAdapter.getWithParameters(
                currencyProperties.getCurrencyUrl(),
                CryptoCurrencyList.class,
                Constant.CurrencyType.BTC,
                BTC_ERROR_MESSAGE
        );
    }

    public CryptoCurrencyList getEthereumCurrency() throws CurrencyException {
        return httpClientAdapter.getWithParameters(
                currencyProperties.getCurrencyUrl(),
                CryptoCurrencyList.class,
                Constant.CurrencyType.ETH,
                BTC_ERROR_MESSAGE
        );
    }
}
