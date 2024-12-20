package org.example.application;

import java.util.Scanner;

import org.example.model.ExchangeRateData;
import org.example.service.ExchangeAPIService;
import org.example.utils.Screens;

public class Application {

  // API Service
  private final ExchangeAPIService exchangeAPIService;

  public Application() {
    this.exchangeAPIService = new ExchangeAPIService();
  }

  public void run() {
    menuManager();
  }

  private void menuManager() {
    Screens.screenWelcome();
    Screens.screenMenu();
    Scanner scanner = new Scanner(System.in);
    int option = scanner.nextInt();
    switch (option) {
      case 1:
        System.out.println("Conexión a la API");
        testConnection();
        break;
      default:
        System.out.println("Opción no válida");
        break;
    }
  }

  private void testConnection() {
    try {
      ExchangeRateData response = exchangeAPIService.getExchangeRate();

      System.out.println("Base Code: " + response.getBaseCode());
      System.out.println("Conversion Rates: " + response.getConversionRates());
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }

}
