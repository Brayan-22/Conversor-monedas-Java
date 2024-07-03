package com.oracleonejava.models;

import java.util.Currency;
import java.util.Locale;


public class Moneda {
    
    private double valor;

    private Currency currency;
    
    public Moneda(double valor, Currency currency) {
        this.valor = valor;
        this.currency = currency;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Currency getCurrency() {
        return currency;
    }
    public String getCurrencySymbol(){
        return currency.getSymbol(Locale.US);
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    @Override
    public String toString() {
        return String.format("%f %s", valor,currency.getSymbol(Locale.US));
    }
    
}
