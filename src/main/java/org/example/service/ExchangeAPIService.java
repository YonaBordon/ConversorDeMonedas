package org.example.service;

import io.github.cdimascio.dotenv.Dotenv;

public class ExchangeAPIService {

  private final FetchAPI fetchAPI;
  private final String baseURL;
  private final String APIKey;

  public ExchangeAPIService() {
    Dotenv dotenv = Dotenv.load();

    this.baseURL = dotenv.get("EXCHANGE_API_BASE_URL");
    this.APIKey = dotenv.get("EXCHANGE_API_KEY");

    // Verifica que no sean nulas
    if (baseURL == null || APIKey == null) {
      throw new IllegalStateException("Las variables EXCHANGE_API_BASE_URL y EXCHANGE_API_KEY deben estar definidas en el archivo .env.");
    }

    this.fetchAPI = new FetchAPI(baseURL);
  }

  public String getExchangeRate() {
    String endpoint = APIKey + "/latest/USD";
    return fetchAPI.fetchData(endpoint);
  }
}
