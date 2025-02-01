package com.escola.sia.service.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class CamaraService {

    private static final String API_URL = "https://dadosabertos.camara.leg.br/api/v2/deputados";

    @Autowired
    private RestTemplate restTemplate;

    public String getDeputados() {
        ResponseEntity<String> response = restTemplate.getForEntity(API_URL, String.class);
        return response.getBody(); // Retorna os dados em formato JSON
    }
}
