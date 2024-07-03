package com.oracleonejava.services.impl;

import java.net.URI;
import java.util.Currency;
import java.util.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oracleonejava.models.Moneda;
import com.oracleonejava.models.MonedaDTO;
import com.oracleonejava.persistence.ApiConnection;
import com.oracleonejava.services.ConverterService;
import com.oracleonejava.utils.CurrencyEnum;

public class ConverterServiceImpl implements ConverterService{

    private ApiConnection apiConnection;
    private Gson gson;
    public ConverterServiceImpl(ApiConnection apiConnection){
        this.apiConnection = apiConnection;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public Moneda conversion(Moneda actual, CurrencyEnum nueva) {
        String url = String.format("https://v6.exchangerate-api.com/v6/f3c656f93c5fbafd5f1753a8/latest/%s", actual.getCurrency().getCurrencyCode());
        Optional<String> json = apiConnection.requestURL(URI.create(url));
        if (json.isPresent()) {
            MonedaDTO monedaDTO = gson.fromJson(json.get(), MonedaDTO.class);
            return new Moneda(actual.getValor()*monedaDTO.conversion_rates().divisa(nueva), Currency.getInstance(nueva.toString()));
        }
        return null;
    }
    
}
