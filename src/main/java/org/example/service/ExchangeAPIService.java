package org.example.service;

import org.example.model.ExchangeRateData;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

public class ExchangeAPIService {

    private final FetchAPI fetchAPI;
    private final String baseURL;
    private final String APIKey;
    private final Gson gson;

    public ExchangeAPIService() {
        Dotenv dotenv = Dotenv.load();

        this.baseURL = dotenv.get("EXCHANGE_API_BASE_URL");
        this.APIKey = dotenv.get("EXCHANGE_API_KEY");

        if (baseURL == null || APIKey == null) {
            throw new IllegalStateException(
                "Las variables de entorno EXCHANGE_API_BASE_URL y EXCHANGE_API_KEY deben estar definidas.");
        }

        this.fetchAPI = new FetchAPI(baseURL);
        this.gson = new Gson(); 
    }

    public ExchangeRateData getExchangeRate() {
        String endpoint = APIKey + "/latest/USD";
        String jsonResponse = fetchAPI.fetchData(endpoint);

        try {
            return gson.fromJson(jsonResponse, ExchangeRateData.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar la respuesta de la API: " + e.getMessage());
        }
    }
}
