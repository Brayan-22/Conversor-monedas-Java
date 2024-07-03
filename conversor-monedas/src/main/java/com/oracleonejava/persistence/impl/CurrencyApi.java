package com.oracleonejava.persistence.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import com.oracleonejava.persistence.ApiConnection;

public class CurrencyApi implements ApiConnection{
    private HttpClient client;
    public CurrencyApi(){
        this.client = HttpClient.newHttpClient();
    }
    @Override
    public Optional<String> requestURL(URI uri){
        HttpRequest request = HttpRequest.newBuilder(uri).build();
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() == HttpURLConnection.HTTP_OK) {
                return Optional.of(response.body());
            }
            return Optional.empty();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
            Thread.currentThread().interrupt();
            return Optional.empty();
        }
    }
    
}
