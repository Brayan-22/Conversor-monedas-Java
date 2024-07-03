package com.oracleonejava.services;

import com.oracleonejava.models.Moneda;
import com.oracleonejava.utils.CurrencyEnum;

public interface ConverterService {
    public Moneda conversion(Moneda moneda,CurrencyEnum cEnum);
}
