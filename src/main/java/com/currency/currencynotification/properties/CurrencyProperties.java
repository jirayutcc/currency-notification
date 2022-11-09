package com.currency.currencynotification.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties("currency-config")
public class CurrencyProperties {

    public final String currencyUrl;

    public CurrencyProperties(String currencyUrl) {
        this.currencyUrl = currencyUrl;
    }

}
