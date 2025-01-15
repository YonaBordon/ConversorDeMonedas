package org.example.application;

import java.util.Map;
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
    while (true) {
      Screens.screenWelcome();
      Screens.screenSpecificCurrencies();
      Screens.screenMenu();
      Scanner scanner = new Scanner(System.in);
      int option = scanner.nextInt();

      switch (option) {
        case 1:
          performPredefinedConversion();
          break;
        case 2:
          performCustomConversion();
          break;
        default:
          System.out.println("Opción no válida");
          break;
      }
    }
  }

  private void performPredefinedConversion() {
    Screens.screenPredefinedConversions();
    Scanner scanner = new Scanner(System.in);
    int conversionOption = scanner.nextInt();
    String fromCurrency, toCurrency;

    switch (conversionOption) {
      case 1:
        fromCurrency = "USD";
        toCurrency = "ARS";
        break;
      case 2:
        fromCurrency = "ARS";
        toCurrency = "USD";
        break;
      case 3:
        fromCurrency = "USD";
        toCurrency = "BRL";
        break;
      case 4:
        fromCurrency = "BRL";
        toCurrency = "USD";
        break;
      case 5:
        fromCurrency = "USD";
        toCurrency = "MXN";
        break;
      case 6:
        fromCurrency = "MXN";
        toCurrency = "USD";
        break;
      default:
        System.out.println("Opción no válida");
        return;
    }

    System.out.println("Ingrese el monto a convertir:");
    double amount = scanner.nextDouble();
    convertCurrency(fromCurrency, toCurrency, amount);

    promptReturnToMenu();
  }

  private void performCustomConversion() {
    Scanner scanner = new Scanner(System.in);

    Screens.screenSpecificCurrencies();
    System.out.println("Ingrese la moneda de origen (ej: USD):");
    String fromCurrency = scanner.nextLine().toUpperCase();

    System.out.println("Ingrese la moneda de destino (ej: ARS):");
    String toCurrency = scanner.nextLine().toUpperCase();

    System.out.println("Ingrese el monto a convertir:");
    double amount = scanner.nextDouble();

    convertCurrency(fromCurrency, toCurrency, amount);

    promptReturnToMenu();
  }

  private void convertCurrency(String fromCurrency, String toCurrency, double amount) {
    try {
      ExchangeRateData response = exchangeAPIService.getExchangeRate();
      Map<String, Double> rates = response.getConversionRates();

      if (!rates.containsKey(fromCurrency) || !rates.containsKey(toCurrency)) {
        System.out.println("Monedas no válidas. Intente nuevamente.");
        return;
      }

      double fromRate = rates.get(fromCurrency);
      double toRate = rates.get(toCurrency);
      double convertedAmount = (amount / fromRate) * toRate;

      System.out.printf("%.2f %s equivale a %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
    } catch (RuntimeException e) {
      System.out.println("Error al realizar la conversión: " + e.getMessage());
    }
  }

  private void promptReturnToMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nPresione Enter para volver a la pantalla de inicio o 0 para cerrar.");
    String input = scanner.nextLine();

    if (input.equals("0")) {
      System.out.println("Cerrando la aplicación. ¡Hasta luego!");
      System.exit(0);
    }
  }
}
