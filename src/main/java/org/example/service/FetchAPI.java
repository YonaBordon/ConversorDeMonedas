package org.example.service;

import java.io.IOException;
import java.net.http.HttpClient;

public class FetchAPI {

  private final String baseURL;
  private final HttpClient client;

  public FetchAPI(String baseURL) {
    this.baseURL = baseURL;
    if (baseURL == null) {
      throw new IllegalArgumentException("baseURL cannot be null");
    }
    this.client = HttpClient.newHttpClient();
  }

  public String fetchData(String endpoint) {
    if (endpoint == null) {
      throw new IllegalArgumentException("path cannot be null");
    }
    try {
      var request = java.net.http.HttpRequest.newBuilder()
          .uri(java.net.URI.create(baseURL + endpoint))
          .build();
      var response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
      return response.body();
    } catch (IOException e) {
      return e.getMessage();
    } catch (InterruptedException e) {
      return e.getMessage();
    }

  }

}
