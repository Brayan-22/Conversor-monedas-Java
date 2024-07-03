package com.oracleonejava.models;

import com.oracleonejava.utils.CurrencyEnum;

public record ConversionRatesDTO(double ARS, double USD, double BRL, double COP) {
    public double divisa(CurrencyEnum enumValue) {
        return switch (enumValue) {
            case COP -> this.COP;
            case ARS -> this.ARS;
            case USD -> this.USD;
            case BRL -> this.BRL;
            default -> 0.0d;
        };
    }
}
